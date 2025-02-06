package org.learn.tech.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jimjian on 15/5/10.
 */
@Slf4j
public class test_InputStream {

    private InputStream inputStream = null;
    private int i = 0;

    //从输入流里读取字节数据
    public void read(String path) {
        try {
            inputStream = this.getClass().getResourceAsStream(path);
            while (true) {
                assert inputStream != null;
                i = inputStream.read();
                if (i == -1) break;
                System.out.print((char) i);
            }
        } catch (Exception e) {
            log.error("read error", e);
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //从输入流里读取块数据
    public void readArray(String path) {
        try {
            inputStream = this.getClass().getResourceAsStream(path);
            assert inputStream != null;
            byte[] b = new byte[inputStream.available()];
            while (true) {
                i = inputStream.read(b);
                if (i == -1) break;
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test_InputStream testInputStream = new test_InputStream();
//        testInputStream.read();
        testInputStream.readArray("");
    }
}
