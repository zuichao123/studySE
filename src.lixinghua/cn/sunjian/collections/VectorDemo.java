package cn.sunjian.collections;

import java.util.Vector;
import java.util.Collection;
import java.util.List;

/**
 * ���ϣ�List�ӿ�
 * 	
 *		Vector�ӿڣ�
 *			������ݣ�
 *				���һ������
 *				���һ������
 *				��ָ��λ�����һ����һ������ 		
 * 			ɾ�����ݣ�
 *				List�д�������ɾ�������ݶ������ݡ����ݶ���ı�ţ� 	
 *			������ݣ�
 *				���򡢷������
 *				size()
 *			ȡ�����ݣ�
 *				toArray()
 *			��ȡ�ַ�����
 *				subList(int i1,int i2)
 *			�ж��Ƿ�Ϊ�գ�
 *				isEmpty()
 *			�ж϶����Ƿ���ڣ�
 *				contains("xxx")
 *			�����ַ�����λ�ã�
 *				indexOf("xxx")			
 *
 *
 * @author jack
 *
 */
public class VectorDemo {

	public static void main(String[] args) {

		List<String> allList = null;
		allList = new Vector<String>();//ʵ����List��ָ�������ķ���ΪString
		
		System.out.println("���****************************************************");
		allList.add("hello1");//������ݣ��˷�����Collection�ӿڶ���
		allList.add("hello2");
		allList.add("hello3");
		allList.add("world!");//Ĭ������£���������
		allList.add(0,"world1!");//ָ��λ����ӣ����ڵ�һ��λ����ӣ�
		
		
		Collection<String> allCollection = null;
		allCollection = new Vector<String>();//ָ��һ������
		
		allCollection.add("sunjian");//��Collection�м�������
		allCollection.add("nihao");
		
		allList.addAll(allCollection);//���һ������
		allList.addAll(0,allCollection);//ָ��λ����ӣ����ڵ�һ��λ�ô����һ�����ݣ�
		
		System.out.println(allList);//����toString�������
		
		System.out.println("\n\nɾ��******************************************************");
		
		allList.remove(1);//ɾ����һ��Ԫ�أ�ָ��ɾ����λ��
		allList.remove("hello");//�˷�����Collection�ӿڼ̳ж�����ɾ����һ��helloԪ�� ��
		System.out.println(allList);//����toString�������
	
		System.out.println("\n\n���*********************************************************");
		
		/*
		 * �������ʽ��List�ӿ������еģ��������ӿ���û�еģ�������Collection����û�и�������ȡ�����ݵĲ���
		 */
		System.out.print("��ǰ��������");
		for(int i=0;i<allList.size();i++){
			System.out.print(allList.get(i)+"��");
		}
		
		System.out.print("\n�ɺ���ǰ�����");
		for(int i=allList.size()-1;i>=0;i--){
			System.out.print(allList.get(i)+"��");
		}
		
		System.out.println("\n\nȡ��************************************************************");
		
		System.out.print("ָ���������͵ķ�ʽ��");
		String str[] = allList.toArray(new String[]{});//ָ�������ͣ�����ָ������������String��
		for(int i=0;i<allList.size();i++){
			System.out.print(str[i]+"��");
		}
		
		System.out.print("\n���ض�������ķ�ʽ��");
		Object obj[] = allList.toArray();//����Object����
		for(int i=0;i<obj.length;i++){
			String temp = (String) obj[i];//����ת��
			System.out.print(temp+"��");
		}
		
		
		/*
		 * ��ȡ�ַ������ַ���ָ��λ�á������ַ����������Ƿ���ڣ����Ƿ�Ϊ��
		 */
		System.out.println("\n\n��ȡ�ַ������ַ���ָ��λ�á������ַ����������Ƿ���ڣ����Ƿ�Ϊ��***********************");
	
		System.out.println(allList.contains("sunjian")?"\"sunjian\"�ַ������ڣ�":"sunjian�ַ��������ڣ�");
		System.out.println("sunjian�ַ������ڵ�λ�ã�"+allList.indexOf("sunjian"));
		System.out.println("���ϲ������Ƿ�Ϊ�գ�"+allList.isEmpty());
		
		List<String> allSub = allList.subList(2, 4);//�ַ�����ȡ
		System.out.print("��ȡ����ַ���Ϊ��");
		for (int i = 0; i < allSub.size(); i++) {
			System.out.print(allSub.get(i)+"��");
		}
	
	}

}
