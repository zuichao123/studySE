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
 * 图形界面：
 * 
 * 		事件监听:
 * 			表格；
 * 				实现普通表格；
 * 				实现动态的表格；
 * 				
 * @author sunjian
 *
 */

/**
 * 动态表格
 * @author sunjian
 *
 */
class ChangeTable implements ActionListener{	// 通过按钮实现动态表格
	private JFrame frame = new JFrame("Welcome To MLDN") ; 
	private JTable table = null ;	//表格
	private DefaultTableModel tableModel ;	// TableModel
	private JComboBox<String> sexList = new JComboBox<String>();//下拉选择框
	
	// 定义数据
	private String[] titles = {"姓名","年龄","性别","数学成绩","英语成绩","总分","是否及格"} ;
	private Object [][] userInfo = {
			{"李兴华",30,"男",89,97,186,true} ,
			{"李康",23,"女",90,93,183,false} 
	};

	private JButton addRowBtn = new JButton("增加行") ;	 // 定义按钮
	private JButton removeRowBtn = new JButton("删除行") ;	 // 定义按钮
	private JButton addColBtn = new JButton("增加列") ;	 // 定义按钮
	private JButton removeColBtn = new JButton("删除列") ;	 // 定义按钮

	public ChangeTable(){
		this.tableModel = new DefaultTableModel(this.userInfo,this.titles) ;
		this.table = new JTable(this.tableModel) ;
		
		this.sexList.addItem("男");
		this.sexList.addItem("女");
		this.table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(this.sexList));

		JScrollPane scr = new JScrollPane(this.table) ;
		JPanel toolBar = new JPanel() ;

		toolBar.add(this.addRowBtn) ;
		toolBar.add(this.removeRowBtn) ;
		toolBar.add(this.addColBtn) ;
		toolBar.add(this.removeColBtn) ;

		frame.add(toolBar,BorderLayout.NORTH) ;	// 加入组件
		frame.add(scr,BorderLayout.CENTER) ;	// 加入组件
		

		frame.setSize(370,160) ;
		frame.setVisible(true) ;

		frame.addWindowListener(new WindowAdapter(){//添加窗口关闭事件
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;

		//为按钮添加监听事件
		this.addRowBtn.addActionListener(this) ;
		this.removeRowBtn.addActionListener(this) ;
		this.addColBtn.addActionListener(this) ;
		this.removeColBtn.addActionListener(this) ;


	}
	
	//设置所有的内容可以编辑
	public boolean isCellEditable(int rowIndex, int columnIndex){	// 所有内容都可以编辑
		return true ;
	}

	//覆写方法（事件监听），监听组件操作时调用
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == this.addColBtn){	// 增加列
			this.tableModel.addColumn("新增列") ;
		}
		if(e.getSource() == this.addRowBtn){	//增加行
			this.tableModel.addRow(new Object[]{}) ;
		}
		if(e.getSource()==this.removeColBtn){	//删除列
			int colCount = this.tableModel.getColumnCount() - 1 ;// 取得列的数量
			if(colCount>=0){
				// 如果要想删除，则必须找到TableColumnModel
				TableColumnModel columMode = this.table.getColumnModel() ;//得到删除的列的模型
				TableColumn taleColumn = columMode.getColumn(colCount) ;//得到要删除的操作列
				columMode.removeColumn(taleColumn) ;	// 删除指定的列
				this.tableModel.setColumnCount(colCount) ;//设置新的列数
			}
		}
		if(e.getSource()==this.removeRowBtn){	//删除行
			int rowCount = this.tableModel.getRowCount() - 1 ;//获取行的数量
			if(rowCount>=0){	// 判断是否还有行可以删除
				this.tableModel.removeRow(rowCount) ;//删除行
				this.tableModel.setRowCount(rowCount) ;	// 设置新的行数
			}
		}
	}
}

/**
 * 普通表格
 * @author sunjian
 *
 */
class DefaultTable extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 定义数据
	private String[] titles = {"姓名","年龄","性别","数学成绩","英语成绩","总分","是否及格"} ;
	private Object [][] userInfo = {
			{"李兴华",30,"男",89,97,186,true} ,
			{"李康",23,"女",90,93,183,false} 
		} ;	
	public int getColumnCount(){	// 取得列的数量
		return this.titles.length ;
	}
	public int getRowCount(){		// 取得行的数量
		return this.userInfo.length ;
	}
	public Object getValueAt(int rowIndex, int columnIndex){
		return this.userInfo[rowIndex][columnIndex] ;
	}
	public String getColumnName(int columnIndex){
		return this.titles[columnIndex] ;
	}
	public Class<?> getColumnClass(int columnIndex) {	// 得到指定列的类型
		return this.getValueAt(0,columnIndex).getClass() ;
	}
	public boolean isCellEditable(int rowIndex, int columnIndex){	// 所有内容都可以编辑
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
		this.sexList.addItem("男") ;
		this.sexList.addItem("女") ;
		// 以下拉列表框的形式显示
		this.table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(this.sexList)) ;
		JScrollPane scr = new JScrollPane(this.table) ;
		JPanel toolBar = new JPanel() ;
		frame.add(toolBar,BorderLayout.NORTH) ;	// 加入组件
		frame.add(scr,BorderLayout.CENTER) ;	// 加入组件
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

//		new ChangeTable();//动态可改变的表格
		new NormalTableDemo();//普通表格
	}

}
