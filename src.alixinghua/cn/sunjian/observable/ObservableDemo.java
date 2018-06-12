package cn.sunjian.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * �۲���ģʽ������ϰ
 * 	
 * 		Observable
 * 	
 * @author jack
 *
 */

/*
 * ��ʾ���ӿ��Ա��۲�
 * 		���۲�����
 */
class House extends Observable{
	private float price;//����
	
	public House(float price){
		this.price = price;
	}
	
	//ÿһ���޸ĵ�ʱ��Ӧ������۲��ߵ�ע��
	public void setPrice(float price){
		super.setChanged();//���ñ仯��
		super.notifyObservers(price);//�۸񱻸ı�
		this.price = price;
	}
	public float getPrice(){
		return this.price;
	}
	
	public String toString(){
		return "����Ϊ��"+this.price;
	}
}

/*
 * �۲�����
 */
class HousePriceObserver implements Observer{
	private String name;
	
	public HousePriceObserver(String name){//����ÿһ�������ߵ�����
		this.name = name;
	}
	
	/*
	 * o��ʾ��Observerable��Ķ���
	 * arg��ʾ����Ҫ���۲������
	 * 
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o,Object arg){
		if (arg instanceof Float) {
			System.out.println(this.name+"�۲쵽�۸����Ϊ��"+((Float)arg).floatValue());
		}
	}
}


public class ObservableDemo {

	public static void main(String[] args) {

		House h = new House(50000);
		
		HousePriceObserver hpo1 = new HousePriceObserver("������A");
		HousePriceObserver hpo2 = new HousePriceObserver("������B");
		HousePriceObserver hpo3 = new HousePriceObserver("������C");
		
		h.addObserver(hpo1);
		h.addObserver(hpo2);
		h.addObserver(hpo3);
		
		System.out.println(h);//������Ӽ۸�
		h.setPrice(40000);
		System.out.println(h);//������Ӽ۸�
		
	}

}
