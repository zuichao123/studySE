package cn.sunjian.reflect;

/**
 * java反射机制：
 * 
 * 		Class类的使用：通过无参构造实例化对象
 * 			如果要想通过Class类本身实例化其他类的对象，则可以使用
 * 			newInstance()方法实例化Class对象，
 * 			但是必须保证被实例化的类中必须存在一个无参构造方法。
 * 
 * @author jack
 *
 */
class Person{
	private String name;
	private int age;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	
	public String toString(){
		return "姓名："+this.name+",年龄："+this.age;
	}
}


public class NewInstanceDemo {

	public static void main(String[] args) {
		Class<?> c = null;//声明Class对象
		
		//实例化Class对象			
		try{
			c = Class.forName("cn.sunjian.reflect.Person");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Person per = null;//声明Person对象
		
		//实例化Person对象
		try {
			per = (Person) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {	
			e.printStackTrace();
		}
		
		per.setName("sunjian");//设置姓名
		per.setAge(30);//设置年龄
		
		System.out.println(per);
	}

	/*
	 * 即使不通过关键字new对象也可以进行实例化操作，反射的作用；
	 * 但是，在使用以上操作的时候有一点必须注意，在操作类中必须存在无参构造方法。
	 * 否则无法实例化。
	 * 如果想要调用有参的构造，则必须按照以下的步骤进行：
	 * 		1.通过Class类中的getConstructors()取得本类中的全部构造方法；
	 * 		2.向构造方法中传递一个对象数组进去，里面包含了构造方法中所需的各个参数；
	 * 		3.之后通过Constructor实例化对象；
	 */
}
