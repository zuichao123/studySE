package cn.sunjian.annotation_reflect;
/**
 * 反射与Annotation：
 * 
 * 		定义一个类：
 * 			使用系统内建的Annotation；
 * 			使用自定义的Annotation；
 * 
 * @author jack
 *
 */
public class SimpleBeanReflect {

	@Deprecated
	@Override
//	@SuppressWarnings("unchecked")
	@MyDefaultAnnotationReflect(key = "jack",value = "test123")//如果这个不设置，将取得自定义Annotation中的默认值
	public String toString(){
		return "我叫孙健！！！";
	}
	
	/*
	 * 以上的操作代码是通过上系统内建的Annotation完成的；
	 * 同时设置三个Annotation，那么此时只用Deprecated的Annotation定义范围时RUNTIME范围，所有通过反射只能取得一个。
	 */
}
