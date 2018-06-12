package cn.sunjian.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 图形界面：
 * 	
 * 		JDesktopPane与JInternalFrame：内部窗体
 * 			在Swing中也可以完成内部窗体的显示，即：在一个窗体可以出现多个子窗体，每一个子窗体都无法超出父窗体的区域；
 * 			JDesktopPane规定出了一个父窗体的基本形式，而JInternalFrame规定出了各个子窗体，JInternalFrame需要加入到JDesktopPane之中；
 * 		
 * @author jack
 *
 */
public class JInternalFrameDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Welcome TO MLDN") ; // 实例化窗体对象
		Container cont = frame.getContentPane() ;
		JDesktopPane desk = new JDesktopPane() ;	// 定义窗体的容器
		cont.add(desk,BorderLayout.CENTER) ;	// 设置显示样式
		cont.add(new JLabel("内部窗体"),BorderLayout.SOUTH) ;//添加显示内部窗体的组件
		JInternalFrame jif = null ;//声明内部窗体
		
		String picPath = System.getProperty("user.dir")+"/files/lixinghua/image/liya.png";
		Icon icon = new ImageIcon(picPath) ;	// 实例化Icon对象
		JPanel pan = null ;//声明面板
				
		for(int i=0;i<3;i++){
			jif = new JInternalFrame("MLDN-" + i,true,true,true,true) ;//实例化内部窗体，并设置其（可以改变大小、可以关闭、可以最大化、可以图标化）
			pan = new JPanel() ;//实例化面板
			pan.add(new JLabel(icon)) ;	//在面板中加入标签
			jif.setLocation(35 - i * 10 , 35 - i * 10) ; // 设置内部窗体的显示位置
			jif.add(pan) ;//在内部窗体中添加面板
			jif.pack() ;//自动调整内部窗体大小
			jif.setVisible(true) ;//设置内部窗体可见
			desk.add(jif) ;//在窗体容器中加入内部窗体
		}
		
		frame.setSize(474,487) ;//手动设置大小
		frame.setLocation(300,200) ;//设置窗体的大小
		frame.setVisible(true) ;//设置窗体可见
		
	}

}
