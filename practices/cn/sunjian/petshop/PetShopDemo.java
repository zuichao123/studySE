package cn.sunjian.petshop;
/**
 * 宠物商店练习
 * 
 * @author sunjian
 *
 */

/*
 * 定义宠物接口
 */
interface Pet{
	public String getName();//获取宠物名字
	public String getColor();//获取宠物颜色
	public int getAge();//获取宠物年龄
}

/*
 * 宠物猫,实现宠物接口
 */
class Cat implements Pet{
	private String name;//宠物名字
	private String color;//宠物颜色
	private int age;//宠物年龄
	
	public Cat(String name,String color,int age){
		this.setName(name);
		this.setColor(color);
		this.setAge(age);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

/*
 * 宠物狗，实现宠物接口
 */
class Dog implements Pet{
	private String name;//宠物名字
	private String color;//宠物颜色
	private int age;//宠物年龄
	
	public Dog(String name,String color,int age){
		this.setName(name);
		this.setColor(color);
		this.setAge(age);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

/*
 * 宠物商店类，实现：
 * 添加宠物：
 * 搜索宠物：
 */
class PetShop{
	private Pet[] pets;//定义宠物数组，存放宠物商店中的所有宠物
	private int foot;//宠物数组的角标
	
	//构造方法（给宠物数组赋值）
	public PetShop(int len){
		if (len>0) {
			this.pets = new Pet[len];//开辟数组空间
		}else {
			this.pets = new Pet[1];//保证宠物数组空间最少为1
		}
	}
	
	//添加宠物方法
	public boolean add(Pet p){
		//判断数组中是否还有空间
		if (this.foot<this.pets.length) {//如果当前角标的位置小于数组的长度，说明还可以添加宠物
			this.pets[this.foot] = p;//将添加的宠物存放在当前角标处
			this.foot++;//角标加1
			return true;//返回添加成功标识
		}else {
			return false;//添加失败
		}
	}
	
	//搜索宠物方法，将搜索到的宠物存储到一个数组中返回
	public Pet[] search(String keyWord){
		//应该确定有多少宠物符合要求
		Pet p[] = null;
		int count = 0;//记录会有多少个宠物符合查询结果
		
		for(int i=0;i<this.pets.length;i++){
			//如果宠物数组中的当前位置的名字和颜色不等于-1，就是说名字和颜色不为空（就代表此处有宠物）
			if (this.pets[i].getName().indexOf(keyWord)!=-1 || this.pets[i].getColor().indexOf(keyWord)!=-1) {
				//有宠物的话(记录加1)
				count++;
			}
		}
	
		p = new Pet[count];//开辟一个与当前宠物数量相同的数组空间
		
		int foot = 0;//增加元素的位置标记,其实位0（代表数组的第一位）
		for(int i=0;i<this.pets.length;i++){
			//如果宠物数组中的当前位置的名字和颜色不等于-1，就是说名字和颜色不为空（就代表此处有宠物）
			if (this.pets[i].getName().indexOf(keyWord)!=-1 || this.pets[i].getColor().indexOf(keyWord)!=-1) {
				//有宠物的话，将当前宠物存放在，新开辟的数组空间p中
				p[foot] = this.pets[i];
				//位置标记自加
				foot++;
			}
		}
		
		//将搜索到的所有宠物返回
		return p;	
	}
}




public class PetShopDemo {

	public static void main(String[] args) {
		PetShop ps = new PetShop(5);//实例化一个5个元素的宠物商店数组对象
		
		ps.add(new Cat("白猫", "白色", 7));
		ps.add(new Cat("黑猫", "黑色", 2));
		ps.add(new Cat("黄猫", "黄色", 4));
		ps.add(new Dog("白狗", "白色", 5));
		ps.add(new Dog("蓝狗", "蓝色", 8));
		ps.add(new Dog("黑狗", "黑色", 3));
		ps.add(new Dog("蓝狗2", "蓝色2", 8));
		
		print(ps.search("蓝"));
		
	}
	
	//输出搜索到的宠物
	public static void print(Pet[] p){
		for(int i=0;i<p.length;i++){
			if (p[i]!=null) {
				System.out.println("搜索到的内容："+p[i].getName()+"、"+p[i].getColor()+"、"+p[i].getAge());
			}
		}
	}

}
