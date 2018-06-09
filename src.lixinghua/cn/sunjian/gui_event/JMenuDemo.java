package cn.sunjian.gui_event;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			�˵��б��JMenu��
 * 				ʵ�ֲ˵��б�������ѡ���ݼ��ȣ�
 * 				
 * @author sunjian
 *
 */
public class JMenuDemo{
	
	
	public static void main(String args[]){
		String fileIconPath = System.getProperty("user.dir")+"/files/lixinghua/image/file.gif";
		String newIconPath = System.getProperty("user.dir")+"/files/lixinghua/image/new.gif";
		String closeIconPath = System.getProperty("user.dir")+"/files/lixinghua/image/file.gif";
		String openIconPath = System.getProperty("user.dir")+"/files/lixinghua/image/file.gif";
		String exitIconPath = System.getProperty("user.dir")+"/files/lixinghua/image/file.gif";
		
		JFrame frame = new JFrame("JMenuDemo") ;//����
		Container cont = frame.getContentPane();//�õ���������
		final JTextArea text = new JTextArea() ;//�����ı������
		JScrollPane scrol = new JScrollPane(text);//������
		ImageIcon icon = new ImageIcon(fileIconPath);//����ͼƬ���������ļ��˵�ͼƬ·��
		JMenu menuFile = new JMenu("�ļ�") ;//����˵���ť���ļ���
		JMenuBar menuBar = new JMenuBar() ;//����˵����
		
		cont.add(scrol) ;	//��������������
		text.setEditable(true) ;	//���ö��������ɱ༭
		
		menuFile.setIcon(icon) ;//Ϊ�˵�����ͼƬ
		menuBar.add(menuFile) ;//ͨ��JMenubar��JMenu�˵����뵽������

		//����˵�ѡ��
		JMenuItem newItem = new JMenuItem("�½�",new ImageIcon(newIconPath)) ;
		JMenuItem openItem = new JMenuItem("��",new ImageIcon(openIconPath)) ;
		JMenuItem closeItem = new JMenuItem("�ر�",new ImageIcon(closeIconPath)) ;
		JMenuItem exitItem = new JMenuItem("�˳�",new ImageIcon(exitIconPath)) ;

		// ��ʱ���������ĸ��˵���ѡ��������֮�����ӿ�ݼ�
		newItem.setMnemonic('N') ;
		openItem.setMnemonic('O') ;
		closeItem.setMnemonic('C') ;
		exitItem.setMnemonic('E') ;

		newItem.setAccelerator(KeyStroke.getKeyStroke('N',java.awt.Event.CTRL_MASK)) ;
		openItem.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.CTRL_MASK)) ;
		closeItem.setAccelerator(KeyStroke.getKeyStroke('C',java.awt.Event.ALT_MASK)) ;
		exitItem.setAccelerator(KeyStroke.getKeyStroke('E',java.awt.Event.ALT_MASK)) ;

		//���˵�ѡ��½�����Ӽ����¼�
		newItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== ѡ���ˡ��½����˵���\n") ;
			}
		}) ;
		//���˵�ѡ��򿪡���Ӽ����¼�
		openItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== ѡ���ˡ��򿪡��˵���\n") ;
			}
		}) ;
		//���˵�ѡ��رա���Ӽ����¼�
		closeItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== ѡ���ˡ��رա��˵���\n") ;
			}
		}) ;
		//���˵�ѡ��˳�����Ӽ����¼�
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== ѡ���ˡ��˳����˵���\n") ;
			}
		}) ;

		//���˵�ѡ����ӵ��˵���
		menuFile.add(newItem) ;
		menuFile.add(openItem) ;
		menuFile.add(closeItem) ;
		menuFile.add(exitItem) ;

		frame.setJMenuBar(menuBar) ;	//���˵���ӵ������У��� �˵�����Ҫͨ���˷������ӵģ�
		
		//Ϊ������ӹر��¼�
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;
		frame.setSize(300,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
}