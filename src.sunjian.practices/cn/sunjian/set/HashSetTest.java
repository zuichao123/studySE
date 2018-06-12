package cn.sunjian.set;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set������ϰ��
 * 
 * ͨ��HashSet��ɣ���100�������в��ز���
 * 
 * @author jack
 *
 */
public class HashSetTest {

	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSS");//����ʱ����ʾ��ʽ

		Date date = new Date();
		System.out.println("��ʼʱ�䣺"+df.format(date));
		
		int[] arr = new int[1000000];//����һ������Ϊ100�������
		
		for(int i=0;i<arr.length;i++){
		arr[i] = i+1;//Ϊ���鸳ֵ
		}
		
		arr[65535] = 1000;//�޸������е�һ��ֵ����������һ��ֵһ��
		
		Set<Integer> set = new HashSet<Integer>();//����HashSet���ϣ�Ԫ�ز����ظ���
		
		int i = 0;//������������ڱ����ظ�Ԫ�ص�����
		
		for(i=0;i<arr.length;i++){
			if (!set.add(arr[i])){//����ʼ���������Ԫ�أ���ӵ�set�����У�����set�����е�Ԫ�ز����ظ������е���ӵ�֮ǰ�޸Ĺ���Ԫ��ʱ���᷵��false
				break;//�������false�������˳�
			}
		}
		
		Iterator<Integer> iterator = set.iterator();//������������ӿ�iterator���󣬲�����iterator()����ʵ����
		 
		while(iterator.hasNext()){
			int temp = iterator.next();//����set�����е�Ԫ��
			if (temp == arr[i]) {//�жϣ������ǰԪ����arr�����е��ظ�Ԫ����ͬ
				break;
			}
		}
		 
		System.out.println("�ظ�Ԫ�ص����꣺"+i);
		System.out.println("�ظ�Ԫ�ص�ֵ��"+arr[i]);
		
		Date date2 = new Date();
		System.out.println("����ʱ�䣺"+df.format(date2));

	}

}
