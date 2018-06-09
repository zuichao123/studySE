package cn.sunjian.gui_event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			���
 * 				ʵ����ͨ���
 * 				ʵ�ֶ�̬�ı��
 * 				
 * @author sunjian
 *
 */

/**
 * ��̬���
 * @author sunjian
 *
 */
class ChangeTable implements ActionListener{	// ͨ����ťʵ�ֶ�̬���
	private JFrame frame = new JFrame("Welcome To MLDN") ; 
	private JTable table = null ;	//���
	private DefaultTableModel tableModel ;	// TableModel
	private JComboBox<String> sexList = new JComboBox<String>();//����ѡ���
	
	// ��������
	private String[] titles = {"����","����","�Ա�","��ѧ�ɼ�","Ӣ��ɼ�","�ܷ�","�Ƿ񼰸�"} ;
	private Object [][] userInfo = {
			{"���˻�",30,"��",89,97,186,true} ,
			{"�",23,"Ů",90,93,183,false} 
	};

	private JButton addRowBtn = new JButton("������") ;	 // ���尴ť
	private JButton removeRowBtn = new JButton("ɾ����") ;	 // ���尴ť
	private JButton addColBtn = new JButton("������") ;	 // ���尴ť
	private JButton removeColBtn = new JButton("ɾ����") ;	 // ���尴ť

	public ChangeTable(){
		this.tableModel = new DefaultTableModel(this.userInfo,this.titles) ;
		this.table = new JTable(this.tableModel) ;
		
		this.sexList.addItem("��");
		this.sexList.addItem("Ů");
		this.table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(this.sexList));

		JScrollPane scr = new JScrollPane(this.table) ;
		JPanel toolBar = new JPanel() ;

		toolBar.add(this.addRowBtn) ;
		toolBar.add(this.removeRowBtn) ;
		toolBar.add(this.addColBtn) ;
		toolBar.add(this.removeColBtn) ;

		frame.add(toolBar,BorderLayout.NORTH) ;	// �������
		frame.add(scr,BorderLayout.CENTER) ;	// �������
		

		frame.setSize(370,160) ;
		frame.setVisible(true) ;

		frame.addWindowListener(new WindowAdapter(){//��Ӵ��ڹر��¼�
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;

		//Ϊ��ť��Ӽ����¼�
		this.addRowBtn.addActionListener(this) ;
		this.removeRowBtn.addActionListener(this) ;
		this.addColBtn.addActionListener(this) ;
		this.removeColBtn.addActionListener(this) ;


	}
	
	//�������е����ݿ��Ա༭
	public boolean isCellEditable(int rowIndex, int columnIndex){	// �������ݶ����Ա༭
		return true ;
	}

	//��д�������¼��������������������ʱ����
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == this.addColBtn){	// ������
			this.tableModel.addColumn("������") ;
		}
		if(e.getSource() == this.addRowBtn){	//������
			this.tableModel.addRow(new Object[]{}) ;
		}
		if(e.getSource()==this.removeColBtn){	//ɾ����
			int colCount = this.tableModel.getColumnCount() - 1 ;// ȡ���е�����
			if(colCount>=0){
				// ���Ҫ��ɾ����������ҵ�TableColumnModel
				TableColumnModel columMode = this.table.getColumnModel() ;//�õ�ɾ�����е�ģ��
				TableColumn taleColumn = columMode.getColumn(colCount) ;//�õ�Ҫɾ���Ĳ�����
				columMode.removeColumn(taleColumn) ;	// ɾ��ָ������
				this.tableModel.setColumnCount(colCount) ;//�����µ�����
			}
		}
		if(e.getSource()==this.removeRowBtn){	//ɾ����
			int rowCount = this.tableModel.getRowCount() - 1 ;//��ȡ�е�����
			if(rowCount>=0){	// �ж��Ƿ����п���ɾ��
				this.tableModel.removeRow(rowCount) ;//ɾ����
				this.tableModel.setRowCount(rowCount) ;	// �����µ�����
			}
		}
	}
}

/**
 * ��ͨ���
 * @author sunjian
 *
 */
class DefaultTable extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ��������
	private String[] titles = {"����","����","�Ա�","��ѧ�ɼ�","Ӣ��ɼ�","�ܷ�","�Ƿ񼰸�"} ;
	private Object [][] userInfo = {
			{"���˻�",30,"��",89,97,186,true} ,
			{"�",23,"Ů",90,93,183,false} 
		} ;	
	public int getColumnCount(){	// ȡ���е�����
		return this.titles.length ;
	}
	public int getRowCount(){		// ȡ���е�����
		return this.userInfo.length ;
	}
	public Object getValueAt(int rowIndex, int columnIndex){
		return this.userInfo[rowIndex][columnIndex] ;
	}
	public String getColumnName(int columnIndex){
		return this.titles[columnIndex] ;
	}
	public Class<?> getColumnClass(int columnIndex) {	// �õ�ָ���е�����
		return this.getValueAt(0,columnIndex).getClass() ;
	}
	public boolean isCellEditable(int rowIndex, int columnIndex){	// �������ݶ����Ա༭
		return true ;
	}
	public void setValueAt(Object aValue, int rowIndex, int columnIndex){
		this.userInfo[rowIndex][columnIndex] = aValue ;
	}
}

class NormalTableDemo{
	private JFrame frame = new JFrame("Welcome To MLDN") ; 
	private JTable table = null ;
	private DefaultTable defaultTable = new DefaultTable() ;	// TableModel
	private JComboBox<String> sexList = new JComboBox<String>() ;
	public NormalTableDemo(){
		this.table = new JTable(this.defaultTable) ;
		this.sexList.addItem("��") ;
		this.sexList.addItem("Ů") ;
		// �������б�����ʽ��ʾ
		this.table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(this.sexList)) ;
		JScrollPane scr = new JScrollPane(this.table) ;
		JPanel toolBar = new JPanel() ;
		frame.add(toolBar,BorderLayout.NORTH) ;	// �������
		frame.add(scr,BorderLayout.CENTER) ;	// �������
		frame.setSize(370,190) ;
		frame.setVisible(true) ;
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;
	}
}

public class JTableDemo {

	public static void main(String[] args) {

//		new ChangeTable();//��̬�ɸı�ı��
		new NormalTableDemo();//��ͨ���
	}

}
