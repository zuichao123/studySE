package com.sunjian.smallapplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShowHand {

	//定义该游戏最多支持多少个玩家
	private final int PLAY_NUM = 5;
	//定义扑克牌的所有花色和数值
	private String[] types = {"方块","梅花","红桃","黑桃"};
	private String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	//cards是一局游戏中剩下的扑克牌
	private List<String> cards = new LinkedList<String>();
	//定义所有的玩家
	private String[] players = new String[PLAY_NUM];
	//playersCards是所有玩家手上的扑克牌
	private List<String>[] playersCards = new List[PLAY_NUM];
	
	/**
	 * 初始化玩家，为每个玩家分派用户名
	 */
	public void initPlayer(String... names){
		if (names.length > PLAY_NUM || names.length < 2) {
			System.out.println("玩家数量不对\n2 >= 玩家  <= 5");
			return;
		}else {
			//初始化玩家用户名
			for(int i=0;i<names.length;i++){
				players[i] = names[i];
			}
		}
	}
	
	/**
	 * 初始化扑克牌，放入52张扑克牌
	 * 并且使用shuffle()方法将它们随机顺序排列
	 */
	public void initCards(){
		for(int i=0;i<types.length;i++){
			for(int j=0;j<values.length;j++){
				cards.add(types[i]+values[j]);
			}
		}
		//随机排序
		Collections.shuffle(cards);
	}
	
	
	/**
	 * 初始化玩家手上的牌，开始游戏时每个玩家手上的扑克牌为空
	 * 程序使用一个长度为0的LinkedList来表示
	 */
	public void initPlayerCards(){
		for(int i=0;i<players.length;i++){
			if (players[i] != null && !players[i].equals("")) {
				playersCards[i] = new LinkedList<String>();
			}
		}
	}
	
	/**
	 * 输出全部扑克牌，该方法没有实际作用，仅用作测试
	 */
	public void showAllCards(){
		System.out.println("当前扑克牌"+cards.size()+"张");
		for(String card:cards){
			System.out.println(card);
		}
	}
	
	/**
	 * 派扑克牌
	 */
	public void deliverCard(String first){
		//调用ArrayUtils工具类的search方法,查询出指定元素在数组中的索引
		int firstPos = ArrayUtils.search(players,first);//指定人员的位置
		//依次给位于该指定玩家之后的没有玩家派扑克牌
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
	 * 输出玩家手上的扑克牌
	 * 实现该方法时，应该控制每个玩家看不到别人的第一张牌，但此处没有增加该功能
	 */
	public void showPlayerCards(){
		for(int i=0;i<PLAY_NUM;i++){
			if (players[i] != null) {
				//输出玩家
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
		
		sh.initPlayer("电脑玩家","孙悟空");
		sh.initCards();
		sh.initPlayerCards();
		
		sh.showAllCards();
		System.out.println("-------------------");
		
		sh.deliverCard("孙悟空");
		sh.showPlayerCards();
		
		/*
		 * 这个地方需要增加处理：
		 * 1.牌面最大的玩家下注；
		 * 2.其他玩家是否跟注；
		 * 3.游戏是否只剩一个玩家？如果是，则此玩家胜利了
		 * 4.如果已经是最后一张扑克牌，则需要比较剩下玩家的牌面大小；
		 * */
		
		sh.deliverCard("电脑玩家");
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
