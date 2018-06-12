package cn.sunjian.annotation;
/**
 * Annotation：注释
 * 
 * 		@Deprecated：不建议使用的操作
 * 
 * @author jack
 *
 */
@Deprecated
class Demo{
	@Deprecated
	public String getInfo(){
		return "这是一个Person类。。。";
	}
}

public class DeprecatedAnnotationDemo {

	public static void main(String[] args) {

		Demo d = new Demo();
		
		System.out.println(d.getInfo());
	}

}
