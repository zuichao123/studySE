package cn.sunjian.gui;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * ͼ�ν��棺
 * 	
 * 		JFrame��
 * 			�������壻
 * 
 * @author jack
 *
 */
public class JFrameDemo {

	public static void main(String[] args) {

		JFrame f = new JFrame("��һ��Swing����");
		f.setSize(250, 80);//��������Ĵ�С
		f.setBackground(Color.WHITE);//���������óɰ�ɫ
		f.setLocation(300, 200);//�����������ʾλ��
		f.setVisible(true);//��������ɼ�
	}

}
