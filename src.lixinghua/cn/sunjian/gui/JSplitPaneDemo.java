package cn.sunjian.gui;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

/**
 * ͼ�ν��棺
 * 	
 * 		JSplitPane��
 * 			�ָ���壬���Խ�һ������ָ�Ϊ�����Ӵ��壬������ˮƽ����Ҳ�����Ǵ�ֱ���У�
 * 
 * @author jack
 *
 */
public class JSplitPaneDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("JSplitPane") ; // ʵ�����������
		Container cont = frame.getContentPane();	
		
		JSplitPane lfsplit = null ;	// ���ҷָ�
		JSplitPane tpsplit = null ;	// ���·ָ�

		lfsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JLabel("���ǩ"),new JLabel("�ұ�ǩ")) ;
		lfsplit.setDividerSize(3) ;	// �������ҷָ����ķָ��ߴ�С
		tpsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,lfsplit,new JLabel("�±�ǩ")) ;
		tpsplit.setDividerSize(10) ;	// �������ҷָ����ķָ��ߴ�С
		tpsplit.setOneTouchExpandable(true) ;//���÷ָ�����ʾ
		cont.add(tpsplit) ;//��JSplitPane���뵽������
		frame.pack() ;// ��������Զ�������С
		frame.setLocation(300,200) ;//���ô������ʾλ��
		frame.setVisible(true) ;
	}

}
