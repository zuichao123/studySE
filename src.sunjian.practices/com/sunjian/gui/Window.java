package com.sunjian.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.sunjian.io.InputData;




/**
 * java.io、图形界面：操作练习：
 * 
 * 	练习二：菜单显示
 * 
 * 		操作：
 * 			使用IO操作完成一个简单的菜单程序，如下所示：
 * 			xxxx系统
 * 			【1】增加数据
 * 			【2】删除数据
 * 			【3】修改数据
 * 			【4】查看数据
 * 			【0】系统退出
 * 			
 * 			请选择：
 * 
 * 			如果用户输入的编号不正确，则要给出错误提示，并等待用户重新选择
 * 
 * 		思路：
 * 			现在要求一个菜单的显示，但是实际上每个选项之后都肯定会有自己的若干个操作，
 * 			所有为了方便操作，建立以下几个类：
 * 			Menu类（专门显示菜单信息）
 * 			Operate（表示操作类）以后扩充功能时，直接修改此类
 * 
 * 		练习总结：
 * 			在开发中一定要先完成功能，之后再考虑类的设计；
 * 			主方法就是一个客户端，代码越少越好。
 * 
 * 
 * 	实例要求：
 * 		将之前的菜单程序进行扩充，要求：增加的时候可以增加一个人的完整信息，人的信息包括姓名和年龄。保存之后也可以修改此信息、删除此信息，查询此信息，此代码该如何完成？
 * 		提示：
 * 			使用对象的序列化保存。
 * 		此时程序了使用之前将过的的几个类：InputData、Person、Operate、Menu。
 * 		需要增加文件操作类，专门负责保存和读取文件的内容，以及修改Operate类，为其增减具体的操作，此时程序的操作如下：
 * 
 * @author sunjian
 *
 */
public class Window extends JFrame {
	
	JFrame mJFrame;
	Container content;
	JPanel mJpanle;
	JScrollPane mJtascrol;
	
	JLabel mJlGreeting;
	JLabel mJlOne;
	JLabel mJlTwo;
	JLabel mJlThree;
	JLabel mJlFour;
	JLabel mJlZero;
	JLabel mJlPleaseChoose;
	
	JTextField mJTextField;
	JTextArea mJTextArea;
	
	JComboBox<Object> mJcbPleaseChoose;
	
	JButton mJbConfirm;
	
