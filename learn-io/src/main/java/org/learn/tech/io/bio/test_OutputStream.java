package org.learn.tech.io.bio;

import java.io.*;

/**
 * Created by jimjian on 15/5/24.
 */
public class test_OutputStream extends FileUtil {

    private OutputStream outputStream = null;

    public void write() {
        try {
            outputStream = new FileOutputStream(WRITE_PATH);
            String string = "testOutputStream run...";
            outputStream.write(string.getBytes());
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("写入文件" + WRITE_PATH + "成功!");
    }

    public static void main(String[] ags) {
        test_OutputStream testOutputStream = new test_OutputStream();
        testOutputStream.write();
    }
}
