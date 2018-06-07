package cn.sunjian.generic_define;

import cn.sunjian.generic_bean.Student;

/**
 * 自定义泛型演示
 * 
 * @author sunjian
 *
 */
public class GenericDefineDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Tool<Student> tool = new Tool<Student>();
		
		tool.setObject(new Student());
		
		Student su = tool.getObject();
	}

}
