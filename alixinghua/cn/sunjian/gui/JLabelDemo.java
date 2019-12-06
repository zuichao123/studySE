package cn.sunjian.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * ͼ�ν��棺
 * 	
 * 		JLabel��
 * 			���������
 * 			�������壻
 * 			���ͼƬ������У�
 * 
 * @author jack
 *
 */
public class JLabelDemo {

	public static void main(String[] args) {

		JFrame frame = null;
		JLabel label = null;
		Font fnt = null;
		Icon icon = null;		
		
		String picPath = System.getProperty("user.dir")+"/files/lixinghua/image/liya.png";
		
		frame = new JFrame("Welcome to MLDN");
		fnt = new Font("Serief", Font.ITALIC + Font.BOLD, 26);//��������Ϊ��б��
		icon = new ImageIcon(picPath);//ʵ��������ͼƬ��ַ����

		label = new JLabel("ѾѾ",icon,JLabel.CENTER);//ʵ������ǩ����(������ʾ[������ͼƬ])
		
		label.setFont(fnt);//�������ʽ���õ���ǩ��
		label.setForeground(Color.RED);//���ñ�ǩ��������ɫ
		label.setBackground(Color.YELLOW);//���ô���ı�����ɫ
		
		frame.add(label);//�������ӵ����֮��
		Dimension dim = new Dimension();
		
		frame.setBackground(Color.WHITE);//���ô���ı�����ɫ
		dim.setSize(744, 944);//��������Ŀ�ȡ��߶�
		frame.setSize(dim);//���ô����С
		
		Point point = new Point(600,40);//��������
		frame.setLocation(point);//���������õ�������
		
		frame.setVisible(true);//���ô���ɼ�
		
	}

}
