package cn.sunjian.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ͼ�ν��棺
 * 
 * 		���ֹ�������
 * 			��ʽ���֣�
 * 
 * @author jack
 *
 */
public class LayoutDemo {

	public static void main(String[] args) {

		FlowLayout();
		BorderLayout();
		
	}

	private static void BorderLayout() {
		
	}

	private static void FlowLayout() {
		JFrame frame = new JFrame("FlowLayout");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
		
		JButton but = null;
		for(int i=0;i<10;i++){
			but = new JButton("��ť"+i);
			frame.add(but);
		}
		
		frame.setSize(300, 200);
		frame.setVisible(true);
	}

}
