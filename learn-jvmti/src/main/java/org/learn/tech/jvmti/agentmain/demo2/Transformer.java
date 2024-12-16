package org.learn.tech.jvmti.agentmain.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class Transformer implements ClassFileTransformer {

    //将TransformerTarget.java方法返回值更改之后编译的class文件，把文件名修改成TransformerTarget.class.2
    public static final String classNumberReturns2 = "TransformerTarget.class.2";

    public static byte[] getBytesFromFile(String fileName) {
        try {
            File file = new File(fileName);
            InputStream is = new FileInputStream(file);
            long length = file.length();
            byte[] bytes = new byte[(int) length];

            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }
            is.close();
            return bytes;
        } catch (Exception e) {
            System.out.println("error occurs in _ClassTransformer!" + e.getClass().getName());
            return null;
        }
    }

    public byte[] transform(ClassLoader l,
                            String className,
                            Class<?> c,
                            ProtectionDomain pd,
                            byte[] b) throws IllegalClassFormatException {
        if (!className.equals("TransformerTarget")) {
            return null;
        }
        return getBytesFromFile(classNumberReturns2);
    }
}
