package cn.sunjian.gui_event;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 图形界面：
 * 
 * 		事件监听:
 * 			复选按钮监听：
 *		
 * @author sunjian
 *
 */
	
	
class MyItemListener implements ItemListener{
	private String right = System.getProperty("user.dir")+"/files/lixinghua/image/right.png" ;
	private String wrong = System.getProperty("user.dir")+"/files/lixinghua/image/wrong.gif" ;
	
	//覆写父类方法
	public void itemStateChanged(ItemEvent e){
		// 不管如何操作，则肯定由JCheckBox产生事件
		JCheckBox jcb = (JCheckBox)e.getItem() ;	// 得到产生的事件
		
		if(jcb.isSelected()){	// 如果被选中了，则显示正确的图片
			jcb.setIcon(new ImageIcon(right)) ;
		}else{
			jcb.setIcon(new ImageIcon(wrong)) ;
		}
	}
}

class MyCheckBox{
	private String wrong = System.getProperty("user.dir")+"/files/lixinghua/image/wrong.gif" ;
	
	private JFrame frame = new JFrame("JCheckBox") ;	// 定义窗体
	private Container cont = frame.getContentPane() ;	// 得到窗体容器
	
	private JCheckBox jcb1 = new JCheckBox("MLDN",new ImageIcon(wrong)) ;	// 定义一个复选框（默认显示错误图片）
	private JCheckBox jcb2 = new JCheckBox("MLDNJAVA",new ImageIcon(wrong)) ;	// 定义一个复选框
	private JCheckBox jcb3 = new JCheckBox("智囊团",new ImageIcon(wrong)) ;	// 定义一个复选框
	
	private JPanel pan = new JPanel() ;//定义面板
	
	public MyCheckBox(){
		pan.setBorder(BorderFactory.createTitledBorder("请选择最喜爱的网站")) ;//设置边框提示语
		
		pan.setLayout(new GridLayout(1,3)) ;	// 设置组件的排版 
		pan.add(this.jcb1) ;	// 在面板中增加组件
		pan.add(this.jcb2) ;	// 增加组件
		pan.add(this.jcb3) ;	// 增加组件

		jcb1.addItemListener(new MyItemListener()) ;//给组件添加监听事件
		jcb2.addItemListener(new MyItemListener()) ;
		jcb3.addItemListener(new MyItemListener()) ;

		cont.add(pan) ;	// 将面板加入到容器之中
		
		this.frame.setSize(500,180) ;	//设置窗体大小
		this.frame.setVisible(true) ;	// 设置可显示
		
		this.frame.addWindowListener(new WindowAdapter(){//定义窗体关闭事件
			public void windowClosing(WindowEvent arg){
				System.exit(1) ;
			}
		});
	}

}

public class JCheckBoxDemo{
	public static void main(String args[]){
		
		new MyCheckBox() ;
	}
}