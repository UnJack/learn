package org.learn.tech.io.nio;


import org.learn.tech.io.bio.FileUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jimjian on 15/7/15.
 */
public class TestFileChannel extends FileUtil {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(WRITE_PATH);
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining())
                    System.out.print((char) byteBuffer.get());
                byteBuffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
