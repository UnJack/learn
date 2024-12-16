package org.learn.tech.io;

import java.io.*;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Created by jimjian on 2019-05-03.
 * 文件流转Stream
 */
public class test_BufferedReader2Steam {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            File file = new File("README.md");
            System.out.println(file.getCanonicalPath());
            InputStream inputStream = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            System.out.println(bufferedReader.lines().mapToInt(String::length).max().getAsInt());
            System.out.println(bufferedReader.lines().collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
