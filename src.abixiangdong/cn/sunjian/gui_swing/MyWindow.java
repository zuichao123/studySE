package cn.sunjian.gui_swing;

/**
 * 使用swing框架，模仿Windows窗口
 * 在文本框中输入路径后，回车或者点击跳转按钮
 * 当前盘符中的内容显示在文本区域中
 */

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class MyWindow extends JFrame {

	protected static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyWindow frame = new MyWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//添加按钮监听事件
		JButton button = new JButton("\u8DF3\u8F6C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//点击按钮后，调用showDir方法将内容显示出来
				showDir();
			}
		});
		
		button.setBounds(515, 10, 93, 23);
		contentPane.add(button);
		
		//添加键盘监听事件
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//如果按下的键盘码是回车“enter”
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					//调用showDir方法，将内容显示出来
					showDir();
				}
			}
		});
		
		textField.setBounds(10, 11, 495, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 598, 289);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	public void showDir() {
		/*
		 * 通过点击按钮，获取文本框中的目录，然后将目录中内容显示到文本区域中
		 */
		
		//拿到文本框中的路径
		String dir_str = textField.getText();
		//判断路径是否真实
		//new一个路径对象
		File dir = new File(dir_str);
		//如果路径存在并且是目录
		if(dir.exists() && dir.isDirectory()){
			
			//如果满足是一个目录，先清空文本区域再显示
			textArea.setText("");
			
			//获取目录中的所有文件
			String[] names = dir.list();
			
			//遍历所有的内容,显示在文本区域中
			for(String name : names){
				//textArea.setText(name);如果用这句的话，再次设置文本会把之前的覆盖掉（叫做重新填充）
				//所有用append添加内容到文本区域，但是append是一横行显示，所有要回车
				textArea.append(name+LINE_SEPARATOR);
			}
		}
	}
}
