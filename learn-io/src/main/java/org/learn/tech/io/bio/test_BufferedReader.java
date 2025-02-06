package org.learn.tech.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by jimjian on 15/5/1.
 */
@Slf4j
public class test_BufferedReader {

    private BufferedReader bufferedReader = null;

    public void read(URI readPath, String writeUrl) {
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(readPath));
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeUrl + "jim.txt", true)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.info(line);
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            log.error("buffer read exception:", e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                log.error("buffer close exception:", e);
            }
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        //读文件路径
        URL url = test_BufferedReader.class.getClassLoader().getResource("example.txt");
        assert url != null;

        //写文件路径
        URL writeUrl = test_BufferedReader.class.getClassLoader().getResource("");
        assert writeUrl != null;

        test_BufferedReader b = new test_BufferedReader();
        b.read(url.toURI(), writeUrl.getPath());
    }
}
