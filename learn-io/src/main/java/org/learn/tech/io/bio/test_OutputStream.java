package org.learn.tech.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by jimjian on 15/5/24.
 */
@Slf4j
public class test_OutputStream {

    private OutputStream outputStream = null;

    public void write(String path) {
        try {
            outputStream = Files.newOutputStream(Paths.get(path));
            String string = "testOutputStream run...";
            outputStream.write(string.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            log.error("write file path={} error", path, e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("out put stream close error:", e);
                }
            }
        }
        System.out.println("写入文件" + path + "成功!");
    }

    public static void main(String[] ags) {
        test_OutputStream testOutputStream = new test_OutputStream();
        testOutputStream.write("");
    }
}
