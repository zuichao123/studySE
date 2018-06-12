package cn.sunjian.gui_swing;

/**
 * ģ��Windows���ڣ����ļ��������ļ� 
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
		
		//�ڲ˵������һ���˵���Ŀ"��"
		menuItem = new JMenuItem("\u6253\u5F00");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//������򿪡�ʱ�����ô˷�������ʾһ��������ʾ����
				
				try {
					JMenuItemActionPerformed(e);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			
			}
		});
		menu.add(menuItem);
		//�ڲ˵������һ���˵���Ŀ"����"
		menuItem_1 = new JMenuItem("\u4FDD\u5B58");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//��������桱��ťʱ�����ô˷���
				
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
		//������ʾ���ļ�����
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG & GIF Images", "jpg", "gif");
	    
	    chooser.setFileFilter(filter);
	    
	    //��ʾ��һ���Ի��򣬲�����״̬
	    int returnVal = chooser.showOpenDialog(this);
	    
	    //ѡ�����������ȷ����ť����ʾ��ѡ����ļ�Ϊ��������
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }
	    
	    //�ж��ļ���״̬(����������ȡ����ť����ʾһ�º��˳�)
	    if(returnVal == JFileChooser.CANCEL_OPTION){
	    	System.out.println("û��ѡȡ�ļ���ȡ����");
	    	return;
	    }
	    
	    //�õ�ѡ����ļ�(���ص���File����)
	    File file = chooser.getSelectedFile();
	    
	    //��ȡ�õ����ļ������ݷŵ��ı�������
	    BufferedReader bufr = new BufferedReader(new FileReader(file));
	    
	    String line = null;
	    while((line=bufr.readLine())!=null){
	    	textArea.append(line+LINE_SEPARATOR);
	    }
	    //�رն�ȡ��
	    bufr.close();
		
	}

	private void jMenuItem2ActionPerformed(ActionEvent e) throws IOException {
		chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(this);
		if (returnVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("û��ָ���ļ���ȡ����");
			return;
		}
		
		File file = chooser.getSelectedFile();
		String text = textArea.getText();
		
		BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
		bufw.write(text);
		bufw.close();

	}

}
