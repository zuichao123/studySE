package cn.sunjian.system;

/**
 * System����ϰ��
 * 		
 * 		ȡ�ò������õ�ʱ��		
 * 
 * @author jack
 *
 */
public class SystemDemo {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();//��ʼʱ��
		@SuppressWarnings("unused")
		int sum = 0;//��������
		
		for(int i=0;i<700000000;i++){
			sum+=i;
		}
		
		long endTime = System.currentTimeMillis();//����ʱ��
		
		System.out.println("����ʱ�䣺"+(endTime-startTime)+"����");
		
	}

}
