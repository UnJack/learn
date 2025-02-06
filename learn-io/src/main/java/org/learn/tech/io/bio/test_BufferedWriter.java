package org.learn.tech.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

/**
 * Created by jimjian on 15/5/10.
 */
@Slf4j
public class test_BufferedWriter {

    private BufferedWriter bufferedWriter;

    public void writer() {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL resourceURL = classLoader.getResource("");
            assert resourceURL != null;
            File file2 = new File(resourceURL.toURI());
            for (File file : Objects.requireNonNull(file2.listFiles())) {
                System.out.println("file = " + file);
            }
//            Enumeration<URL> urls = classLoader.getResources("src/main/resources");
            URL url = test_BufferedWriter.class.getClassLoader().getResource("");
            assert url != null;
//            "src/main/resources"
            File file1 = new File(url.getPath());
            for (File file : Objects.requireNonNull(file1.listFiles())) {
                System.out.println("file = " + file);
            }
            File file = new File(url.getPath() + "jim1.txt");
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            bufferedWriter.write("hello writer1...");
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            log.error("io exception:", e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                log.error("buffer close exception:", e);
            }
        }
        System.out.println("写入文件成功...");
    }

    public static void main(String[] args) {
        test_BufferedWriter b = new test_BufferedWriter();
        b.writer();
    }
}
