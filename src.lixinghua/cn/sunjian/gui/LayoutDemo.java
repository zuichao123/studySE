package cn.sunjian.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 图形界面：
 * 
 * 		布局管理器：
 * 			FlowLayout
 *				流式布局管理器；
 *			BorderLayout
 *				将一个窗体的版面划分为东西南北中五个区域，可以直接将需要的组件放到这五个区域中即可；
 *			GridLayout
 *				是以表格的形式进行管理的，在使用此布局管理器的时候必须设置显示的行数和列数；
 *			GardLayout
 *				将一组组件彼此重叠的进行布局，就像一张张卡片一样，这样每次只会展现一个界面；
 *			绝对定位；				
 *				通过设置绝对坐标的方式完成，在Component中提供了setBounds()方法，可以定位一个组件的坐标，使用X、Y的坐标表示方式，此方法定义如下：
 *   				public void setBounds(int x,int y,int width,int height);
 * 
 * @author jack
 *
 */
public class LayoutDemo {

	public static void main(String[] args) {

		FlowLayout();
		BorderLayout();
		GridLayout();
		GardLayout();
		AbsoluteLayout();
	}

	private static void AbsoluteLayout() {
		JFrame frame = new JFrame("AbsoluteLayout") ; 
		frame.setLayout(null) ;
		JLabel title = new JLabel("www.mldnjava.cn") ;
		JButton enter = new JButton("进入") ;
		JButton help = new JButton("帮助") ;
		frame.setSize(280,123) ;
		title.setBounds(45,5,150,20) ;
		enter.setBounds(10,30,80,20) ;
		help.setBounds(100,30,80,20) ;
		frame.add(title) ;
		frame.add(enter) ;
		frame.add(help) ;
		frame.setVisible(true) ;
	}

	private static void GardLayout() {
		JFrame frame = new JFrame("GardLayout") ; 
		CardLayout card = new CardLayout() ;
		frame.setLayout(card) ;
		Container con = frame.getContentPane() ;
		con.add(new JLabel("标签-A",JLabel.CENTER),"first") ;
		con.add(new JLabel("标签-B",JLabel.CENTER),"second") ;
		con.add(new JLabel("标签-C",JLabel.CENTER),"thrid") ;
		con.add(new JLabel("标签-D",JLabel.CENTER),"fourth") ;
		con.add(new JLabel("标签-E",JLabel.CENTER),"fifth") ;
		frame.pack() ;
		frame.setVisible(true) ;
		card.show(con,"thrid") ;
		for(int i=0;i<5;i++){
			try{
				Thread.sleep(2000) ;
			}catch(InterruptedException e){}
			card.next(con) ;
		}
	}

	private static void GridLayout() {
		JFrame frame = new JFrame("GridLayout");
		frame.setLayout(new java.awt.GridLayout(3,5,3,33));//设置按钮行、列、左右间距、上下间距
		JButton but = null;
		for(int i=0;i<13;i++){
			but = new JButton("按钮"+i);
			frame.add(but);
		}
		
		frame.pack();//根据组件自动决定窗体大小
		frame.setVisible(true);
	}

	private static void BorderLayout() {
		JFrame frame = new JFrame("BorderLayout");
		frame.setLayout(new java.awt.BorderLayout(3, 3));
		
		frame.add(new JButton("东（EAST）"),java.awt.BorderLayout.EAST);
		frame.add(new JButton("西（WEST）"),java.awt.BorderLayout.WEST);
		frame.add(new JButton("南（SOUTH）"),java.awt.BorderLayout.SOUTH);
		frame.add(new JButton("北（NORTH）"),java.awt.BorderLayout.NORTH);
		frame.add(new JButton("中（CENTER）"),java.awt.BorderLayout.CENTER);
		
		frame.setSize(400, 200);
		frame.setVisible(true);
	}

	private static void FlowLayout() {
		JFrame frame = new JFrame("FlowLayout");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));//左右间距、上下间距
		
		JButton but = null;
		for(int i=0;i<10;i++){
			but = new JButton("按钮"+i);
			frame.add(but);
		}
		
		frame.setSize(300, 200);
		frame.setVisible(true);
	}

}
