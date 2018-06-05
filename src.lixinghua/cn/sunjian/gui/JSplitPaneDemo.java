package cn.sunjian.gui;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

/**
 * 图形界面：
 * 	
 * 		JSplitPane：
 * 			分隔面板，可以将一个窗体分隔为两个子窗体，可以是水平排列也可以是垂直排列；
 * 
 * @author jack
 *
 */
public class JSplitPaneDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("JSplitPane") ; // 实例化窗体对象
		Container cont = frame.getContentPane();	
		
		JSplitPane lfsplit = null ;	// 左右分割
		JSplitPane tpsplit = null ;	// 上下分割

		lfsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JLabel("左标签"),new JLabel("右标签")) ;
		lfsplit.setDividerSize(3) ;	// 设置左右分割条的分割线大小
		tpsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,lfsplit,new JLabel("下标签")) ;
		tpsplit.setDividerSize(10) ;	// 设置左右分割条的分割线大小
		tpsplit.setOneTouchExpandable(true) ;//设置分隔条显示
		cont.add(tpsplit) ;//将JSplitPane加入到窗体中
		frame.pack() ;// 根据组件自动调整大小
		frame.setLocation(300,200) ;//设置窗体的显示位置
		frame.setVisible(true) ;
	}

}
