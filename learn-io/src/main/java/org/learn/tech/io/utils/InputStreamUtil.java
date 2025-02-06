package org.learn.tech.io.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by jimjian on 15/5/10.
 */
@Slf4j
public class InputStreamUtil {

    private InputStream inputStream = null;

    /**
     * 从输入流里读取块数据
     */
    public void readArray(String path) {
        try {
            inputStream = Files.newInputStream(Paths.get(path));
            while (true) {
                byte[] b = new byte[inputStream.available()];
                int i = inputStream.read(b);
                if (i == -1)
                    break;
                System.out.print(new String(b));
            }
        } catch (IOException e) {
            log.error("read file error:", e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                log.error("int put stream close error:", e);
            }
        }
    }
}
