package cn.sunjian.gui;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * 图形界面：
 * 	
 * 		JTabbedPane：
 * 			是在一个面板上设置多个选项卡供用户选择；
 * 
 * @author jack
 *
 */
public class JTabbedPaneDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("JTabbedPane") ; // 实例化窗体对象
		Container cont = frame.getContentPane() ;
		JTabbedPane tab = null ;
		tab = new JTabbedPane(JTabbedPane.TOP) ;// 设置标签在顶部显示
		JPanel pan1 = new JPanel() ;
		JPanel pan2 = new JPanel() ;
		JButton but = new JButton("按钮") ;
		JLabel lab = new JLabel("标签") ;
		pan1.add(but) ;
		pan2.add(lab) ;
		String picPath = System.getProperty("user.dir")+"/files/lixinghua/image/liya.jpg";
		tab.addTab("图片选项",new ImageIcon(picPath),pan1,"这是个图象") ;
		tab.addTab("文字选项",pan2) ;	
		cont.add(tab) ;
		frame.setSize(330,245);// 根据组件自动调整大小
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

}
