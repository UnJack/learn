package org.learn.tech.io.bio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jimjian on 15/5/10.
 */
public class test_InputStream extends FileUtil {
    private InputStream inputStream = null;
    private int i = 0;
    private byte[] b = null;

    //从输入流里读取字节数据
    public void read() {
        try {
            inputStream = this.getClass().getResourceAsStream(READ_PATH);
            while (true) {
                i = inputStream.read();
                if (i == -1) break;
                System.out.print((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //从输入流里读取块数据
    public void readArray() {
        try {
            inputStream = this.getClass().getResourceAsStream(READ_PATH);
            b = new byte[inputStream.available()];
            while (true) {
                i = inputStream.read(b);
                if (i == -1) break;
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test_InputStream testInputStream = new test_InputStream();
//        testInputStream.read();
        testInputStream.readArray();
    }
}
