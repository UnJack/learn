package org.learn.tech.io.bio;

import java.io.*;

/**
 * Created by jimjian on 15/5/10.
 */
public class test_BufferedWriter extends FileUtil {
    private BufferedWriter bufferedWriter;

    public void writer() {
        try {
            File file = new File(WRITE_PATH);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            bufferedWriter.write("hello writer1...");
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("写入文件成功...");
    }

    public static void main(String[] args) {
        test_BufferedWriter b = new test_BufferedWriter();
        b.writer();
    }
}
