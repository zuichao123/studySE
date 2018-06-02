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
 * java��io��Selector
 * 
 * 		���������������
 * 	
 * 	����
 * 		ʹ��Selector���һ���򵥵ķ�����������
 * 		����������ͬʱ�ڶ���˿ڽ��м�����
 * 		�˷���������Ҫ����ʱ���ص�ǰ��ʱ��
 * 
 * @author jack
 *
 */
public class SelectorDemo {

	public static void main(String[] args) throws Exception {

		int ports[] = {18000,18001,18002,18003,18004};//����һ��˿�
		
		Selector selector = Selector.open();//ͨ��open()�����ҵ�Selector
		
		for(int i=0;i<ports.length;i++){
			ServerSocketChannel initSer = null;
			initSer = ServerSocketChannel.open();//�򿪷�������ͨ��
			
			initSer.configureBlocking(false);//����������Ϊ����
			
			ServerSocket initSock = initSer.socket();
			InetSocketAddress address = null;
			
			address = new InetSocketAddress(ports[i]);//ʵ�����󶨵�ַ
			initSock.bind(address);//���з���İ�
			
			initSer.register(selector, SelectionKey.OP_ACCEPT);//�ȴ�����
			
			System.out.println("���������У���"+ports[i]+"�˿ڼ���������");
		}
		
		//Ҫ����ȫ�����ɵ�key����ͨ�����ӽ����ж��Ƿ��ȡ�ͻ��˵����
		@SuppressWarnings("unused")
		int keysAdd = 0;
		while((keysAdd = selector.select()) > 0){//ѡ��һ�����������Ӧ��ͨ���Ѿ�׼������
			Set<SelectionKey> selectionKeys = selector.selectedKeys();//ȡ��ȫ�����ɵ�key
			
			Iterator<SelectionKey> iter = selectionKeys.iterator();
			while(iter.hasNext()){
				SelectionKey key = iter.next();
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					
					SocketChannel client = server.accept();//����������
					client.configureBlocking(false);//����Ϊ������
					
					ByteBuffer outBuf = ByteBuffer.allocateDirect(1024);
					outBuf.put(("��ǰʱ��Ϊ��"+new Date()).getBytes());//�򻺳�������������
					
					outBuf.flip();//���軺����
					client.write(outBuf);//�������
					client.close();//�ر�
				}
			}
			selectionKeys.clear();//���ȫ����key
		}
		
	}

}
