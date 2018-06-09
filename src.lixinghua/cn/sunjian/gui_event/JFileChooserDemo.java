package cn.sunjian.gui_event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			�ļ�ѡ���JFileChooser��
 * 				ʵ��ѡ���ļ������ݲ���ѡ������ʾ�ļ����ݡ�д���ļ����ݵȲ�����
 * 				
 * @author sunjian
 *
 */
class Note implements ActionListener{
	private JTextArea area = new JTextArea(8,10) ;	// �����ı���
	private JFrame frame = new JFrame("Welcome To MLDN") ;
	private JButton open = new JButton("���ļ�") ;
	private JButton save = new JButton("�����ļ�") ;
	private JLabel label = new JLabel("����û�д򿪵��ļ�") ;
	private JPanel butPan = new JPanel() ;//�����������

	public Note(){
		this.butPan.add(open) ;	// ������м��밴ť
		this.butPan.add(save) ;	// ������м��밴ť

		this.frame.setLayout(new BorderLayout(3,3)) ;//���ô��岼��

		this.frame.add(this.label,BorderLayout.NORTH) ;//�ڴ����м����ǩ�����ֵ�����
		this.frame.add(this.butPan,BorderLayout.SOUTH) ;//�ڴ����м�����壬���ֵ��ϱ�
		this.frame.add(new JScrollPane(this.area),BorderLayout.CENTER) ;//�ڴ����м�������������ı���������
		
		this.frame.setSize(330,180) ;
		this.frame.setVisible(true) ;

		//�ٴ�������ӹر��¼�
		this.frame.addWindowListener(
			new WindowAdapter()	{
				public void windowClosing(WindowEvent e){
					System.exit(1) ;
				}
			}
		) ;

		this.open.addActionListener(this) ;//�ڴ򿪰�ť����Ӽ����¼�
		this.save.addActionListener(this) ;//�ڱ��水ť����Ӽ����¼�
	}

	//��д������������������ʱ������
	public void actionPerformed(ActionEvent e){
		File file = null ;	// �����ļ�
		int result = 0 ;	// ���ղ���״̬

		JFileChooser fileChooser = new JFileChooser() ;	// �����ļ�ѡ���

		if(e.getSource()==this.open){	// ��ʾִ�е��Ǵ򿪲���
			this.area.setText("") ;	// ��ʱ������������������

			fileChooser.setApproveButtonText("ȷ��") ;//���ý��ܵİ�ť����

			fileChooser.setDialogTitle("���ļ�") ;//���ñ���

			result = fileChooser.showOpenDialog(this.frame) ;//��ȡ����״̬
			
			if(result==JFileChooser.APPROVE_OPTION){	// ѡ�����ȷ����ť
				file = fileChooser.getSelectedFile() ;	// �õ�ѡ����ļ�
				this.label.setText("�򿪵��ļ�����Ϊ��" + file.getName()) ;
			}else if(result==JFileChooser.CANCEL_OPTION){
				this.label.setText("û��ѡ���κ��ļ�") ;
			}else{
				this.label.setText("�������ִ���") ;
			}
			if(file!=null){
				try{
					Scanner scan = new Scanner(new FileInputStream(file)) ;
					scan.useDelimiter("\n") ;
					while(scan.hasNext()){
						this.area.append(scan.next()) ;
						this.area.append("\n") ;
					}
					scan.close() ;
				}catch(Exception e1){
					this.label.setText("�ļ���ȡʧ��...");
					System.err.println(e1);
				}
			}
		}
		if(e.getSource()==this.save){	// �ж��Ƿ��Ǳ������

			result = fileChooser.showSaveDialog(this.frame) ;	// ��ʾ����򣬲���ȡ����״̬

			if(result==JFileChooser.APPROVE_OPTION){	// ѡ�����ȷ����ť
				file = fileChooser.getSelectedFile() ;	// �õ�ѡ����ļ�
				this.label.setText("ѡ��Ĵ洢�ļ�����Ϊ��" + file.getName()) ;
			}else if(result==JFileChooser.CANCEL_OPTION){
				this.label.setText("û��ѡ���κ��ļ�") ;
			}else{
				this.label.setText("�������ִ���") ;
			}
			if(file!=null){
				try{
					PrintStream out = new PrintStream(new FileOutputStream(file)) ;
					out.print(this.area.getText()) ;//������е��ı����ݵ��ı�������						
					out.close() ;
				}catch(Exception e1){
					this.label.setText("�ļ�����ʧ�ܣ�");
					System.err.println(e1);
				}
			}
		}
	}
}

public class JFileChooserDemo{
	public static void main(String args[]){
		new Note() ;
	}
}