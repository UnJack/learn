package org.learn.tech.jvmti.compiler;

import javax.tools.*;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;

public class test_compilerapi2 {
    private static void compilejava() throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        JavaFileObject javaFileObject = constructTestor();
        Iterable<? extends JavaFileObject> files = Arrays.asList(javaFileObject);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
                null, null, null, files);
        boolean success = task.call();
        fileManager.close();
        System.out.println((success) ? "编译成功" : "编译失败");
    }

    public static void main(String args[]) throws Exception {
        compilejava();
    }

    private static SimpleJavaFileObject constructTestor() throws Exception {
        StringBuilder stringBuilder = new StringBuilder("" +
                "package test;\n" +
                "import test.test;\n" +
                "class demoTest {\n" +
                "public void testMethod(){\n" +
                "test t=new test();\n" +
                "System.out.println(\"t.sum=\"+t.sum(1,2));\n" +
                "}\n" +
                "public static void main(String[] args){\n" +
                "demoTest d=new demoTest();\n" +
                "d.testMethod();\n" +
                "}\n" +
                "}\n");
        StringObject file = new StringObject("test.demoTest", stringBuilder.toString());
        return file;
    }
}

class StringObject extends SimpleJavaFileObject {
    private String contents = null;

    public StringObject(String className, String contents) throws Exception {
        super(new URI(className), Kind.SOURCE);
        this.contents = contents;
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors)
            throws IOException {
        return contents;
    }
}