package cn.sunjian.gui;

import java.awt.GraphicsEnvironment;

/**
 * ͼ�ν��棺GetAllFonts
 * 
 * 		�õ��������õ�ȫ�����壻		
 * 
 * @author jack
 *
 */
public class GetAllFonts {

	public static void main(String[] args) {

		GraphicsEnvironment eq = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontNames[] = eq.getAvailableFontFamilyNames();
		for(int i=0;i<fontNames.length;i++){
			System.out.println(fontNames[i]);
		}
	}
}
