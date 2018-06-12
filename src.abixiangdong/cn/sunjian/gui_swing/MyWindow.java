package cn.sunjian.gui_swing;

/**
 * ʹ��swing��ܣ�ģ��Windows����
 * ���ı���������·���󣬻س����ߵ����ת��ť
 * ��ǰ�̷��е�������ʾ���ı�������
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
		
		//��Ӱ�ť�����¼�
		JButton button = new JButton("\u8DF3\u8F6C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�����ť�󣬵���showDir������������ʾ����
				showDir();
			}
		});
		
		button.setBounds(515, 10, 93, 23);
		contentPane.add(button);
		
		//��Ӽ��̼����¼�
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//������µļ������ǻس���enter��
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					//����showDir��������������ʾ����
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
		 * ͨ�������ť����ȡ�ı����е�Ŀ¼��Ȼ��Ŀ¼��������ʾ���ı�������
		 */
		
		//�õ��ı����е�·��
		String dir_str = textField.getText();
		//�ж�·���Ƿ���ʵ
		//newһ��·������
		File dir = new File(dir_str);
		//���·�����ڲ�����Ŀ¼
		if(dir.exists() && dir.isDirectory()){
			
			//���������һ��Ŀ¼��������ı���������ʾ
			textArea.setText("");
			
			//��ȡĿ¼�е������ļ�
			String[] names = dir.list();
			
			//�������е�����,��ʾ���ı�������
			for(String name : names){
				//textArea.setText(name);��������Ļ����ٴ������ı����֮ǰ�ĸ��ǵ�������������䣩
				//������append������ݵ��ı����򣬵���append��һ������ʾ������Ҫ�س�
				textArea.append(name+LINE_SEPARATOR);
			}
		}
	}
}
