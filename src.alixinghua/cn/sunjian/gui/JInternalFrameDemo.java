package cn.sunjian.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ͼ�ν��棺
 * 	
 * 		JDesktopPane��JInternalFrame���ڲ�����
 * 			��Swing��Ҳ��������ڲ��������ʾ��������һ��������Գ��ֶ���Ӵ��壬ÿһ���Ӵ��嶼�޷����������������
 * 			JDesktopPane�涨����һ��������Ļ�����ʽ����JInternalFrame�涨���˸����Ӵ��壬JInternalFrame��Ҫ���뵽JDesktopPane֮�У�
 * 		
 * @author jack
 *
 */
public class JInternalFrameDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Welcome TO MLDN") ; // ʵ�����������
		Container cont = frame.getContentPane() ;
		JDesktopPane desk = new JDesktopPane() ;	// ���崰�������
		cont.add(desk,BorderLayout.CENTER) ;	// ������ʾ��ʽ
		cont.add(new JLabel("�ڲ�����"),BorderLayout.SOUTH) ;//�����ʾ�ڲ���������
		JInternalFrame jif = null ;//�����ڲ�����
		
		String picPath = System.getProperty("user.dir")+"/files/lixinghua/image/liya.png";
		Icon icon = new ImageIcon(picPath) ;	// ʵ����Icon����
		JPanel pan = null ;//�������
				
		for(int i=0;i<3;i++){
			jif = new JInternalFrame("MLDN-" + i,true,true,true,true) ;//ʵ�����ڲ����壬�������䣨���Ըı��С�����Թرա�������󻯡�����ͼ�껯��
			pan = new JPanel() ;//ʵ�������
			pan.add(new JLabel(icon)) ;	//������м����ǩ
			jif.setLocation(35 - i * 10 , 35 - i * 10) ; // �����ڲ��������ʾλ��
			jif.add(pan) ;//���ڲ�������������
			jif.pack() ;//�Զ������ڲ������С
			jif.setVisible(true) ;//�����ڲ�����ɼ�
			desk.add(jif) ;//�ڴ��������м����ڲ�����
		}
		
		frame.setSize(474,487) ;//�ֶ����ô�С
		frame.setLocation(300,200) ;//���ô���Ĵ�С
		frame.setVisible(true) ;//���ô���ɼ�
		
	}

}
