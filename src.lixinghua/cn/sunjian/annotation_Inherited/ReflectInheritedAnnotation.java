package cn.sunjian.annotation_Inherited;

import java.lang.annotation.Annotation;

/**
 * ����Annotation��
 * 
 * 		@Inheritedע�ͣ���ʾ���Ա��̳�������
 * 			����һ�����࣬�ڸ�����ʹ�ô�Annotation��
 * 			ȡ�������е�annotation��
 * 			ȡ�������е�annotation���õ����ݣ�
 * 
 * @author jack
 *
 */
public class ReflectInheritedAnnotation{
	public static void main(String[] args) {
		
		Class<?> c = null;
		try {
			c = Class.forName("cn.sunjian.annotation_Inherited.Student");
			Annotation[] an = c.getAnnotations();//ȡ��ȫ����annotation
			
			for(Annotation a : an){//���annotation
				System.out.println(a);
			}
			
			//����ȡ�ô�Annotation���õ�����
			if (c.isAnnotationPresent(MyInheritedAnnotation.class)) {
				MyInheritedAnnotation mia = null;
				mia = c.getAnnotation(MyInheritedAnnotation.class);
				
				String name = mia.name();
				
				System.out.println("��Annotation���õ����ݣ�\nname = "+name);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
