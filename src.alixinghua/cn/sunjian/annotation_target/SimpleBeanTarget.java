package cn.sunjian.annotation_target;

/**
 * 深入Annotation：
 * 
 * 		@Target注释：指定Annotation使用的范围
 * 
 * @author jack
 *
 */
@MyTargetAnnotation(key = "在调用自定义的annotation时，在类上指定的",value = "@Target ElementType.TYPE,ElementType.METHOD")//如果这个不设置，将取得自定义Annotation中的默认值
public class SimpleBeanTarget {

	@Deprecated
	@Override
//	@SuppressWarnings("unchecked")
	@MyTargetAnnotation//(key = "在调用自定义的annotation时，在方法上指定的",value = "@Target ElementType.TYPE,ElementType.METHOD")//如果这个不设置，将取得自定义Annotation中的默认值
	public String toString(){
		return "我叫孙健！！！";
	}
	
	/*
	 * 以上的操作代码是通过上系统内建的Annotation完成的；
	 * 同时设置三个Annotation，那么此时只用Deprecated的Annotation定义范围时RUNTIME范围，所有通过反射只能取得一个。
	 */
}
