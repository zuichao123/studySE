package cn.sunjian.runtime;

/**
 * Runtime����ϰ��
 * 		
 * @author jack
 *
 */
public class RuntimeDemo {

	public static void main(String[] args) {

		Runtime run = Runtime.getRuntime();//ͨ��Runtime���еľ�̬����getRuntime()����ʵ�����������
		
		System.out.println("jvm����ڴ�����"+run.maxMemory());//�۲������ڴ�
		
		System.out.println("jvm�����ڴ�����"+run.freeMemory());//ȡ�ó������еĿ����ڴ�
		
		String str = "Hello" + "world!" + "\t" + "Welcome"+"To" + "China";
		
		System.out.println(str);
		
		for(int x=0;x<100;x++){
			str+=x;//ѭ���޸��ڴ棬�����������
		}
		
		System.out.println("����String֮���jvm�����ڴ�����"+run.freeMemory());
		
		run.gc();//�������գ��ͷſռ�
		
		System.out.println("��������֮���jvm�����ڴ�����"+run.freeMemory());
	}

}
