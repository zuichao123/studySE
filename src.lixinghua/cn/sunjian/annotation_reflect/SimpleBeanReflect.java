package cn.sunjian.annotation_reflect;
/**
 * ������Annotation��
 * 
 * 		����һ���ࣺ
 * 			ʹ��ϵͳ�ڽ���Annotation��
 * 			ʹ���Զ����Annotation��
 * 
 * @author jack
 *
 */
public class SimpleBeanReflect {

	@Deprecated
	@Override
//	@SuppressWarnings("unchecked")
	@MyDefaultAnnotationReflect(key = "jack",value = "test123")//�����������ã���ȡ���Զ���Annotation�е�Ĭ��ֵ
	public String toString(){
		return "�ҽ��｡������";
	}
	
	/*
	 * ���ϵĲ���������ͨ����ϵͳ�ڽ���Annotation��ɵģ�
	 * ͬʱ��������Annotation����ô��ʱֻ��Deprecated��Annotation���巶ΧʱRUNTIME��Χ������ͨ������ֻ��ȡ��һ����
	 */
}
