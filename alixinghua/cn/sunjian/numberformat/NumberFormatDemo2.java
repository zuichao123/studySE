package cn.sunjian.numberformat;

import java.text.NumberFormat;

/**
 *  NumberFormat�������ϰ��
 *  
 * @author sunjian
 *
 */
public class NumberFormatDemo2 {

	public static void main(String[] args) {
		NumberFormat nf = null;//����һ��NumberFormat����
		
		nf = NumberFormat.getInstance();//�õ�Ĭ�ϵ����ָ�ʽ����ʾ
		
		System.out.println("��ʽ��֮������֣�"+nf.format(1000000));
		System.out.println("��ʽ��֮������֣�"+nf.format(1000.345));
	}

}
