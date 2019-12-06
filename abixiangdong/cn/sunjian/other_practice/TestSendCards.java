package cn.sunjian.other_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSendCards {

	public static void main(String[] args) {
		List<Integer> cards = new ArrayList<Integer>();
		//shuffle 洗牌模拟斗地主
		for(int i=0; i<54; i++){
			cards.add(i);
		}
		
		//洗牌
		Collections.shuffle(cards);
		
		//依次发牌
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
		
		System.out.println("第一个人："+p1);
		System.out.println("第二个人："+p2);
		System.out.println("第三个人："+p3);
		System.out.println("底牌为："+last);
	
	}

}
