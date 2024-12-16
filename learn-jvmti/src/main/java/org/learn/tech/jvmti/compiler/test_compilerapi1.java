package org.learn.tech.jvmti.compiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

public class test_compilerapi1 {
    public static void main(String args[]) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int results = compiler.run(null, null, null, "/Users/jimjian/itest/iGithub/Java/test.java");
        System.out.println((results == 0) ? "编译成功" : "编译失败");
        // 在程式中运行test
        Runtime run = Runtime.getRuntime();
        Process p = run.exec("java test");
        BufferedInputStream in = new BufferedInputStream(p.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
}


