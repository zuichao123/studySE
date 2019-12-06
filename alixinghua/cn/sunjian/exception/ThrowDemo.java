package cn.sunjian.exception;
/**
 * throw ¹Ø¼ü×Ö
 * 
 * @author sunjian
 *
 */
public class ThrowDemo {

	public static void main(String[] args) {
		try{
			throw new Exception("Ëæ±ãÅ××ÅÍæ¡£¡£");
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
