package cn.sunjian.io.randomaccessfile;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *  java��io��
 * 
 * 		RandomAccessFile����ϰ�������ȡ����
 * 
 * 		���д��Ĳ�����ÿ�����ݵĳ��ȶ���12λ��
 * 		��ɶ�ȡ�Ĳ�����
 * 			�����ȡ
 * 
 * @author jack
 *
 */
public class RandomAccessFilesDemo {

	public static void main(String[] args) throws Exception{
		
		File file = new File("e:"+File.separator+"text.txt");//ָ��Ҫ�������ļ�
		
		if (file.exists()) {//����ļ����ڣ���ɾ��
			file.delete();
		}
		
		RandomAccessFile rdf = null;//����RandomAccessFile��Ķ���
		
		rdf = new RandomAccessFile(file, "rw");//��дģʽ������ļ������ڣ����Զ�����
		
		writeContent(rdf,"zhangsan",30);//д������
		writeContent(rdf,"lisi    ", 31);//д������
		writeContent(rdf,"wangwu  ", 32);//д������
		
		
		rdf = new RandomAccessFile(file, "r");//ֻ��ģʽ�£���ȡ�ļ�����
		
		readContent(rdf,12,2);//��ȡ�ڶ����˵���Ϣ
		rdf.seek(0);//ָ��ص���ͷ��λ��
		readContent(rdf,0,1);//��ȡ��һ���˵���Ϣ
		readContent(rdf,12,3);//��ȡ�������˵���Ϣ
		
		rdf.close();//�ر������
	}

	/*
	 * ��ȡ������Ϣ
	 */
	private static void readContent(RandomAccessFile rdf,int num,int man) throws Exception{

		byte[] b = new byte[8];//����byte���飬���ڴ洢��ȡ��������
		
		rdf.skipBytes(num);//����num���ַ�
		for(int i=0;i<b.length;i++){
			b[i] = rdf.readByte();//��ȡһ���ֽ�
		}
		String name = new String(b);//����ȡ������byte�����Ϊ�ַ���
		int age = rdf.readInt();//��ȡ����
		
		System.out.println("��"+man+"���˵���Ϣ--> ������"+name+"  ���䣺"+age);//���������Ϣ
		
	}

	/*
	 * д�������Ϣ
	 */
	private static void writeContent(RandomAccessFile rdf,String name,int age)throws Exception {

		rdf.writeBytes(name);//������д�뵽�ļ���
		rdf.writeInt(age);//������д�뵽�ļ���
		
	}

}
