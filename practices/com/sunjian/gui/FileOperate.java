package com.sunjian.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ��ϰ��������Ϣ��������
 * 
 * 		д�롢��ȡ����
 * 
 * @author sunjian
 *
 */
public class FileOperate {

	private File file = null;
	
	public FileOperate(String str){//���촫���ļ�·��
		this.file = new File(str);
	}
	
	//�������л�������ʹ�ö��������д�����
	public boolean save(Object obj) throws Exception{//�������
		
		ObjectOutputStream oos = null;//���������
		boolean flag = false;//���������־λ
		
		if (!this.file.exists()) {
			this.file.createNewFile();
		}
		
		try{
			oos = new ObjectOutputStream(new FileOutputStream(this.file,true));
			oos.writeObject(obj);//д�����
			oos.flush();
			flag = true;
		}catch(Exception e){
			throw e;//���쳣���������ô�����
		}finally {
			oos.close();//�رն��������
		}
		
		return flag;
	}
	
	//�������л�������ʹ�ö�����������ȡ����
	public Object load() throws Exception{
		Object obj = null;//���ն�ȡ������
		ObjectInputStream ois = null;//����������
		
		if (this.file.exists() && this.file.length()>0) {		
			try {
				ois = new ObjectInputStream(new FileInputStream(this.file));
				obj = ois.readObject();
			} catch(Exception e){
				throw e;
			}finally {
				ois.close();
			}
		}		
		
		return obj;
	}
	
}