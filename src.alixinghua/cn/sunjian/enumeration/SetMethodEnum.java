package cn.sunjian.enumeration;
/*
 * ö�٣�
 * 		ͨ��set����������ö�ٶ���
 * 		
 */
enum Color4{
	
	RED,GREEN,BLUE ;
	
	private String name ;			// ����name����
	
	public void setName(String name){
		switch (this) {
			case RED:{				
				if("��ɫ".equals(name)){
					this.name = name;
				}else {
					System.out.println("�������ݴ���");
				}
				break;
			}
			case BLUE:{				
				if("��ɫ".equals(name)){
					this.name = name;
				}else {
					System.out.println("�������ݴ���");
				}
				break;
			}
			case GREEN:{				
				if("��ɫ".equals(name)){
					this.name = name;
				}else {
					System.out.println("�������ݴ���");
				}
				break;
			}
			default:
				System.out.println("δ֪��ɫ");
				break;
		}
	}
	public String getName(){
		return this.name ;
	}
}



public class SetMethodEnum{
	public static void main(String args[]){
//		Color4 c4 = Color4.BLUE;
		Color4 c4 = Color4.valueOf(Color4.class,"BLUE");//�õ���ɫ������ͬ���Ͼ䣩
		
		c4.setName("��ɫ");//���ִ���
		c4.setName("��ɫ");
		
		System.out.println(c4.getName());
		
	}
}
