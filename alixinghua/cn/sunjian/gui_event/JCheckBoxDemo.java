package cn.sunjian.gui_event;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			��ѡ��ť������
 *		
 * @author sunjian
 *
 */
	
	
class MyItemListener implements ItemListener{
	private String right = System.getProperty("user.dir")+"/files/lixinghua/image/right.png" ;
	private String wrong = System.getProperty("user.dir")+"/files/lixinghua/image/wrong.gif" ;
	
	//��д���෽��
	public void itemStateChanged(ItemEvent e){
		// ������β�������϶���JCheckBox�����¼�
		JCheckBox jcb = (JCheckBox)e.getItem() ;	// �õ��������¼�
		
		if(jcb.isSelected()){	// �����ѡ���ˣ�����ʾ��ȷ��ͼƬ
			jcb.setIcon(new ImageIcon(right)) ;
		}else{
			jcb.setIcon(new ImageIcon(wrong)) ;
		}
	}
}

class MyCheckBox{
	private String wrong = System.getProperty("user.dir")+"/files/lixinghua/image/wrong.gif" ;
	
	private JFrame frame = new JFrame("JCheckBox") ;	// ���崰��
	private Container cont = frame.getContentPane() ;	// �õ���������
	
	private JCheckBox jcb1 = new JCheckBox("MLDN",new ImageIcon(wrong)) ;	// ����һ����ѡ��Ĭ����ʾ����ͼƬ��
	private JCheckBox jcb2 = new JCheckBox("MLDNJAVA",new ImageIcon(wrong)) ;	// ����һ����ѡ��
	private JCheckBox jcb3 = new JCheckBox("������",new ImageIcon(wrong)) ;	// ����һ����ѡ��
	
	private JPanel pan = new JPanel() ;//�������
	
	public MyCheckBox(){
		pan.setBorder(BorderFactory.createTitledBorder("��ѡ����ϲ������վ")) ;//���ñ߿���ʾ��
		
		pan.setLayout(new GridLayout(1,3)) ;	// ����������Ű� 
		pan.add(this.jcb1) ;	// ��������������
		pan.add(this.jcb2) ;	// �������
		pan.add(this.jcb3) ;	// �������

		jcb1.addItemListener(new MyItemListener()) ;//�������Ӽ����¼�
		jcb2.addItemListener(new MyItemListener()) ;
		jcb3.addItemListener(new MyItemListener()) ;

		cont.add(pan) ;	// �������뵽����֮��
		
		this.frame.setSize(500,180) ;	//���ô����С
		this.frame.setVisible(true) ;	// ���ÿ���ʾ
		
		this.frame.addWindowListener(new WindowAdapter(){//���崰��ر��¼�
			public void windowClosing(WindowEvent arg){
				System.exit(1) ;
			}
		});
	}

}

public class JCheckBoxDemo{
	public static void main(String args[]){
		
		new MyCheckBox() ;
	}
}