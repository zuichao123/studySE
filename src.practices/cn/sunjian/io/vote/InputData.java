package cn.sunjian.io.vote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2.����������
 * 
 * @author sunjian
 *
 */
public class InputData {

	private BufferedReader bufr = null;//��������
	
	public InputData(){//����ʵ������BufferedReader:ʵ�ֽ��ռ�����������	
		this.bufr = new BufferedReader(new InputStreamReader(System.in));
	}
	
	//�õ��ַ���
	public String getString(String info){
		String temp = null;//������������	
		System.out.println(info);
		
		try{
			temp = this.bufr.readLine();//��������
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return temp;
	}
	
	//�õ���������
	public int getInt(String info,String err){
		int temp = 0;//����ת�������������
		String str = null;//������������
		boolean flag = true;//����һ��ѭ�����
		
		while(flag){//ѭ���ж����������
			str = this.getString(info);	
			if (str.matches("\\d+")) {//�����жϣ�����������Ƿ�������
				temp = Integer.parseInt(str);//���ַ������֣�ת������������
				flag = false;//�޸ı��λ���˳�ѭ��
			}else {
				System.out.println(err);
			}
		}
		
		return temp;
	}
}
