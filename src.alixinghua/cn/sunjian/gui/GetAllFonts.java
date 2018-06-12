package cn.sunjian.gui;

import java.awt.GraphicsEnvironment;

/**
 * 图形界面：GetAllFonts
 * 
 * 		得到本机可用的全部字体；		
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