	public void run(){
		
		int WIDTH_WINDOW = 1368;
		int HEIGHT_WINDOW = 768;
		int screenWidth = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
		int WINDOW_LOCATION_X = screenWidth / 2 - WIDTH_WINDOW / 2 + 50;
		int WINDOW_LOCATION_Y = screenHeight / 2 - HEIGHT_WINDOW / 2 + 30;
		String[] fontSize = {"   ","0","1","2","3","4"};
		
		this.mJFrame = new JFrame();
		this.content = mJFrame.getContentPane();
		this.mJpanle = new JPanel();	
		
		this.mJlGreeting = new JLabel("==-==XXX系统==-==");
		this.mJlOne = new JLabel("[1]、增加数据",SwingConstants.LEFT);
	    this.mJlTwo = new JLabel("[2]、删除数据");
	    this.mJlThree = new JLabel("[3]、修改数据");
	    this.mJlFour = new JLabel("[4]、查看数据");
	    this.mJlZero = new JLabel("[0]、系统退出");
	    this.mJTextField = new JTextField("请输入",10);
	    this.mJlPleaseChoose = new JLabel("请选择：");
	    this.mJcbPleaseChoose = new JComboBox<Object>(fontSize);
	    this.mJTextArea = new JTextArea(3,50);
	    this.mJbConfirm = new JButton("确定");
		
//	    this.mJpanle.setLayout(null);
		//设置添加的位置、大小等
	    this.mJpanle.setLayout(null);
		//***添加到面板中
		this.mJlGreeting.setSize(30, 30);
		this.mJlGreeting.setLocation(12, 5);
		this.mJlGreeting.setFont(new Font("宋体", Font.BOLD, 24));
		this.mJlGreeting.setBackground(Color.blue);
		this.mJpanle.add(mJlGreeting);
		
		this.mJlOne.setSize(30, 30);
		this.mJlOne.setLocation(100, 200);
		this.mJlOne.setFont(new Font("宋体", Font.CENTER_BASELINE, 14));
		this.mJlOne.setBackground(Color.BLACK);
		this.mJpanle.add(mJlOne);
		
		this.mJlTwo.setSize(30, 30);
		this.mJlTwo.setLocation(12,25);
		this.mJlTwo.setFont(new Font("宋体", Font.BOLD, 24));
		this.mJlTwo.setBackground(Color.blue);
		this.mJpanle.add(mJlTwo);
		
		this.mJlThree.setSize(30, 30);
		this.mJlThree.setLocation(12,35);
		this.mJlThree.setFont(new Font("宋体", Font.BOLD, 24));
		this.mJlThree.setBackground(Color.blue);
		this.mJpanle.add(mJlThree);
		
		this.mJlFour.setSize(30, 30);
		this.mJlFour.setLocation(12,45);
		this.mJlFour.setFont(new Font("宋体", Font.BOLD, 24));
		this.mJlFour.setBackground(Color.blue);
		this.mJpanle.add(mJlFour);
		
		this.mJlZero.setSize(30, 30);
		this.mJlZero.setLocation(12,55);
		this.mJlZero.setFont(new Font("宋体", Font.BOLD, 24));
		this.mJlZero.setBackground(Color.blue);
		this.mJpanle.add(mJlZero);
		
		this.mJlPleaseChoose.setSize(30, 30);
		this.mJlPleaseChoose.setLocation(12,65);
		this.mJlPleaseChoose.setFont(new Font("宋体", Font.BOLD, 24));
		this.mJlPleaseChoose.setBackground(Color.blue);
		this.mJpanle.add(mJlPleaseChoose);
		
		this.mJTextField.setSize(30, 30);
		this.mJTextField.setLocation(12,75);
		this.mJTextField.setFont(new Font("宋体", Font.BOLD, 24));
		this.mJTextField.setForeground(Color.lightGray);
		this.mJTextField.setBackground(Color.white);
		this.mJTextField.setEnabled(true);
		//this.mJpanle.add(mJTextField);	
		
		this.mJcbPleaseChoose.setSize(30, 30);
		this.mJcbPleaseChoose.setLocation(12,65);
		this.mJcbPleaseChoose.setFont(new Font("宋体", Font.BOLD, 24));
		this.mJcbPleaseChoose.setBackground(Color.white);
		this.mJcbPleaseChoose.setMaximumRowCount(3);
		this.mJtascrol = new JScrollPane(mJcbPleaseChoose);
		this.mJpanle.add(mJtascrol);

		this.mJTextArea.setSize(50, 50);
		this.mJTextArea.setLocation(12,85);
		this.mJTextArea.setFont(new Font("宋体", Font.BOLD, 14));
		this.mJTextArea.setBackground(Color.white);
		this.mJTextArea.setEnabled(true);
		this.mJTextArea.setLineWrap(true);
		this.mJtascrol = new JScrollPane(mJTextArea);//设置多行文本的滚动条
		this.mJpanle.add(mJtascrol);
		
		
		this.mJbConfirm.setSize(30,30);
		this.mJbConfirm.setLocation(100, 100);
		this.mJbConfirm.setFont(new Font("宋体", Font.HANGING_BASELINE, 26));
		this.mJpanle.add(mJbConfirm);
		
		
		this.content.add(mJpanle);//将面板添加到容器中
		
		//设置窗体
//		this.mJpanle.setLayout(null);
//		this.mJFrame.setLayout(null);
		this.mJFrame.setLocation(WINDOW_LOCATION_X,WINDOW_LOCATION_Y);
		this.mJFrame.setSize(1050,800);
//		this.mJFrame.setResizable(true);
		this.mJFrame.setVisible(true);
//		this.mJFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.mJFrame.setTitle("xxxx系统");	
			
		
		
		this.mJTextField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (mJTextField.getText().equals("请输入")) {
					mJTextField.setText("");
				}
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String mJcbContent = mJcbPleaseChoose.getSelectedItem().toString();
				
				if (e.getSource() == mJbConfirm) {
					
//					mJTextArea.setText("");
					
					if (mJcbContent.equals("1")) {
//						System.out.println("111111111");
						mJTextArea.append("请输入姓名：\n");
						
//						System.out.println("111111112");
						InputData input = new InputData();//实例化输入数据对象
//						System.out.println("111111113");
						mJTextArea.requestFocus();
						String name = input.getString1();
//						System.out.println("111111114");
						mJTextArea.setText("请输入年龄： 年龄必须是数字！\n");
//						System.out.println("111111115");
//						int age = input.getInt1();
//						System.out.println("111111116");
						
//						Person per = new Person(name, age);//实例化Person类
						
//						mJTextArea.setText(per.toString());
						
						JOptionPane.showMessageDialog(mJpanle, "添加成功");
						
						mJTextArea.append("添加成功\n");
						mJTextArea.append("添加成功\n");
						mJTextArea.append("添加成功\n");
						mJTextArea.append("添加成功\n");
						mJTextArea.append("添加成功");
					}
					if (mJcbContent.equals("2")) {
						mJTextArea.setText("");
//						Operate.delete();//调用删除操作
						mJTextArea.setText("删除成功");
					}
					if (mJcbContent.equals("3")) {
						mJTextArea.setText("");
						Operate.update();//调用更新操作
						mJTextArea.setText("更新成功");
					}
					if (mJcbContent.equals("4")) {
						mJTextArea.setText("");
						Operate.find();//调用查看操作
						mJTextArea.setText("查看成功");
					}
					if (mJcbContent.equals("0")) {
						mJTextArea.setText("拜拜");
						System.exit(1);//系统退出
						mJTextArea.setText("");
					}else {
						if (mJcbContent.equals("")) {
							mJTextArea.setText("请选择...");
						}
					}
				}	
			}
		});
		
		this.mJFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
		
	}

}
