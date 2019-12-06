package cn.sunjian.linkedlist;

/**
 * ��ʹ��LinkedList��ģ��һ����ջ���߶������ݽṹ��
 * 
 * ��ջ���Ƚ����First In Last Out FILO
 * ���У��Ƚ��ȳ�First In First Out FIFO
 * 
 * ����Ӧ����������һ����������ʹ���ṩһ������������������ֽṹ��
 * 
 * @author sunjian
 *
 */







public class LinkedTest {

	public static void main(String[] args) {
		
		DuiLie duiLie = new DuiLie();
		
		duiLie.myAdd("abc1");
		duiLie.myAdd("abc2");
		duiLie.myAdd("abc3");
		duiLie.myAdd("abc4");

		while(!duiLie.isNull()){
			System.out.println(duiLie.myGet());
		}
		
		DuiZhan duiZhan = new DuiZhan();
		
		duiZhan.myAdd("football1");
		duiZhan.myAdd("football2");
		duiZhan.myAdd("football3");
		duiZhan.myAdd("football4");
		
		while(!duiZhan.isNull()){
			System.out.println(duiZhan.myGet());
		}
	}

}
