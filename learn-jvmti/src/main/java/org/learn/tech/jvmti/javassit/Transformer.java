package org.learn.tech.jvmti.javassit;

import javassist.*;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transformer implements ClassFileTransformer {

    final static String prefix = "\nlong startTime = System.currentTimeMillis();\n";
    final static String postfix = "\nlong endTime = System.currentTimeMillis();\n";

    // 被处理的方法列表
    final static Map<String, List<String>> methodMap = new HashMap<>();

    public Transformer() {
        add("agent.TimeTest.sayHello1");
        add("agent.TimeTest.sayHello2");
    }

    private void add(String methodString) {
        String className = methodString.substring(0, methodString.lastIndexOf("."));
        String methodName = methodString.substring(methodString.lastIndexOf(".") + 1);
        List<String> list = methodMap.get(className);
        if (list == null) {
            list = new ArrayList<>();
            methodMap.put(className, list);
        }
        list.add(methodName);
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className = className.replace("/", ".");
        if (methodMap.containsKey(className)) {
            CtClass ctclass = null;
            try {
                ctclass = ClassPool.getDefault().get(className);
                for (String methodName : methodMap.get(className)) {
                    CtMethod ctmethod = ctclass.getDeclaredMethod(methodName);
                    String newMethodName = methodName + "$old";
                    ctmethod.setName(newMethodName);
                    CtMethod newMethod = CtNewMethod.copy(ctmethod, methodName, ctclass, null);

                    StringBuilder methodBody = new StringBuilder();
                    methodBody.append("{");
                    methodBody.append(prefix);
                    methodBody.append(newMethodName + "($$);\n");
                    methodBody.append(postfix);
                    methodBody.append("\nSystem.out.println(\"current method = " + methodName + " 耗时 = \" +(endTime - startTime) +\"ms.\");");
                    methodBody.append("}");
                    newMethod.setBody(methodBody.toString());
                    ctclass.addMethod(newMethod);

                    //CtMethod ctMethod1 = CtNewMethod.make("public static void sendSalary(){System.out.println(\"send Salary...\");}", ctclass);
                    //ctclass.addMethod(ctMethod1);
                }

                CtMethod ctMethod = new CtMethod(CtClass.voidType, "printInfo", new CtClass[]{}, ctclass);
                ctMethod.setModifiers(Modifier.PUBLIC);
                StringBuilder buffer2 = new StringBuilder();
                buffer2.append("{");
                buffer2.append("\nSystem.out.println(\"send Salary $10000...\");");
                buffer2.append("}");
                ctMethod.setBody(buffer2.toString());
                ctclass.addMethod(ctMethod);
                System.out.println(ctMethod.getName());

                Class clazzz = ctclass.toClass();
                Object obj = clazzz.newInstance();
                clazzz.getMethod("sendSalary").invoke(obj);

                byte[] byteArr = ctclass.toBytecode();
                FileOutputStream fos = new FileOutputStream(new File("D://TimeTest.class"));
                fos.write(byteArr);
                fos.close();
                return ctclass.toBytecode();
            } catch (Exception e) {
                try {
                    byte[] byteArr = ctclass.toBytecode();
                    FileOutputStream fos = new FileOutputStream(new File("D://TimeTest.class"));
                    fos.write(byteArr);
                    fos.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }
        return null;
    }
}