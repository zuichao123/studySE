package cn.sunjian.gui;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ͼ�ν��棺
 * 	
 * 		JButton��
 * 			������ť��
 * 
 * @author jack
 *
 */
public class JButtonDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Welcome To MLDN");//ʵ�����������
		
		String picPath = System.getProperty("user.dir")+"/files/lixinghua/image/liya.png";
		Icon icon = new ImageIcon(picPath);
		
		JButton but = new JButton("����",icon);//��ͼƬ��ӵ���ť��
		Font font = new Font("Serief", Font.BOLD, 28);//��������
		
		
		but.setFont(font);
		frame.add(but);//����ť��ӵ�������
		frame.setSize(754, 944);//���ô����С
		frame.setLocation(300, 200);//���ô�������λ��
		
		frame.setVisible(true);//���ô���ɼ�
	}

}
