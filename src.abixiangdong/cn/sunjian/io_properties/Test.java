package cn.sunjian.io_properties;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ����
 * ��ȡָ��Ŀ¼�£�ָ����չ�����ļ���������Ŀ¼�еģ�
 * ��Щ�ļ���·��·��д�뵽һ���ı��ļ��� 
 * 
 * ��˵�����ǽ���һ��ָ����չ�����ļ����б�
 * 
 * ˼·��
 * 1�����������ȱ���
 * 2.Ҫ�ڱ����Ĺ����н��й��ˣ����������������ݶ��洢��������
 * 3.������������������ݽ��б�����������·��д�뵽�ļ���
 * 
 * 
 * @author sunjian
 *
 */
public class Test {

	public static void main(String[] args) throws IOException {
		
		File dir = new File("e:\\selenium");//ָ��Ŀ¼
		
		FilenameFilter filter = new FilenameFilter() {//��������� ���ڲ��ࣩ
			
			@Override
			public boolean accept(File dir, String name) {
				
				return name.endsWith(".java");//���ظ�Ŀ¼�£��ļ�����׺Ϊ.java���ļ�
			}
		};
		
		List<File> list = new ArrayList<File>();//���弯��
		
		getFiles(dir, filter, list);
		
		File destFile = new File(dir,"javalist.txt");//����Ŀ���ļ�
		
		write2File(list, destFile);	
		
	}
	
	/**
	 * ��ָ��Ŀ¼�е����ݽ�����ȱ�����������ָ���Ĺ����������й���
	 * �����˺�����ݴ洢��ָ������List��
	 * 
	 * @param dir
	 * @param filter
	 * @param list
	 */
	public static void getFiles(File dir/*Ŀ¼*/,FilenameFilter filter/*�ļ�������*/,List<File> list/*�洢�����������ݵ�����*/){

		File[] files = dir.listFiles();//��ȡĿ¼�����е�����
		
		for(File file : files){//��������
			if(file.isDirectory()){//�����Ŀ¼
				//�ݹ���
				getFiles(file, filter, list);//�ٶԸ�Ŀ¼���й���
			}else {//�������Ŀ¼
				//�Ա��������ļ����й������Ĺ��ˣ�����������File���󣬴洢��List������
				if (filter.accept(dir/*��ǰĿ¼*/, file.getName()/*��ȡ��ǰĿ¼���ļ�������*/)) {//�Ե�ǰĿ¼�µ��ļ�����ͨ�����������й���
					list.add(file);//�������������ļ���ӵ�list������
				}
			}
		}
	}
	
	/**
	 * ��List�����е�����д�뵽ָ���ļ���
	 * @param list
	 * @param destFile
	 * @throws IOException
	 */
	public static void write2File(List<File> list,File destFile/*Ŀ���ļ�*/) throws IOException{
		
		BufferedWriter bufw = null;//�ַ���
		try {			
			bufw = new BufferedWriter(new FileWriter(destFile));//����д����ļ�
			for(File file:list){//��������
				bufw.write(file.getAbsolutePath()/*��ȡ���ļ��ľ���·��*/);//����ļ���д��
				bufw.newLine();//����
				bufw.flush();//ˢ��
			}
			
			
		}/*catch(IOException e){
			throw new RuntimeException("д��ʧ��");
		}*/finally {
			if (bufw!=null) {
				try{
					bufw.close();//�ر��ַ���
				}catch (IOException e){
					throw new RuntimeException("�ر�ʧ��");
				}
			}
		}
	}
	
	
	
	
	
	

}
