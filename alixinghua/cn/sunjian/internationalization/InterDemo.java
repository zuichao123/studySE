package cn.sunjian.internationalization;

import java.util.ResourceBundle;

/**
 * ���ʻ�������ϰ��
 * 		ResourceBundle���ȡ��Properties�ļ�		
 * 
 * @author jack
 *
 */
public class InterDemo {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("Message");//����д��׺���Զ����ҵ�
		
		System.out.println("���ݣ�"+rb.getString("message"));//����Դ�ļ��ж�ȡ���ݣ�ͨ��key"message"ȥ��value
	}

}
