package com.sunjian.smallapplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShowHand {

	//�������Ϸ���֧�ֶ��ٸ����
	private final int PLAY_NUM = 5;
	//�����˿��Ƶ����л�ɫ����ֵ
	private String[] types = {"����","÷��","����","����"};
	private String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	//cards��һ����Ϸ��ʣ�µ��˿���
	private List<String> cards = new LinkedList<String>();
	//�������е����
	private String[] players = new String[PLAY_NUM];
	//playersCards������������ϵ��˿���
	private List<String>[] playersCards = new List[PLAY_NUM];
	
	/**
	 * ��ʼ����ң�Ϊÿ����ҷ����û���
	 */
	public void initPlayer(String... names){
		if (names.length > PLAY_NUM || names.length < 2) {
			System.out.println("�����������\n2 >= ���  <= 5");
			return;
		}else {
			//��ʼ������û���
			for(int i=0;i<names.length;i++){
				players[i] = names[i];
			}
		}
	}
	
	/**
	 * ��ʼ���˿��ƣ�����52���˿���
	 * ����ʹ��shuffle()�������������˳������
	 */
	public void initCards(){
		for(int i=0;i<types.length;i++){
			for(int j=0;j<values.length;j++){
				cards.add(types[i]+values[j]);
			}
		}
		//�������
		Collections.shuffle(cards);
	}
	
	
	/**
	 * ��ʼ��������ϵ��ƣ���ʼ��Ϸʱÿ��������ϵ��˿���Ϊ��
	 * ����ʹ��һ������Ϊ0��LinkedList����ʾ
	 */
	public void initPlayerCards(){
		for(int i=0;i<players.length;i++){
			if (players[i] != null && !players[i].equals("")) {
				playersCards[i] = new LinkedList<String>();
			}
		}
	}
	
	/**
	 * ���ȫ���˿��ƣ��÷���û��ʵ�����ã�����������
	 */
	public void showAllCards(){
		System.out.println("��ǰ�˿���"+cards.size()+"��");
		for(String card:cards){
			System.out.println(card);
		}
	}
	
	/**
	 * ���˿���
	 */
	public void deliverCard(String first){
		//����ArrayUtils�������search����,��ѯ��ָ��Ԫ���������е�����
		int firstPos = ArrayUtils.search(players,first);//ָ����Ա��λ��
		//���θ�λ�ڸ�ָ�����֮���û��������˿���
		for(int i=firstPos;i<PLAY_NUM;i++){
			if (players[i] != null) {
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
		for(int i=0;i<firstPos;i++){
			if (players[i] != null) {
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
	}
	
	/**
	 * ���������ϵ��˿���
	 * ʵ�ָ÷���ʱ��Ӧ�ÿ���ÿ����ҿ��������˵ĵ�һ���ƣ����˴�û�����Ӹù���
	 */
	public void showPlayerCards(){
		for(int i=0;i<PLAY_NUM;i++){
			if (players[i] != null) {
				//������
				System.out.println(players[i]+":");
				for(String card:playersCards[i]){
					System.out.println(card+"\t");
				}
			}
			System.out.println("\n");
		}
	}
	

	public static void main(String[] args) {

		ShowHand sh = new ShowHand();
		
		sh.initPlayer("�������","�����");
		sh.initCards();
		sh.initPlayerCards();
		
		sh.showAllCards();
		System.out.println("-------------------");
		
		sh.deliverCard("�����");
		sh.showPlayerCards();
		
		/*
		 * ����ط���Ҫ���Ӵ���
		 * 1.�������������ע��
		 * 2.��������Ƿ��ע��
		 * 3.��Ϸ�Ƿ�ֻʣһ����ң�����ǣ�������ʤ����
		 * 4.����Ѿ������һ���˿��ƣ�����Ҫ�Ƚ�ʣ����ҵ������С��
		 * */
		
		sh.deliverCard("�������");
		sh.showPlayerCards();
	}

}
class ArrayUtils{
	public static int search(String[] array, String target){
		for (int i = 0 ; i < array.length ; i++ ){
			if (array[i] != null && array[i].equals(target)){
			return i;
			}
		}
		return -1;
	}
}
