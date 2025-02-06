package org.learn.tech.io;

import java.io.*;
import java.net.URL;

/**
 * User: jimjian
 * Date: 16-5-15 上午11:30
 */
public class test_FileWrite {

    public static void main(String[] args) {

        try {
            URL resource = test_FileWrite.class.getClassLoader().getResource("");
            assert resource != null;
            String path = resource.getPath();

            File file = new File(path);
            File[] files = file.listFiles();
            assert files != null;
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    System.out.println("file1 = " + file1);
                }
                System.out.println("file1 = " + file1);
            }
//            String str = "问阿萨德阿萨德阿萨德 asd";
//            FileOutputStream outputStream = new FileOutputStream(file);
//            outputStream.write(str.getBytes());
            //            outputStream.close();
            InputStream in = new FileInputStream(file);
            byte[] b = new byte[100];
            int num = 0;
            while ((num = in.read(b)) != -1) {
                System.out.write(b, 0, num);
                System.out.println(new String(b, 0, num));
            }
            InputStreamReader read = new InputStreamReader(in);
            while (read.read() != -1) {
                System.out.println((char) read.read());
            }
//            OutputStreamWriter ow=new OutputStreamWriter(outputStream);
//
//            ow.write("\n我爱你，去你妹的");
//            ow.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
