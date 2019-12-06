package cn.sunjian.numberformat;

import java.text.DecimalFormat;

/**
 *  NumberFormat�������ϰ��
 *  
 *  	�Զ����ʽ��ģ��
 *  
 * @author sunjian
 *
 */

/*
 * �˷���ר������������ֵĸ�ʽ����ʾ
 */
class FormatDemo{
	
	public void format(String pattern,double value){
		DecimalFormat df = null;//����һ��DecimalFormat��Ķ���
		
		df = new DecimalFormat(pattern);//ʵ�������󣬲�����ģ��
		
		String str = df.format(value);//��ʽ������
		
		System.out.println("ʹ��"+pattern+"ģ�壬"+"��ʽ������"+value+"����ʽ�����ֵ="+str+"\n");
	}
	
}

public class NumberFormatDemo {

	public static void main(String[] args) {
		
		FormatDemo fd = new FormatDemo();
		
		fd.format("###,###.###", 111222.34567);
		fd.format("000,000.000", 123222.345678);
		fd.format("###,###,###��", 123123.234234);
		fd.format("000,000,000��", 2343214.3234);
		fd.format("##.###%", 0.3453434);
		fd.format("00.###%", 0.034567);
		fd.format("###.###\u2030", 0.345678);
		
		/*
		 * ִ�н����
		 * ʹ��000,000.000ģ�壬��ʽ������123222.345678����ʽ�����ֵ=123,222.346
		 * 
		 * ʹ��###,###,###��ģ�壬��ʽ������123123.234234����ʽ�����ֵ=123,123��
		 * 
		 * ʹ��000,000,000��ģ�壬��ʽ������2343214.3234����ʽ�����ֵ=002,343,214��
		 * 
		 * ʹ��##.###%ģ�壬��ʽ������0.3453434����ʽ�����ֵ=34.534%
		 * 
		 * ʹ��00.###%ģ�壬��ʽ������0.034567����ʽ�����ֵ=03.457%
		 * 
		 * ʹ��###.###��ģ�壬��ʽ������0.345678����ʽ�����ֵ=345.678��
		 */
		
	}

}
