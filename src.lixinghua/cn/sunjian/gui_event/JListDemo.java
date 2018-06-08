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
 * 图形界面：
 * 
 * 		事件监听:
 * 			列表框JList；
 * 				使用ListModel构建列表框：
 *				继承AbstractListModel只需覆写我需要的方法，不用全部覆写所有方法；
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
	private String nations[] = {"中国","巴西","美国","韩国","意大利","法国"} ;

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
	private JFrame frame = new JFrame("JListDemo") ;	//定义窗体
	private Container cont = frame.getContentPane() ;	// 得到窗体容器
	private JList<?> list1 = null ;//定义多选列表框
	private JList<?> list2 = null ;//定义单选列表框

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MyList(){
		this.frame.setLayout(new GridLayout(1,3)) ;	// 定义排版
		
		String nations2[] = {"MLDN","MLDNJAVA","智囊团","百度","雅虎","腾讯"} ;
		Vector<String> v = new Vector<String>() ;
		for(int i=0;i<nations2.length;i++){
			v.add(nations2[i]);//在单选列表框中添加内容
		}
		
		this.list1 = new JList(new MyListModel()) ;//实例化多选列表框
		this.list2 = new JList<String>(v);//实例化单选列表框

		this.list1.setBorder(BorderFactory.createTitledBorder("你喜欢去那个国家旅游？")) ;
		this.list2.setBorder(BorderFactory.createTitledBorder("你喜欢哪个网站"));

		this.list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) ;// 多选列表框
		this.list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选列表框

		this.cont.add(new JScrollPane(this.list1)) ;//在列表中加入滚动条，并将列表框添加到窗体容器
		this.cont.add(new JScrollPane(this.list2)) ;//在列表中加入滚动条，并将列表框添加到窗体容器

		this.frame.setSize(330,130) ;//设置窗体大小
		this.frame.setLocationRelativeTo(null);//设置窗体显示在屏幕中间
		this.frame.setVisible(true) ;//设置窗体可见

		this.list1.addListSelectionListener(this) ;//在列表框中增加事件

		//添加窗体关闭时间
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent a){
				System.exit(1) ;
			}
		}) ;
	}

	//覆写方法（以使用ListSelectionListener的监听接口实现对JList中的所选项进行监听；当值发生改变时调用）
	public void valueChanged(ListSelectionEvent e){	// 事件处理
		
		int temp[] = list1.getSelectedIndices() ;//得到全部索引
		
		System.out.print("选定的内容：") ;
		for(int i=0;i<temp.length;i++){
			System.out.print(list1.getModel().getElementAt(i) + "、") ;//根据索引取得多选列表框中全部的值
		}
		System.out.println() ;
	}

}

public class JListDemo{
	public static void main(String args[]){
		new MyList() ;
	}
}