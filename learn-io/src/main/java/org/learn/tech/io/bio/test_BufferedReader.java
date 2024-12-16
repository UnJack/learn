package org.learn.tech.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Created by jimjian on 15/5/1.
 */
public class test_BufferedReader extends FileUtil {
    private BufferedReader bufferedReader = null;
    public void read() {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(READ_PATH);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                String str = bufferedReader.readLine();
                if (str == null) {
                    break;
                }
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        test_BufferedReader b=new test_BufferedReader();
        b.read();
    }
}
