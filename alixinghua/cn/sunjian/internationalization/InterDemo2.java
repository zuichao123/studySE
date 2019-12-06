package cn.sunjian.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ���ʻ�������ϰ��
 * 		ResourceBundle���ȡ��Properties�ļ�	
 * 
 * 		���ݲ�ͬ�Ĺ��������ͬ���ҵ���ã�
 * 			���ģ����
 * 			Ӣ�hello
 * 			���Bonjour
 * 		�ֱ��岻ͬ����Դ�ļ�����ʱ��Ҫ����������Դ�ļ���ͬʱ�ڶ����ļ���ʱ����Ҫָ���ô���Դ�ļ���Ӧ�����Ա��룺
 * 			���ģ�Message_zh_CN.properties
 * 			Ӣ�ģ�Message_en_US.properties
 * 			���ģ�Message_fr_FR.properties
 * 	
 * 		����Locale��ָ�������ISO��ͬ���õ���ͬ����Դ�ļ��е����ݡ�
 * 
 * 
 * @author jack
 *
 */
public class InterDemo2 {

	public static void main(String[] args) {

		Locale zhLoc = new Locale("zh", "CN");//��ʾ�й�����
		Locale enLoc = new Locale("en", "US");//��ʾ��������
		Locale frLoc = new Locale("fr", "FR");//��ʾ��������
		
		//�ҵ����ĵ������ļ�����Ҫָ�����ĵ�Locale����
		ResourceBundle zhrb = ResourceBundle.getBundle("Message",zhLoc);//����д��׺���Զ����ҵ�
		//�ҵ�Ӣ��������ļ�����Ҫָ��Ӣ���Locale����
		ResourceBundle enrb = ResourceBundle.getBundle("Message",enLoc);//����д��׺���Զ����ҵ�
		//�ҵ�����������ļ�����Ҫָ�������Locale����
		ResourceBundle frrb = ResourceBundle.getBundle("Message",frLoc);//����д��׺���Զ����ҵ�
		
		System.out.println("���ݣ�"+zhrb.getString("info"));//����Դ�ļ��ж�ȡ���ݣ�ͨ��key"info"ȥ��value
		System.out.println("���ݣ�"+enrb.getString("info"));//����Դ�ļ��ж�ȡ���ݣ�ͨ��key"info"ȥ��value
		System.out.println("���ݣ�"+frrb.getString("info"));//����Դ�ļ��ж�ȡ���ݣ�ͨ��key"info"ȥ��value
	}

}
