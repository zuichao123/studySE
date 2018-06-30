package com.sunjian.gui_personmanagegui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MyWindowDelete extends MyWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String  userManagerPath = System.getProperty("user.dir")+"/files/lixinghua/file/userManager.txt";
	
	JPanel superMJpanelAdd;
	
	public MyWindowDelete(JPanel mJpanelAdd){
		this.superMJpanelAdd = mJpanelAdd;
	}
	
	public void delete(){
		FileOperate fo = new FileOperate(userManagerPath);
		boolean flag = false;
		try{
			flag = fo.delete();
		}catch(Exception e){
			e.printStackTrace();
		}
		if (flag) {			
			JOptionPane.showMessageDialog(superMJpanelAdd, "删除成功！");
		}else {
			JOptionPane.showMessageDialog(superMJpanelAdd, "删除失败！\n文件被占用或者不存在！");
		}
	}
	
	
	
	public static void main(String[] args) {

	}

	
}
