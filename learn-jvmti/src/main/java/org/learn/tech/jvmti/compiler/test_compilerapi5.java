package org.learn.tech.jvmti.compiler;

import javax.tools.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test_compilerapi5 {
    public static void main(String[] args) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardJavaFileManage = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> files = standardJavaFileManage.getJavaFileObjectsFromStrings(Arrays.asList("/Users/jimjian/itest/iGithub/Java/test.java"));
        DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector();
        JavaCompiler.CompilationTask compilationTask = compiler.getTask(null, standardJavaFileManage, collector, null, null, files);
        Boolean result = compilationTask.call();
        List<Diagnostic<? extends JavaFileObject>> diagnostics = collector.getDiagnostics();
        Map<Long, Long> map = new HashMap();
        for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics) {
            if (map.containsKey(diagnostic.getLineNumber())) {
                System.out.printf(
                        "Code: %s%n" +
                                "Line Number: %s%n" +
                                "Kind: %s%n" +
                                "Position: %s%n" +
                                "Start Position: %s%n" +
                                "End Position: %s%n" +
                                "Source: %s%n" +
                                "Message: %s%n" +
                                "Column Number: %s%n",
                        diagnostic.getCode(), diagnostic.getLineNumber(), diagnostic.getKind(),
                        diagnostic.getPosition(), diagnostic.getStartPosition(), diagnostic.getEndPosition(),
                        diagnostic.getSource(), diagnostic.getMessage(Locale.ENGLISH), diagnostic.getColumnNumber());
                printErrorCode((int) diagnostic.getLineNumber());
                System.out.println("\n");
            }
            map.put(diagnostic.getLineNumber(), diagnostic.getLineNumber());
        }

        System.out.println("编译 " + (result ? "Succeeded" : "fail"));
    }

    private static void printErrorCode(int targetLine) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("/Users/jimjian/itest/iGithub/Java/test.java"));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String sline;
        for (int line = 1; (sline = bufferedReader.readLine()) != null; line++) {
            if (line == targetLine)
                System.out.println("Code line =" + sline);
        }
    }
}
