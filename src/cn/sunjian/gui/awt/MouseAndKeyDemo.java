package cn.sunjian.gui.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * 鼠标键盘监听器
 * 
 * @author sunjian
 *
 */
public class MouseAndKeyDemo {
	
	private Frame f;
	private TextField tf;//文本框1
	private TextField tf1;//文本框2
	private Button but;//按钮
	
	
	//构造函数
	public MouseAndKeyDemo() {
		init();
	}
	public void init() {
		
		//1，创建窗体
		f = new Frame("演示鼠标和键盘监听");
		//2,设置窗体
		f.setBounds(400, 200, 500, 400);
			//设置布局为流式布局
			f.setLayout(new FlowLayout());
		//3.建立组件（设置文本框的长度为15（
			tf = new TextField(15);
			tf1 = new TextField(15);
			//建立按钮组件
			but = new Button("一个按钮");

		//4.添加组件（将文本框添加到窗体中）
		f.add(tf);
		f.add(tf1);
		f.add(but);
		
		//添加事件
		myEvent();

		//5，让窗体可见
		f.setVisible(true);
		
	}


	//事件
	public void myEvent() {
		
		//给文本框添加键盘监听
		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
//				System.out.println("key run"+":"+KeyEvent.getKeyText(e.getKeyCode())+":"+e.getKeyCode());
				
				int code = e.getKeyCode();
				//如果键盘按下的不是0--9的数字
				if (!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9)) {
					tf1.setText("必须是数字");
					e.consume();
				}
				
				//如果键盘按下的Ctrl+回车键
				if ((e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ENTER)) {
					System.out.println("enter run");
				}
				
			}
			
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//在窗体中添加监听
		f.addWindowListener(new WindowAdapter() {

			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				//关闭窗体
				System.exit(0);
			}				
		});
		
		//在按钮上添加一个鼠标监听
		but.addMouseListener(new MouseAdapter() {
			//定义成员变量记录鼠标进入按钮的次数
			private int count = 1;
			//定义成员变量记录鼠标双击按钮的次数
			private int count1 = 1;
			
			//覆盖鼠标的进入方法，进入一次在文本框中显示一次(non-Javadoc)
			@Override
			public void mouseEntered(MouseEvent e) {
				//在文本框中添加内容（进入按钮的次数）
				tf.setText("进入"+(count++)+"次");
			}
			
			//覆盖鼠标的点击方法
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//记录鼠标双击事件（在文本框中添加双击次数）
				if(e.getClickCount()==2)
					tf1.setText("双击"+(count1++)+"次");
			}
								
		});
		
	}
	
	
	
	
	public static void main(String[] args) {

		new MouseAndKeyDemo();
	}

}
