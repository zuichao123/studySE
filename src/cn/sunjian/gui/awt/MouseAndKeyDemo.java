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
 * �����̼�����
 * 
 * @author sunjian
 *
 */
public class MouseAndKeyDemo {
	
	private Frame f;
	private TextField tf;//�ı���1
	private TextField tf1;//�ı���2
	private Button but;//��ť
	
	
	//���캯��
	public MouseAndKeyDemo() {
		init();
	}
	public void init() {
		
		//1����������
		f = new Frame("��ʾ���ͼ��̼���");
		//2,���ô���
		f.setBounds(400, 200, 500, 400);
			//���ò���Ϊ��ʽ����
			f.setLayout(new FlowLayout());
		//3.��������������ı���ĳ���Ϊ15��
			tf = new TextField(15);
			tf1 = new TextField(15);
			//������ť���
			but = new Button("һ����ť");

		//4.�����������ı�����ӵ������У�
		f.add(tf);
		f.add(tf1);
		f.add(but);
		
		//����¼�
		myEvent();

		//5���ô���ɼ�
		f.setVisible(true);
		
	}


	//�¼�
	public void myEvent() {
		
		//���ı�����Ӽ��̼���
		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
//				System.out.println("key run"+":"+KeyEvent.getKeyText(e.getKeyCode())+":"+e.getKeyCode());
				
				int code = e.getKeyCode();
				//������̰��µĲ���0--9������
				if (!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9)) {
					tf1.setText("����������");
					e.consume();
				}
				
				//������̰��µ�Ctrl+�س���
				if ((e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ENTER)) {
					System.out.println("enter run");
				}
				
			}
			
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//�ڴ�������Ӽ���
		f.addWindowListener(new WindowAdapter() {

			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				//�رմ���
				System.exit(0);
			}				
		});
		
		//�ڰ�ť�����һ��������
		but.addMouseListener(new MouseAdapter() {
			//�����Ա������¼�����밴ť�Ĵ���
			private int count = 1;
			//�����Ա������¼���˫����ť�Ĵ���
			private int count1 = 1;
			
			//�������Ľ��뷽��������һ�����ı�������ʾһ��(non-Javadoc)
			@Override
			public void mouseEntered(MouseEvent e) {
				//���ı�����������ݣ����밴ť�Ĵ�����
				tf.setText("����"+(count++)+"��");
			}
			
			//�������ĵ������
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//��¼���˫���¼������ı��������˫��������
				if(e.getClickCount()==2)
					tf1.setText("˫��"+(count1++)+"��");
			}
								
		});
		
	}
	
	
	
	
	public static void main(String[] args) {

		new MouseAndKeyDemo();
	}

}
