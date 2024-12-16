package org.learn.tech.io.bio;

import org.learn.tech.io.test_FileUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jimjian on 15/5/10.
 *
 */
public class InputStreamUtil extends test_FileUtil {
    private InputStream inputStream=null;
    private int i=0;
    private byte[] b=null;

    /**
     * 从输入流里读取块数据
     */
    public void readArray(){
        try {
            inputStream = this.getClass().getResourceAsStream(IN_FILE_PATH);
            while (true) {
                b=new byte[inputStream.available()];
                i = inputStream.read(b);
                if(i==-1)
                    break;
                System.out.print(new String(b));
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
}
