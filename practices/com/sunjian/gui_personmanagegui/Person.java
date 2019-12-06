package com.sunjian.gui_personmanagegui;

import java.io.Serializable;

/*
 * ��ϰ��������Ϣ�������
 * 	
 * 		����Person�ࣺʵ��Serializable�ӿڣ���ΪҪ���кŶ���
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name ;
	private int age ;
	
	public Person(){}
	
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	
	public String toString(){
		return "������"+this.name+"�����䣺"+this.age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
