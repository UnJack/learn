package org.learn.tech.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * User: jimjian
 * Date: 16-6-21 下午6:20
 */
public class NIOServer {


    //通道管理器
    //服务端和客户端各自维护一个管理通道的对象，我们称之为selector，
    // 该对象能检测一个或多个通道 (channel) 上的事件。
    private Selector selector;

    public static void main(String[] args) {
        NIOServer nioServer = new NIOServer();
        nioServer.init(6666);
        nioServer.listen();
    }

    public void init(int port) {
        try {
            // 获得一个ServerSocket通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 设置通道为非阻塞
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            // 获得一个通道管理器
            this.selector = Selector.open();
            // 服务端接收客户端连接事件SelectionKey.OP_ACCEPT(16)
            // 客户端连接服务端事件SelectionKey.OP_CONNECT(8)
            // 写事件SelectionKey.OP_WRITE(4)
            // 读事件SelectionKey.OP_READ(1)

            //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
            //当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        System.out.println("服务端启动成功！");
        //轮询访问selector
        while (true) {
            try {
                //当注册的事件到达时，方法返回；否则,该方法会一直阻塞
                selector.select();
                //获得selector中选中的项的迭代器，选中的项为注册的事件
                Iterator iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = (SelectionKey) iterator.next();
                    //删除已选的key,以防重复处理
                    iterator.remove();
                    //客户端请求连接事件
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        //获得和客户端连接的通道
                        SocketChannel socketChannel = null;
                        try {
                            socketChannel = server.accept();
                            //设置成非阻塞
                            socketChannel.configureBlocking(false);
                            socketChannel.write(ByteBuffer.wrap(new String("server send to client").getBytes("UTF-8")));
                            //在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
                            socketChannel.register(this.selector, SelectionKey.OP_READ);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (key.isReadable()) {
                        read(key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //处理读取客户端发来的信息的事件
    public void read(SelectionKey key) {
        // 服务器可读取消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        try {
            channel.read(buffer);
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            System.out.println("服务端收到信息：" + msg);
            ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes("UTF-8"));
            channel.write(outBuffer);// 将消息回送给客户端
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
