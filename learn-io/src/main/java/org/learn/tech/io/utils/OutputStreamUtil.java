package org.learn.tech.io.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by jimjian on 15/5/24.
 */
@Slf4j
public class OutputStreamUtil {

    private BufferedWriter outputStream = null;

    public void write(String path) {
        try {
            outputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)));
            String string = "横眉冷对千夫指，俯首甘为孺子牛。\n";
            outputStream.write(string);
            outputStream.flush();
            log.info("{} write file success!", path);
        } catch (IOException e) {
            log.error("write file error:", e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                log.error("out put stream close error:", e);
            }
        }
    }

    public static void main(String[] args) {
        URL url = OutputStreamUtil.class.getClassLoader().getResource("");
        Objects.requireNonNull(url, "url is null");
        String path = url.getPath() + UUID.randomUUID();
        OutputStreamUtil outputStreamUtil = new OutputStreamUtil();
        outputStreamUtil.write(path);
    }
}
