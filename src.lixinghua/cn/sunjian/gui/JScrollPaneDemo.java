package cn.sunjian.gui;

import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 图形界面：
 * 	
 * 		JScollPane：
 * 			在Swing中JScrollPane的主要功能就是为显示的内容加入水平滚动条。
 * 			JScollPane主要由JViewport和JScrollBar两部分组成，前者主要是显示一个矩形的区域让用户浏览，而后者主要是形成水平或垂直的滚动条；	
 * 
 * @author jack
 *
 */
public class JScrollPaneDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("JScollPane") ; // 实例化窗体对象
		Container cont = frame.getContentPane() ;
		String picPath = System.getProperty("user.dir")+"/files/lixinghua/image/liya.png";
		Icon icon = new ImageIcon(picPath) ;	// 实例化Icon对象
		
		JPanel pan = new JPanel() ;//容器
		JLabel lab = new JLabel(icon) ;//组件
		
		JScrollPane scrl = null ;
		// 设置垂直和水平的滚动条一直显示
		scrl = new JScrollPane(pan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS) ;
		pan.add(lab) ;//添加组件到容器中
		cont.add(scrl) ;//添加滚动条到容器中
		frame.setSize(474,487) ;// 根据组件自动调整大小
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
		
	}

}
