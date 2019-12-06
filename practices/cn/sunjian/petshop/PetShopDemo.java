package cn.sunjian.petshop;
/**
 * �����̵���ϰ
 * 
 * @author sunjian
 *
 */

/*
 * �������ӿ�
 */
interface Pet{
	public String getName();//��ȡ��������
	public String getColor();//��ȡ������ɫ
	public int getAge();//��ȡ��������
}

/*
 * ����è,ʵ�ֳ���ӿ�
 */
class Cat implements Pet{
	private String name;//��������
	private String color;//������ɫ
	private int age;//��������
	
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
 * ���ﹷ��ʵ�ֳ���ӿ�
 */
class Dog implements Pet{
	private String name;//��������
	private String color;//������ɫ
	private int age;//��������
	
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
 * �����̵��࣬ʵ�֣�
 * ��ӳ��
 * �������
 */
class PetShop{
	private Pet[] pets;//����������飬��ų����̵��е����г���
	private int foot;//��������ĽǱ�
	
	//���췽�������������鸳ֵ��
	public PetShop(int len){
		if (len>0) {
			this.pets = new Pet[len];//��������ռ�
		}else {
			this.pets = new Pet[1];//��֤��������ռ�����Ϊ1
		}
	}
	
	//��ӳ��﷽��
	public boolean add(Pet p){
		//�ж��������Ƿ��пռ�
		if (this.foot<this.pets.length) {//�����ǰ�Ǳ��λ��С������ĳ��ȣ�˵����������ӳ���
			this.pets[this.foot] = p;//����ӵĳ������ڵ�ǰ�Ǳ괦
			this.foot++;//�Ǳ��1
			return true;//������ӳɹ���ʶ
		}else {
			return false;//���ʧ��
		}
	}
	
	//�������﷽�������������ĳ���洢��һ�������з���
	public Pet[] search(String keyWord){
		//Ӧ��ȷ���ж��ٳ������Ҫ��
		Pet p[] = null;
		int count = 0;//��¼���ж��ٸ�������ϲ�ѯ���
		
		for(int i=0;i<this.pets.length;i++){
			//������������еĵ�ǰλ�õ����ֺ���ɫ������-1������˵���ֺ���ɫ��Ϊ�գ��ʹ���˴��г��
			if (this.pets[i].getName().indexOf(keyWord)!=-1 || this.pets[i].getColor().indexOf(keyWord)!=-1) {
				//�г���Ļ�(��¼��1)
				count++;
			}
		}
	
		p = new Pet[count];//����һ���뵱ǰ����������ͬ������ռ�
		
		int foot = 0;//����Ԫ�ص�λ�ñ��,��ʵλ0����������ĵ�һλ��
		for(int i=0;i<this.pets.length;i++){
			//������������еĵ�ǰλ�õ����ֺ���ɫ������-1������˵���ֺ���ɫ��Ϊ�գ��ʹ���˴��г��
			if (this.pets[i].getName().indexOf(keyWord)!=-1 || this.pets[i].getColor().indexOf(keyWord)!=-1) {
				//�г���Ļ�������ǰ�������ڣ��¿��ٵ�����ռ�p��
				p[foot] = this.pets[i];
				//λ�ñ���Լ�
				foot++;
			}
		}
		
		//�������������г��ﷵ��
		return p;	
	}
}




public class PetShopDemo {

	public static void main(String[] args) {
		PetShop ps = new PetShop(5);//ʵ����һ��5��Ԫ�صĳ����̵��������
		
		ps.add(new Cat("��è", "��ɫ", 7));
		ps.add(new Cat("��è", "��ɫ", 2));
		ps.add(new Cat("��è", "��ɫ", 4));
		ps.add(new Dog("�׹�", "��ɫ", 5));
		ps.add(new Dog("����", "��ɫ", 8));
		ps.add(new Dog("�ڹ�", "��ɫ", 3));
		ps.add(new Dog("����2", "��ɫ2", 8));
		
		print(ps.search("��"));
		
	}
	
	//����������ĳ���
	public static void print(Pet[] p){
		for(int i=0;i<p.length;i++){
			if (p[i]!=null) {
				System.out.println("�����������ݣ�"+p[i].getName()+"��"+p[i].getColor()+"��"+p[i].getAge());
			}
		}
	}

}
