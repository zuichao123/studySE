package com.sunjian.gui_personmanagegui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyWindowSelect extends MyWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String  userManagerPath = System.getProperty("user.dir")+"/files/lixinghua/file/userManager.txt";
	
	JPanel superMJpanel;
	JTextArea superMJtextArea;
	
	public MyWindowSelect(JPanel mJPanel,JTextArea mJTextArea){
		this.superMJpanel = mJPanel;
		this.superMJtextArea = mJTextArea;
	}
	
	public void look(){
		FileOperate fo = new FileOperate(userManagerPath);
		Person per = null;
		
		try {			
			per = (Person) fo.load();
			if (per != null) {								
					superMJtextArea.setText(per.toString());				
			}else {
				JOptionPane.showMessageDialog(superMJpanel, "暂无用户，请先添加！");
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void look1(){
		FileOperate fo = new FileOperate(userManagerPath);
		Person[] per = null;
		
		try {			
			per = (Person[]) fo.load();
			if (per != null) {
				for(Person p:per){					
					superMJtextArea.setText(p.toString());
				}
			}else {
				JOptionPane.showMessageDialog(superMJpanel, "暂无用户，请先添加！");
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
