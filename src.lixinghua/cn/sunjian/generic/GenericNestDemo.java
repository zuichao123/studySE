package cn.sunjian.generic;
/**
 * 泛型的嵌套设置练习
 * 
 * @author sunjian
 *
 */
class Info6<T,V>{
	private T var;
	private V value;
	
	
	public T getVar() {
		return var;
	}
	public void setVar(T var) {
		this.var = var;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public Info6(T var, V value) {
		this.var = var;
		this.value = value;
	}	
}

class Demo6<S>{
	private S info;
	
	public Demo6(S info){
		this.info = info;
	}
	public void setInfo(S info){
		this.info = info;
	}
	public S getInfo(){
		return this.info;
	}
}

public class GenericNestDemo {

	public static void main(String[] args) {
		Demo6<Info6<String,Integer>> d = null;//将Info作为Demo的泛型类型
		Info6<String,Integer> i = null;//Info指定两个泛型类型
		
		i = new Info6<String,Integer>("sunjian",30);//实例化泛型对象
		d = new Demo6<Info6<String,Integer>>(i);//在Demo类中设置Info类的对象
		
		System.out.println("内容一："+d.getInfo().getVar());//输出
		System.out.println("内容二："+d.getInfo().getValue());
		
	}

}
