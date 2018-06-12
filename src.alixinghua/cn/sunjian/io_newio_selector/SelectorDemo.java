package cn.sunjian.io_newio_selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * java新io：Selector
 * 
 * 		非阻塞的网络服务；
 * 	
 * 	需求：
 * 		使用Selector完成一个简单的服务器操作，
 * 		服务器可以同时在多个端口进行监听，
 * 		此服务器的主要功能时返回当前的时间
 * 
 * @author jack
 *
 */
public class SelectorDemo {

	public static void main(String[] args) throws Exception {

		int ports[] = {18000,18001,18002,18003,18004};//定义一组端口
		
		Selector selector = Selector.open();//通过open()方法找到Selector
		
		for(int i=0;i<ports.length;i++){
			ServerSocketChannel initSer = null;
			initSer = ServerSocketChannel.open();//打开服务器的通道
			
			initSer.configureBlocking(false);//服务器配置为阻塞
			
			ServerSocket initSock = initSer.socket();
			InetSocketAddress address = null;
			
			address = new InetSocketAddress(ports[i]);//实例化绑定地址
			initSock.bind(address);//进行服务的绑定
			
			initSer.register(selector, SelectionKey.OP_ACCEPT);//等待连接
			
			System.out.println("服务器运行，在"+ports[i]+"端口监听。。。");
		}
		
		//要接收全部生成的key，并通过连接进行判断是否获取客户端的输出
		@SuppressWarnings("unused")
		int keysAdd = 0;
		while((keysAdd = selector.select()) > 0){//选择一组键，并且相应的通道已经准备就绪
			Set<SelectionKey> selectionKeys = selector.selectedKeys();//取出全部生成的key
			
			Iterator<SelectionKey> iter = selectionKeys.iterator();
			while(iter.hasNext()){
				SelectionKey key = iter.next();
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					
					SocketChannel client = server.accept();//接收新连接
					client.configureBlocking(false);//配置为非阻塞
					
					ByteBuffer outBuf = ByteBuffer.allocateDirect(1024);
					outBuf.put(("当前时间为："+new Date()).getBytes());//向缓冲区中设置内容
					
					outBuf.flip();//重设缓冲区
					client.write(outBuf);//输出内容
					client.close();//关闭
				}
			}
			selectionKeys.clear();//清除全部的key
		}
		
	}

}
