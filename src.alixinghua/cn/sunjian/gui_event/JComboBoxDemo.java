package cn.sunjian.gui_event;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			�����б��JComboBox��
 * 				ʵ�������б��ı䣬��ǩ�������С��
 * 				
 * @author sunjian
 *
 */
class MyComboBox implements ItemListener,ActionListener{
	private JFrame frame = new JFrame("JComboBoxDemo") ;
	private Container cont = frame.getContentPane() ;	// �õ�����
	private JComboBox<Object> jcb1 = null ;			//���������б��
	private JLabel label = new JLabel("����𹿰�") ;	// �����ǩ
	private String fontSize[] = {"10","12","14","16","18","20","22","24","26","48","72"} ;
	public MyComboBox(){
		this.frame.setLayout(new GridLayout(2,2)) ;	// �����Ű�
		this.jcb1 = new JComboBox<Object>(fontSize) ;	// ʵ���������б��

		this.jcb1.addItemListener(this) ;//�������б�����ѡ�м����¼������ø�д��itemStateChanged����
		this.jcb1.addActionListener(this) ;	//�������б����Ӷ��������¼������ø�д��actionPerformed����

		this.jcb1.setEditable(true) ;	// ��ʾ���Ա༭

		// Ϊÿһ������������һ���߿�
		this.jcb1.setBorder(BorderFactory.createTitledBorder("��ϲ��ȥ�Ǹ��������Σ�")) ;
		
		ComboBoxEditor editor = null ;
		editor = this.jcb1.getEditor() ;	/// �õ��༭����
		this.jcb1.configureEditor(editor,"12") ;// ָ��Ĭ��ֵ
		this.jcb1.setMaximumRowCount(3) ;

		this.changeFontSize(12) ;	// Ĭ��ֵ
		
		cont.add(this.jcb1) ;//�������ѡ���������
		cont.add(label) ;//��ӱ�ǩ��������
		
		this.frame.setSize(300,150) ;
		this.frame.setVisible(true) ;
		
		//���ô���Ĺر��¼�
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.println("�ݰ�������:)");
				System.exit(1) ;
			}
		}) ;
	}
	
	//��д�������ж��Ƿ�ѡ�У����ѡ�н�����Ĵ�С����Ϊѡ�еĴ�С
	public void itemStateChanged(ItemEvent e){
		if(e.getStateChange()==ItemEvent.SELECTED){	// �ж��Ƿ���ѡ��
			
			String itemSize = (String)e.getItem() ;//�õ�ѡ�е������ַ�
			
			try{
				System.out.println("---ItemEvent performed-->��"+e.paramString());
				this.changeFontSize(Integer.parseInt(itemSize)) ;//������ı�Ϊѡ�еĴ�С
			}catch(Exception e1){
				
			}
		}
	}

	//��д����������ʱ����
	public void actionPerformed(ActionEvent e){
		String item = (String)this.jcb1.getSelectedItem();//�õ���ǰ�����б����ѡ�л����������
		int size = 12 ;	// ����һ��Ĭ�ϴ�С
		try{
			size = Integer.parseInt(item) ;//�ı��СΪ�õ������ݵĴ�С
		}catch(Exception e1){
			this.jcb1.getEditor().setItem("���������֣�");
		}
		System.out.println("---action performed-->"+e.getActionCommand());
		
		this.changeFontSize(size) ;//�ı������С

		// �жϸ�����size�Ƿ���ڣ��������������Ҫ���µ�����������ȥ
		if(!this.isExists(item))
		{
			this.jcb1.addItem(jcb1.getSelectedItem()) ;
			System.out.println("---�ѽ���������������ͺ�-->��"+item+"���뵽�б��У�");
		}
	}
	
	//�ж�����������Ƿ����
	public boolean isExists(String item){
		boolean flag = false ;
		for(int i=0;i<this.jcb1.getItemCount();i++){
			if(item.equals(this.jcb1.getItemAt(i))){
				flag = true ;
			}
		}
		return flag ;
	}
	
	//�ı�����Ĵ�С
	public void changeFontSize(int size){
		Font fnt = new Font("Serief",Font.BOLD,size) ;
		this.label.setFont(fnt) ;
		System.out.println("---��ǰ��ǩ�������С-->��" + size) ;
	}

}

public class JComboBoxDemo{
	public static void main(String args[]){
		new MyComboBox() ;
	}
}