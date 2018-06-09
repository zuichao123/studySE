package cn.sunjian.gui_event;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 图形界面：
 * 
 * 		事件监听:
 * 			下拉列表框JComboBox；
 * 				实现下拉列表框改变，标签的字体大小；
 * 				
 * @author sunjian
 *
 */
class MyComboBox implements ItemListener,ActionListener{
	private JFrame frame = new JFrame("JComboBoxDemo") ;
	private Container cont = frame.getContentPane() ;	// 得到容器
	private JComboBox<Object> jcb1 = null ;			//定义下拉列表框
	private JLabel label = new JLabel("如意金箍棒") ;	// 定义标签
	private String fontSize[] = {"10","12","14","16","18","20","22","24","26","48","72"} ;
	public MyComboBox(){
		this.frame.setLayout(new GridLayout(2,2)) ;	// 定义排版
		this.jcb1 = new JComboBox<Object>(fontSize) ;	// 实例化下拉列表框

		this.jcb1.addItemListener(this) ;//给下拉列表框添加选中监听事件，调用覆写的itemStateChanged方法
		this.jcb1.addActionListener(this) ;	//给下拉列表框添加动作监听事件，调用覆写的actionPerformed方法

		this.jcb1.setEditable(true) ;	// 表示可以编辑

		// 为每一个下拉框增加一个边框
		this.jcb1.setBorder(BorderFactory.createTitledBorder("你喜欢去那个国家旅游？")) ;
		
		ComboBoxEditor editor = null ;
		editor = this.jcb1.getEditor() ;	/// 得到编辑对象
		this.jcb1.configureEditor(editor,"12") ;// 指定默认值
		this.jcb1.setMaximumRowCount(3) ;

		this.changeFontSize(12) ;	// 默认值
		
		cont.add(this.jcb1) ;//添加下拉选择框到容器中
		cont.add(label) ;//添加标签到容器中
		
		this.frame.setSize(300,150) ;
		this.frame.setVisible(true) ;
		
		//设置窗体的关闭事件
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.println("拜拜了您的:)");
				System.exit(1) ;
			}
		}) ;
	}
	
	//覆写方法，判断是否选中，如果选中将字体的大小设置为选中的大小
	public void itemStateChanged(ItemEvent e){
		if(e.getStateChange()==ItemEvent.SELECTED){	// 判断是否是选中
			
			String itemSize = (String)e.getItem() ;//得到选中的内容字符
			
			try{
				System.out.println("---ItemEvent performed-->："+e.paramString());
				this.changeFontSize(Integer.parseInt(itemSize)) ;//将字体改变为选中的大小
			}catch(Exception e1){
				
			}
		}
	}

	//覆写方法，操作时调用
	public void actionPerformed(ActionEvent e){
		String item = (String)this.jcb1.getSelectedItem();//得到当前下拉列表框中选中或输入的内容
		int size = 12 ;	// 设置一个默认大小
		try{
			size = Integer.parseInt(item) ;//改变大小为得到的内容的大小
		}catch(Exception e1){
			this.jcb1.getEditor().setItem("请输入数字！");
		}
		System.out.println("---action performed-->"+e.getActionCommand());
		
		this.changeFontSize(size) ;//改变字体大小

		// 判断给定的size是否存在，如果不存在则需要将新的内容设置上去
		if(!this.isExists(item))
		{
			this.jcb1.addItem(jcb1.getSelectedItem()) ;
			System.out.println("---已将您如输入的字体型号-->："+item+"加入到列表中！");
		}
	}
	
	//判断输入的内容是否存在
	public boolean isExists(String item){
		boolean flag = false ;
		for(int i=0;i<this.jcb1.getItemCount();i++){
			if(item.equals(this.jcb1.getItemAt(i))){
				flag = true ;
			}
		}
		return flag ;
	}
	
	//改变字体的大小
	public void changeFontSize(int size){
		Font fnt = new Font("Serief",Font.BOLD,size) ;
		this.label.setFont(fnt) ;
		System.out.println("---当前标签的字体大小-->：" + size) ;
	}

}

public class JComboBoxDemo{
	public static void main(String args[]){
		new MyComboBox() ;
	}
}