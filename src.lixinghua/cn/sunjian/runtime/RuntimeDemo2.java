package cn.sunjian.runtime;

/**
 * Runtime����ϰ��
 * 		Runtime���Process����ʹ��
 * 
 * 		��һ�����±���5����Զ��ر�
 * 
 * @author jack
 *
 */
public class RuntimeDemo2 {

	public static void main(String[] args) {

		Runtime run = Runtime.getRuntime();//ͨ��Runtime���еľ�̬����getRuntime()����ʵ�����������
		Process p = null;//������̱���
		
		try {
			p = run.exec("notepad.exe");//�򿪱�����notepad���±�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(5000);//����5��
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		p.destroy();//��������
		
	}

}
