package cn.sunjian.io_newio_channel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import cn.sunjian.utils.Path;

/**
 * java.nio��Channelͨ��
 * 
 * 		FileChannel��
 * 			�ļ�ͨ����˫�������
 * 
 * @author jack
 *
 */
public class FileChannelDemo {

	public static void main(String[] args) throws IOException {
		
		String info[] = {"�й�","ɽ��ʡ","�鶴��","�͵���","�̻ƴ�","�｡"};
		
		File file = new File(Path.deskTop()+"info.txt");
		
		if (file.exists()) {
			file.delete();
		}
		
		FileOutputStream out = null;//�������������
		FileChannel fout = null;//����FileChannel����
		
		out = new FileOutputStream(file);//ʵ���������
		fout = out.getChannel();//�õ������ͨ��
		
		//���е�ֵ�Ի�����Ϊ׼��
		ByteBuffer buffer = ByteBuffer.allocate(1024);//����һ��������
		for(int i=0;i<info.length;i++){
			buffer.put(info[i].getBytes());//�ַ�����Ϊ�ֽ�����Ž�������֮��
		}
		
		buffer.flip();//���軺����
		fout.write(buffer);//д��������������
		fout.close();
		out.close();
		
	}

}
