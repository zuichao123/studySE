package cn.sunjian.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式操作练习
 * 	
 * 		Observable
 * 	
 * @author jack
 *
 */

/*
 * 表示房子可以被观察
 * 		被观察者类
 */
class House extends Observable{
	private float price;//房价
	
	public House(float price){
		this.price = price;
	}
	
	//每一次修改的时候都应该引起观察者的注意
	public void setPrice(float price){
		super.setChanged();//设置变化点
		super.notifyObservers(price);//价格被改变
		this.price = price;
	}
	public float getPrice(){
		return this.price;
	}
	
	public String toString(){
		return "房价为："+this.price;
	}
}

/*
 * 观察者类
 */
class HousePriceObserver implements Observer{
	private String name;
	
	public HousePriceObserver(String name){//设置每一个购房者的名字
		this.name = name;
	}
	
	/*
	 * o表示：Observerable类的对象
	 * arg表示：需要被观察的内容
	 * 
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o,Object arg){
		if (arg instanceof Float) {
			System.out.println(this.name+"观察到价格更改为："+((Float)arg).floatValue());
		}
	}
}


public class ObservableDemo {

	public static void main(String[] args) {

		House h = new House(50000);
		
		HousePriceObserver hpo1 = new HousePriceObserver("购房者A");
		HousePriceObserver hpo2 = new HousePriceObserver("购房者B");
		HousePriceObserver hpo3 = new HousePriceObserver("购房者C");
		
		h.addObserver(hpo1);
		h.addObserver(hpo2);
		h.addObserver(hpo3);
		
		System.out.println(h);//输出房子价格
		h.setPrice(40000);
		System.out.println(h);//输出房子价格
		
	}

}
