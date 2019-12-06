package cn.sunjian.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

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
		Dimension d = new Dimension();
		
		d.setSize(230, 80);//设置窗体的宽、高
		
		f.setSize(d);//设置组件的大小
		f.setBackground(Color.BLACK);//将背景设置成白色
		
		Point p = new Point(300, 200);//设置窗体显示的x、y轴坐标
		
		f.setLocation(p);//设置组件的显示位置
		f.setVisible(true);//设置组件可见
	}

}
