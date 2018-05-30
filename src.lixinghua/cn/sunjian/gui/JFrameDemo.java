package cn.sunjian.gui;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * 图形界面：
 * 	
 * 		JFrame：
 * 			创建窗体；
 * 
 * @author jack
 *
 */
public class JFrameDemo {

	public static void main(String[] args) {

		JFrame f = new JFrame("第一个Swing窗体");
		f.setSize(250, 80);//设置组件的大小
		f.setBackground(Color.WHITE);//将背景设置成白色
		f.setLocation(300, 200);//设置组件的显示位置
		f.setVisible(true);//设置组件可见
	}

}
