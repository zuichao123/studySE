package cn.sunjian.exception;
/**
 * throw �ؼ���
 * 
 * @author sunjian
 *
 */
public class ThrowDemo {

	public static void main(String[] args) {
		try{
			throw new Exception("��������档��");
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
