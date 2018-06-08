package cn.sunjian.gui_event;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			�б��JList��
 * 				ʹ��ListModel�����б��
 *				�̳�AbstractListModelֻ�踲д����Ҫ�ķ���������ȫ����д���з�����
 *
 * 
 * @author sunjian
 *
 */
@SuppressWarnings("rawtypes")
class MyListModel extends AbstractListModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nations[] = {"�й�","����","����","����","�����","����"} ;

	public Object getElementAt(int index){
		if(index<this.nations.length){
			return this.nations[index] ;
		}else{
			return null ;
		}
	}
	public int getSize(){
		return this.nations.length ;
	}
}

class MyList implements ListSelectionListener{
	private JFrame frame = new JFrame("JListDemo") ;	//���崰��
	private Container cont = frame.getContentPane() ;	// �õ���������
	private JList<?> list1 = null ;//�����ѡ�б��
	private JList<?> list2 = null ;//���嵥ѡ�б��

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MyList(){
		this.frame.setLayout(new GridLayout(1,3)) ;	// �����Ű�
		
		String nations2[] = {"MLDN","MLDNJAVA","������","�ٶ�","�Ż�","��Ѷ"} ;
		Vector<String> v = new Vector<String>() ;
		for(int i=0;i<nations2.length;i++){
			v.add(nations2[i]);//�ڵ�ѡ�б�����������
		}
		
		this.list1 = new JList(new MyListModel()) ;//ʵ������ѡ�б��
		this.list2 = new JList<String>(v);//ʵ������ѡ�б��

		this.list1.setBorder(BorderFactory.createTitledBorder("��ϲ��ȥ�Ǹ��������Σ�")) ;
		this.list2.setBorder(BorderFactory.createTitledBorder("��ϲ���ĸ���վ"));

		this.list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) ;// ��ѡ�б��
		this.list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//��ѡ�б��

		this.cont.add(new JScrollPane(this.list1)) ;//���б��м���������������б����ӵ���������
		this.cont.add(new JScrollPane(this.list2)) ;//���б��м���������������б����ӵ���������

		this.frame.setSize(330,130) ;//���ô����С
		this.frame.setLocationRelativeTo(null);//���ô�����ʾ����Ļ�м�
		this.frame.setVisible(true) ;//���ô���ɼ�

		this.list1.addListSelectionListener(this) ;//���б���������¼�

		//��Ӵ���ر�ʱ��
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent a){
				System.exit(1) ;
			}
		}) ;
	}

	//��д��������ʹ��ListSelectionListener�ļ����ӿ�ʵ�ֶ�JList�е���ѡ����м�������ֵ�����ı�ʱ���ã�
	public void valueChanged(ListSelectionEvent e){	// �¼�����
		
		int temp[] = list1.getSelectedIndices() ;//�õ�ȫ������
		
		System.out.print("ѡ�������ݣ�") ;
		for(int i=0;i<temp.length;i++){
			System.out.print(list1.getModel().getElementAt(i) + "��") ;//��������ȡ�ö�ѡ�б����ȫ����ֵ
		}
		System.out.println() ;
	}

}

public class JListDemo{
	public static void main(String args[]){
		new MyList() ;
	}
}