package cn.sunjian.generic.define.demo;

import cn.sunjian.generic.bean.Student;

/**
 * 自定义泛型演示
 * 
 * @author sunjian
 *
 */
public class GenericDefineDemo {

	public static void main(String[] args) {

		Tool<Student> tool = new Tool<Student>();
		
		tool.setObject(new Student());
		
		Student su = tool.getObject();
	}

}
