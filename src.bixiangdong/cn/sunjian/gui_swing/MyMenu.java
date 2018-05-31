package cn.sunjian.gui_swing;

/**
 * 模仿Windows窗口，打开文件，保存文件 
 * 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class MyMenu extends JFrame {
	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private JPanel contentPane;
	private JFileChooser chooser;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JScrollPane scrollPane;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMenu frame = new MyMenu();
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
	public MyMenu(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6587\u4EF6");
		menuBar.add(menu);
		
		//在菜单中添加一个菜单条目"打开"
		menuItem = new JMenuItem("\u6253\u5F00");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//点击“打开”时，调用此方法，显示一个窗口显示内容
				
				try {
					JMenuItemActionPerformed(e);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			
			}
		});
		menu.add(menuItem);
		//在菜单中添加一个菜单条目"保存"
		menuItem_1 = new JMenuItem("\u4FDD\u5B58");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//点击“保存”按钮时，调用此方法
				
				try {
					jMenuItem2ActionPerformed(e);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	private void JMenuItemActionPerformed(ActionEvent e) throws IOException {
		
		chooser = new JFileChooser();
		//过滤显示的文件类型
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG & GIF Images", "jpg", "gif");
	    
	    chooser.setFileFilter(filter);
	    
	    //显示打开一个对话框，并返回状态
	    int returnVal = chooser.showOpenDialog(this);
	    
	    //选择完后，如果点击确定按钮，提示你选择的文件为。。。。
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }
	    
	    //判断文件的状态(如果点击的是取消按钮，提示一下后，退出)
	    if(returnVal == JFileChooser.CANCEL_OPTION){
	    	System.out.println("没有选取文件，取消了");
	    	return;
	    }
	    
	    //拿到选择的文件(返回的是File对象)
	    File file = chooser.getSelectedFile();
	    
	    //读取拿到的文件的内容放到文本区域中
	    BufferedReader bufr = new BufferedReader(new FileReader(file));
	    
	    String line = null;
	    while((line=bufr.readLine())!=null){
	    	textArea.append(line+LINE_SEPARATOR);
	    }
	    //关闭读取流
	    bufr.close();
		
	}

	private void jMenuItem2ActionPerformed(ActionEvent e) throws IOException {
		chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(this);
		if (returnVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("没有指定文件，取消了");
			return;
		}
		
		File file = chooser.getSelectedFile();
		String text = textArea.getText();
		
		BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
		bufw.write(text);
		bufw.close();

	}

}
