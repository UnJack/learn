package org.learn.tech.jvmti.compiler;

import javax.tools.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.Arrays;

public class test_compilerapi3 {

    private static void compilerJava() throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        // 定义一个StringWriter类，用于写Java程式
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        // 开始写Java程式
        out.println("public class HelloWorld {");
        out.println(" public static void main(String args[]) {");
        out.println(" System.out.println(\"Hello, World\");");
        out.println(" }");
        out.println("}");
        out.close();
        //为这段代码取个名子：HelloWorld，以便以后使用reflection调用
        JavaFileObject file = new JavaSourceFromString("HelloWorld", writer.toString());
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, null,
                diagnostics, null, null, compilationUnits);
        boolean success = task.call();
        System.out.println((success) ? "编译成功" : "编译失败");
        // 如果成功，通过reflection执行这段Java程式
        if (success) {
            System.out.println("-----输出-----");
            Class.forName("HelloWorld").getDeclaredMethod("main", new Class[]
                    {String[].class}).invoke(null, new Object[]
                    {null});
            System.out.println("-----输出 -----");
        }
    }

    public static void main(String args[]) throws Exception {
        compilerJava();
    }

}

// 用于传递源程式的JavaSourceFromString类
class JavaSourceFromString extends SimpleJavaFileObject {
    final String code;

    JavaSourceFromString(String name, String code) {
        super(URI.create("/Users/jimjian/itest/iGithub/Java/src/main/java/com/java/base/instrumentation/compiler/" + name.replace(".", "/") + Kind.SOURCE.extension), Kind.SOURCE);
//        super(URI.create("string:///" + name.replace(".", "/") + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}


