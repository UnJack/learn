package org.learn.tech.io.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by jimjian on 15/7/5.
 */
@Slf4j
public class BaiduReader {

    private final Charset charset = Charset.forName("GBK");// 创建GBK字符集
    private SocketChannel channel;

    public static void main(String[] args) {
        new BaiduReader().readHTMLContent();
    }

    public void readHTMLContent() {
        try {
            InetSocketAddress socketAddress = new InetSocketAddress("www.qq.com", 80);
            //step1:打开连接
            channel = SocketChannel.open(socketAddress);
            //step2:发送请求，使用GBK编码
            channel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));
            //step3:读取数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);// 创建1024字节的缓冲
            while (channel.read(buffer) != -1) {
                buffer.flip();// flip方法在读缓冲区字节操作之前调用。
                System.out.println(charset.decode(buffer));
                // 使用Charset.decode方法将字节转换为字符串
                buffer.clear();// 清空缓冲
            }
        } catch (IOException e) {
            log.error("io exception:", e);
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    log.error("channel close exception:", e);
                }
            }
        }
    }

}
