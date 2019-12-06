package cn.sunjian.gui_event;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			��ѡ��ť������
 * 				�ڸ����Ķ����ʾ��Ϣ��ָ��ѡ��һ������Swing��ʹ��JRadionButton��ɣ�
 *			   	���еİ�ť��Ҫ����һ����ButtonGroup�����У�����ʵ�ֵ�ѡ�Ĺ��ܣ�
 *		
 * @author sunjian
 *
 */
class MyRadio implements ItemListener{
	
	private String right = System.getProperty("user.dir")+"/files/lixinghua/image/right.png" ;
	private String wrong = System.getProperty("user.dir")+"/files/lixinghua/image/wrong.gif" ;
	
	private JFrame frame = new JFrame("JRadioButtonDemo") ;//����
	private Container cont = frame.getContentPane() ;//����
	
	private JRadioButton jrb1 = new JRadioButton("��",new ImageIcon(right),true) ;//��ѡ��ť��Ĭ��ѡ��(�Թ������ͼƬ)
	private JRadioButton jrb2 = new JRadioButton("Ů",new ImageIcon(wrong),false) ;
	//private JRadioButton jrb1 = new JRadioButton("��",false) ;//��ѡ��ť��Ĭ��ѡ��
	//private JRadioButton jrb2 = new JRadioButton("Ů",true) ;
	
	private JPanel pan = new JPanel() ;//���
	
	public MyRadio(){
		pan.setBorder(BorderFactory.createTitledBorder("ѡ���Ա�")) ;	// ����һ���߿����ʾ��
		pan.setLayout(new GridLayout(1,3)) ;//���ò��֣����ʽ��
		pan.add(this.jrb1) ;//���������ӵ�ѡ��ť
		pan.add(this.jrb2) ;
		
		ButtonGroup group = new ButtonGroup() ;//���嵥ѡ��ť��
		group.add(this.jrb1) ;//����ѡ��ť��ӵ���ť����
		group.add(this.jrb2) ;
		
		jrb1.addItemListener(this) ;//�ڵ�ѡ��ť����Ӽ���
		jrb2.addItemListener(this) ;

		cont.add(pan) ;//�������뵽������
		
		this.frame.setSize(500,200) ;//���ô����С
		this.frame.setVisible(true) ;//���ô���ɼ�
		
		this.frame.addWindowListener(new WindowAdapter(){//��Ӵ���ر��¼�
			public void windowClosing(WindowEvent obj){
				System.exit(1) ;
			}
		}) ;
	}
	
	//��д���෽��
	public void itemStateChanged(ItemEvent e){
		if(e.getSource()==jrb1){//��������ѡ��ť1����Թ�
			jrb1.setIcon(new ImageIcon(right)) ;
			jrb2.setIcon(new ImageIcon(wrong)) ;
			//jrb1.isSelected();
		}else{
			jrb1.setIcon(new ImageIcon(wrong)) ;
			jrb2.setIcon(new ImageIcon(right)) ;
			//jrb2.isSelected();
		
		}
	}
}

public class JRadioButtonDemo{
	public static void main(String args[]){
		
		new MyRadio() ;
	}
}