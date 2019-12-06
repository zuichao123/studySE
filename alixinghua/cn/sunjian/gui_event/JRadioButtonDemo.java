package cn.sunjian.gui_event;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 图形界面：
 * 
 * 		事件监听:
 * 			单选按钮监听：
 * 				在给出的多个显示信息中指定选择一个，在Swing中使用JRadionButton完成；
 *			   	所有的按钮需要放在一个（ButtonGroup）组中，才能实现单选的功能；
 *		
 * @author sunjian
 *
 */
class MyRadio implements ItemListener{
	
	private String right = System.getProperty("user.dir")+"/files/lixinghua/image/right.png" ;
	private String wrong = System.getProperty("user.dir")+"/files/lixinghua/image/wrong.gif" ;
	
	private JFrame frame = new JFrame("JRadioButtonDemo") ;//窗体
	private Container cont = frame.getContentPane() ;//容器
	
	private JRadioButton jrb1 = new JRadioButton("男",new ImageIcon(right),true) ;//单选按钮，默认选中(对钩、错号图片)
	private JRadioButton jrb2 = new JRadioButton("女",new ImageIcon(wrong),false) ;
	//private JRadioButton jrb1 = new JRadioButton("男",false) ;//单选按钮，默认选中
	//private JRadioButton jrb2 = new JRadioButton("女",true) ;
	
	private JPanel pan = new JPanel() ;//面板
	
	public MyRadio(){
		pan.setBorder(BorderFactory.createTitledBorder("选择性别")) ;	// 设置一个边框的显示条
		pan.setLayout(new GridLayout(1,3)) ;//设置布局（表格式）
		pan.add(this.jrb1) ;//在面板中添加单选按钮
		pan.add(this.jrb2) ;
		
		ButtonGroup group = new ButtonGroup() ;//定义单选按钮组
		group.add(this.jrb1) ;//将单选按钮添加到按钮组中
		group.add(this.jrb2) ;
		
		jrb1.addItemListener(this) ;//在单选按钮上添加监听
		jrb2.addItemListener(this) ;

		cont.add(pan) ;//将面板加入到容器中
		
		this.frame.setSize(500,200) ;//设置窗体大小
		this.frame.setVisible(true) ;//设置窗体可见
		
		this.frame.addWindowListener(new WindowAdapter(){//添加窗体关闭事件
			public void windowClosing(WindowEvent obj){
				System.exit(1) ;
			}
		}) ;
	}
	
	//覆写父类方法
	public void itemStateChanged(ItemEvent e){
		if(e.getSource()==jrb1){//如果点击单选按钮1，打对钩
			jrb1.setIcon(new ImageIcon(right)) ;
			jrb2.setIcon(new ImageIcon(wrong)) ;
			//jrb1.isSelected();
		}else{
			jrb1.setIcon(new ImageIcon(wrong)) ;
			jrb2.setIcon(new ImageIcon(right)) ;
			//jrb2.isSelected();
		
		}
	}
}

public class JRadioButtonDemo{
	public static void main(String args[]){
		
		new MyRadio() ;
	}
}