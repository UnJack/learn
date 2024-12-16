package org.learn.tech.io.bio;

import org.learn.tech.io.test_FileUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by jimjian on 15/5/24.
 */
public class OutputStreamUtil extends test_FileUtil {

    private OutputStream outputStream=null;

    public void write(){
        try {
            outputStream=new FileOutputStream(FILE_PATH);
            String string="abcjane";
            outputStream.write(string.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
