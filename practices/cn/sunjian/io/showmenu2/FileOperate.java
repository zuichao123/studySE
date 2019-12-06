package cn.sunjian.io.showmenu2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ��ϰ��������Ϣ�������
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
		
		try{
			oos = new ObjectOutputStream(new FileOutputStream(this.file));
			oos.writeObject(obj);//д�����
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
		
		try {
			ois = new ObjectInputStream(new FileInputStream(this.file));
			obj = ois.readObject();//��ȡ����
		} catch(Exception e){
			throw e;
		}finally {
			ois.close();
		}
		
		return obj;
	}
}
