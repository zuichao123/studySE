package cn.sunjian.gui_awt;

/**
 * 窗体
 * 
 * 窗体中的组件皆是对象，直接new就可以添加进来
 * 
 * 步骤：
 * 1,创建窗体并做基本设置
 * 2.建立其组件
 * 3.将组件添加到窗体中
 * 4.让窗体显示
 * 
 * 
 */

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {

	public static void main(String[] args) {
		/*
		 * 1,创建窗体并做基本设置
		 */
		
		//创建一个窗口
		Frame f = new Frame("my frame");
		//设置窗口的大小
		f.setSize(500, 400);
		
		//设置窗口出现在屏幕的位置
		f.setLocation(400, 200);
		
		//设置上下位置、宽高
//		f.setBounds(500, 400, 400, 200);
		
		//设置布局（流式布局）
		f.setLayout(new FlowLayout());		
		
		/*
		 * 2.建立其组件
		 */	
		
		//给窗口添加按钮组件
		Button button = new Button("一个按钮");
		
		/*
		 * 3.将组件添加到窗体中
		 */
		
		f.add(button);//将按钮添加到窗体中
		
		//在窗体上添加监听器(通过匿名内部类方式，通过WindowAdapter适配器，调用窗口的关闭方法)
		f.addWindowListener(new WindowAdapter() {

			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				
				//点一次关闭按钮就输出一次
//				System.out.println("closing..."+e);
//				super.windowClosing(e);
				
				//关闭窗体
				System.exit(0);
			}
			
			
		});
		
		
		//在按钮上添加一个监听器
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
//				System.out.println("button run...");
				//点击按钮就退出
				System.exit(0);
			}
		});
		
		
		
		
		
		
		/*
		 * 4.让窗体可见
		 */
		
		//设置窗口可见
		f.setVisible(true);
		
		
		
		
		System.out.println("over");
		
	}

}
