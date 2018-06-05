package cn.sunjian.gui;

import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * ͼ�ν��棺
 * 	
 * 		JScollPane��
 * 			��Swing��JScrollPane����Ҫ���ܾ���Ϊ��ʾ�����ݼ���ˮƽ��������
 * 			JScollPane��Ҫ��JViewport��JScrollBar��������ɣ�ǰ����Ҫ����ʾһ�����ε��������û��������������Ҫ���γ�ˮƽ��ֱ�Ĺ�������	
 * 
 * @author jack
 *
 */
public class JScrollPaneDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("JScollPane") ; // ʵ�����������
		Container cont = frame.getContentPane() ;
		String picPath = System.getProperty("user.dir")+"/files/lixinghua/image/liya.png";
		Icon icon = new ImageIcon(picPath) ;	// ʵ����Icon����
		
		JPanel pan = new JPanel() ;//����
		JLabel lab = new JLabel(icon) ;//���
		
		JScrollPane scrl = null ;
		// ���ô�ֱ��ˮƽ�Ĺ�����һֱ��ʾ
		scrl = new JScrollPane(pan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS) ;
		pan.add(lab) ;//��������������
		cont.add(scrl) ;//��ӹ�������������
		frame.setSize(474,487) ;// ��������Զ�������С
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
		
	}

}
