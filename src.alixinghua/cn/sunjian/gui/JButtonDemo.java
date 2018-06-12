package cn.sunjian.gui;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 图形界面：
 * 	
 * 		JButton：
 * 			创建按钮；
 * 
 * @author jack
 *
 */
public class JButtonDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Welcome To MLDN");//实例化窗体对象
		
		String picPath = System.getProperty("user.dir")+"/files/lixinghua/image/liya.png";
		Icon icon = new ImageIcon(picPath);
		
		JButton but = new JButton("按我",icon);//将图片添加到按钮上
		Font font = new Font("Serief", Font.BOLD, 28);//设置字体
		
		
		but.setFont(font);
		frame.add(but);//将按钮添加到窗体中
		frame.setSize(754, 944);//设置窗体大小
		frame.setLocation(300, 200);//设置窗体坐标位置
		
		frame.setVisible(true);//设置窗体可见
	}

}
