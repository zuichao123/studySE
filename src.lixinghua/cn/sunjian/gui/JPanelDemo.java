package cn.sunjian.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 图形界面：
 * 	
 * 		JPanel容器：
 * 			JPanel也是一种经常用到的容器之一，可以使用JPanel完成各种复杂的界面显示。
 * 			在JPanel中可以加入任意的组件，之后直接将JPanel容器加入到JFrame容器中即可显示。
 * 
 * @author jack
 *
 */
public class JPanelDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("JPanel") ; // 实例化窗体对象
		JPanel pan = new JPanel() ;	// 准备好了一个面板
		// 现在所有的内容都加入到了JPanel之中
		pan.add(new JLabel("标签-A")) ;
		pan.add(new JLabel("标签-B")) ;
		pan.add(new JLabel("标签-C")) ;
		pan.add(new JButton("按钮-X")) ;
		pan.add(new JButton("按钮-Y")) ;
		pan.add(new JButton("按钮-Z")) ;
		frame.add(pan) ;// 将面板加入到窗体之上
		frame.pack() ;// 根据组件自动调整大小
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

}
