package cn.sunjian.system;

/**
 * System����ϰ��
 * 		
 * 		ȡ�ò���ϵͳ������	
 * 
 * @author jack
 *
 */
public class SystemDemo2 {

	public static void main(String[] args) {

//		System.getProperties().list(System.out);//�г�ϵͳ��ȫ������
		
		System.out.println("======================");
		
		System.out.println("ϵͳ�汾��"+System.getProperty("os.name") + System.getProperty("os.version") + System.getProperty("os.arch"));//ϵͳ�汾
		
		System.out.println("ϵͳ�û���"+System.getProperty("user.name"));//ϵͳ�û�
		
		System.out.println("��ǰ�û�Ŀ¼��"+System.getProperty("user.home"));//��ǰ�û�Ŀ¼
		
		System.out.println("��ǰ�û�����Ŀ¼��"+System.getProperty("user.dir"));//��ǰ�û�����Ŀ¼
		
	}

}
