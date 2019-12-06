package cn.sunjian.gui_awt;

/**
 * ����
 * 
 * �����е�������Ƕ���ֱ��new�Ϳ�����ӽ���
 * 
 * ���裺
 * 1,�������岢����������
 * 2.���������
 * 3.�������ӵ�������
 * 4.�ô�����ʾ
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
		 * 1,�������岢����������
		 */
		
		//����һ������
		Frame f = new Frame("my frame");
		//���ô��ڵĴ�С
		f.setSize(500, 400);
		
		//���ô��ڳ�������Ļ��λ��
		f.setLocation(400, 200);
		
		//��������λ�á����
//		f.setBounds(500, 400, 400, 200);
		
		//���ò��֣���ʽ���֣�
		f.setLayout(new FlowLayout());		
		
		/*
		 * 2.���������
		 */	
		
		//��������Ӱ�ť���
		Button button = new Button("һ����ť");
		
		/*
		 * 3.�������ӵ�������
		 */
		
		f.add(button);//����ť��ӵ�������
		
		//�ڴ�������Ӽ�����(ͨ�������ڲ��෽ʽ��ͨ��WindowAdapter�����������ô��ڵĹرշ���)
		f.addWindowListener(new WindowAdapter() {

			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				
				//��һ�ιرհ�ť�����һ��
//				System.out.println("closing..."+e);
//				super.windowClosing(e);
				
				//�رմ���
				System.exit(0);
			}
			
			
		});
		
		
		//�ڰ�ť�����һ��������
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
//				System.out.println("button run...");
				//�����ť���˳�
				System.exit(0);
			}
		});
		
		
		
		
		
		
		/*
		 * 4.�ô���ɼ�
		 */
		
		//���ô��ڿɼ�
		f.setVisible(true);
		
		
		
		
		System.out.println("over");
		
	}

}
