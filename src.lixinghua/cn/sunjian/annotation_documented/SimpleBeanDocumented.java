package cn.sunjian.annotation_documented;

/**
 * ����Annotation��
 * 
 * 		@Documentedע�ͣ����������κε�Annotation��ʹ��
 * 
 * @author jack
 *
 */
@MyDocumentedAnnotation(key = "123",value = "456")
public class SimpleBeanDocumented{
	/**
	 * �˷����ڶ������ʱ���ã����ض�����Ϣ
	 */
	@MyDocumentedAnnotation(key = "123",value = "456")
	public String toString(){
		return "ʹ��javadoc -d doc SimpleBeanDocumented.java���������ĵ�ע�͡�";
	}
	
	/*
	 * ֮��ͨ��javadoc�������java.doc�ĵ�
	 */
}
