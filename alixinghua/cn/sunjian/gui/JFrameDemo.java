package cn.sunjian.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

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
		Dimension d = new Dimension();
		
		d.setSize(230, 80);//���ô���Ŀ���
		
		f.setSize(d);//��������Ĵ�С
		f.setBackground(Color.BLACK);//���������óɰ�ɫ
		
		Point p = new Point(300, 200);//���ô�����ʾ��x��y������
		
		f.setLocation(p);//�����������ʾλ��
		f.setVisible(true);//��������ɼ�
	}

}
