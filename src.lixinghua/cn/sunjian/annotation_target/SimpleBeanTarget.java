package cn.sunjian.annotation_target;

/**
 * ����Annotation��
 * 
 * 		@Targetע�ͣ�ָ��Annotationʹ�õķ�Χ
 * 
 * @author jack
 *
 */
@MyTargetAnnotation(key = "�ڵ����Զ����annotationʱ��������ָ����",value = "@Target ElementType.TYPE,ElementType.METHOD")//�����������ã���ȡ���Զ���Annotation�е�Ĭ��ֵ
public class SimpleBeanTarget {

	@Deprecated
	@Override
//	@SuppressWarnings("unchecked")
	@MyTargetAnnotation//(key = "�ڵ����Զ����annotationʱ���ڷ�����ָ����",value = "@Target ElementType.TYPE,ElementType.METHOD")//�����������ã���ȡ���Զ���Annotation�е�Ĭ��ֵ
	public String toString(){
		return "�ҽ��｡������";
	}
	
	/*
	 * ���ϵĲ���������ͨ����ϵͳ�ڽ���Annotation��ɵģ�
	 * ͬʱ��������Annotation����ô��ʱֻ��Deprecated��Annotation���巶ΧʱRUNTIME��Χ������ͨ������ֻ��ȡ��һ����
	 */
}
