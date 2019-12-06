package cn.sunjian.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * 图形界面：
 * 	
 * 		JLabel：
 * 			创建组件；
 * 			设置字体；
 * 			添加图片到组件中；
 * 
 * @author jack
 *
 */
public class JLabelDemo {

	public static void main(String[] args) {

		JFrame frame = null;
		JLabel label = null;
		Font fnt = null;
		Icon icon = null;		
		
		String picPath = System.getProperty("user.dir")+"/files/lixinghua/image/liya.png";
		
		frame = new JFrame("Welcome to MLDN");
		fnt = new Font("Serief", Font.ITALIC + Font.BOLD, 26);//设置字体为粗斜体
		icon = new ImageIcon(picPath);//实例化，将图片地址传入

		label = new JLabel("丫丫",icon,JLabel.CENTER);//实例化标签对象(居中显示[带背景图片])
		
		label.setFont(fnt);//将字体格式设置到标签上
		label.setForeground(Color.RED);//设置标签的字体颜色
		label.setBackground(Color.YELLOW);//设置窗体的背景颜色
		
		frame.add(label);//将组件添加到面板之中
		Dimension dim = new Dimension();
		
		frame.setBackground(Color.WHITE);//设置窗体的背景颜色
		dim.setSize(744, 944);//设置组件的宽度、高度
		frame.setSize(dim);//设置窗体大小
		
		Point point = new Point(600,40);//设置坐标
		frame.setLocation(point);//将坐标设置到窗体上
		
		frame.setVisible(true);//设置窗体可见
		
	}

}
