package org.learn.tech.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * User: jimjian
 * Date: 16-6-24 下午4:29
 */
public class NIOClient {

    private Selector selector;

    public static void main(String[] args) {
        NIOClient nioClient = new NIOClient();
        nioClient.init("localhost", 6666);
        nioClient.listen();
    }

    public void init(String ip, int port) {
        try {
            //获得一个Socket通道
            SocketChannel socketChannel = SocketChannel.open();
            //设置非阻塞
            socketChannel.configureBlocking(false);
            //获得一个通道管理器
            this.selector = Selector.open();
            // 客户端连接服务器,其实方法执行并没有实现连接，需要在listen（）方法中调
            //用channel.finishConnect();才能完成连接
            socketChannel.connect(new InetSocketAddress(ip, port));
            //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        while (true) {
            try {
                selector.select();
                Iterator iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = (SelectionKey) iterator.next();
                    // 删除已选的key,以防重复处理
                    iterator.remove();
                    // 连接事件发生
                    if (selectionKey.isConnectable()) {
                        write(selectionKey);
                    } else if (selectionKey.isReadable()) {
                        read(selectionKey);
                    }
                }
            } catch (ClosedChannelException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        // 如果正在连接，则完成连接
        if (channel.isConnectionPending()) {
            try {
                channel.finishConnect();
                // 设置成非阻塞
                channel.configureBlocking(false);
                //在这里可以给服务端发送信息哦
                channel.write(ByteBuffer.wrap(new String("this is client...").getBytes("UTF-8")));
                //在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                channel.register(this.selector, SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void read(SelectionKey key) {
        // 服务器可读取消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        try {
            channel.read(buffer);
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            System.out.println("客户端收到信息：" + msg);
            ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes("UTF-8"));
            channel.write(outBuffer);// 将消息回送给客户端
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
