package cn.sunjian.other_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSendCards {

	public static void main(String[] args) {
		List<Integer> cards = new ArrayList<Integer>();
		//shuffle ϴ��ģ�⶷����
		for(int i=0; i<54; i++){
			cards.add(i);
		}
		
		//ϴ��
		Collections.shuffle(cards);
		
		//���η���
		List<Integer> p1 =new ArrayList<Integer>();
		List<Integer> p2 =new ArrayList<Integer>();
		List<Integer> p3 =new ArrayList<Integer>();
		List<Integer> last =new ArrayList<Integer>();
		
		for(int i=0; i<51;i+=3){
			p1.add(cards.get(i));
			p2.add(cards.get(i+1));
			p3.add(cards.get(i+2));
		}
		last.add(cards.get(51));
		last.add(cards.get(52));
		last.add(cards.get(53));
		
		System.out.println("��һ���ˣ�"+p1);
		System.out.println("�ڶ����ˣ�"+p2);
		System.out.println("�������ˣ�"+p3);
		System.out.println("����Ϊ��"+last);
	
	}

}
