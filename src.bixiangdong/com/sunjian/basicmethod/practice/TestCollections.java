package com.sunjian.basicmethod.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {

	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println("反转之后"+"\n"+list);
	}
}
