package org.learn.tech.io.nio;

import lombok.extern.slf4j.Slf4j;
import org.learn.tech.io.utils.FileConstant;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jimjian on 15/7/5.
 */
@Slf4j
public class test_CopyFile {

    public static void main(String[] args) {
        try {
            // 获取源文件和目标文件的输入输出流
            FileInputStream fin = new FileInputStream(FileConstant.DEFAULT_PATH + "");
            FileOutputStream out = new FileOutputStream(FileConstant.DEFAULT_PATH + "");
            // 获取输入输出通道
            FileChannel facing = fin.getChannel();
            FileChannel flout = out.getChannel();
            // 创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                // clear方法重设缓冲区，使它可以接受读入的数据
                buffer.clear();
                // 从输入通道中将数据读到缓冲区
                int r = facing.read(buffer);
                // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
                if (r == -1) break;
                // flip方法让缓冲区可以将新读入的数据写入另一个通道
                buffer.flip();
                // 从输出通道中将数据写入缓冲区
                int bytesWritten = flout.write(buffer);
                if (bytesWritten < buffer.limit()) {
                    log.error("处理未完全写入的情况");
                }
            }
            fin.close();
        } catch (Exception e) {
            log.error("e=", e);
        }
    }
}
