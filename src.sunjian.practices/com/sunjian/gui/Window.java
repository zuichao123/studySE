package com.sunjian.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.sunjian.io.InputData;




/**
 * java.io��ͼ�ν��棺������ϰ��
 * 
 * 	��ϰ�����˵���ʾ
 * 
 * 		������
 * 			ʹ��IO�������һ���򵥵Ĳ˵�����������ʾ��
 * 			xxxxϵͳ
 * 			��1����������
 * 			��2��ɾ������
 * 			��3���޸�����
 * 			��4���鿴����
 * 			��0��ϵͳ�˳�
 * 			
 * 			��ѡ��
 * 
 * 			����û�����ı�Ų���ȷ����Ҫ����������ʾ�����ȴ��û�����ѡ��
 * 
 * 		˼·��
 * 			����Ҫ��һ���˵�����ʾ������ʵ����ÿ��ѡ��֮�󶼿϶������Լ������ɸ�������
 * 			����Ϊ�˷���������������¼����ࣺ
 * 			Menu�ࣨר����ʾ�˵���Ϣ��
 * 			Operate����ʾ�����ࣩ�Ժ����书��ʱ��ֱ���޸Ĵ���
 * 
 * 		��ϰ�ܽ᣺
 * 			�ڿ�����һ��Ҫ����ɹ��ܣ�֮���ٿ��������ƣ�
 * 			����������һ���ͻ��ˣ�����Խ��Խ�á�
 * 
 * 
 * 	ʵ��Ҫ��
 * 		��֮ǰ�Ĳ˵�����������䣬Ҫ�����ӵ�ʱ���������һ���˵�������Ϣ���˵���Ϣ�������������䡣����֮��Ҳ�����޸Ĵ���Ϣ��ɾ������Ϣ����ѯ����Ϣ���˴���������ɣ�
 * 		��ʾ��
 * 			ʹ�ö�������л����档
 * 		��ʱ������ʹ��֮ǰ�����ĵļ����ࣺInputData��Person��Operate��Menu��
 * 		��Ҫ�����ļ������࣬ר�Ÿ��𱣴�Ͷ�ȡ�ļ������ݣ��Լ��޸�Operate�࣬Ϊ����������Ĳ�������ʱ����Ĳ������£�
 * 
 * @author sunjian
 *
 */
public class Window extends JFrame {
	
	JFrame mJFrame;
	Container content;
	JPanel mJpanle;
	JScrollPane mJtascrol;
	
	JLabel mJlGreeting;
	JLabel mJlOne;
	JLabel mJlTwo;
	JLabel mJlThree;
	JLabel mJlFour;
	JLabel mJlZero;
	JLabel mJlPleaseChoose;
	
	JTextField mJTextField;
	JTextArea mJTextArea;
	
	JComboBox<Object> mJcbPleaseChoose;
	
	JButton mJbConfirm;
	
	public void run(){
		
		int WIDTH_WINDOW = 1368;
		int HEIGHT_WINDOW = 768;
		int screenWidth = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
		int WINDOW_LOCATION_X = screenWidth / 2 - WIDTH_WINDOW / 2 + 50;
		int WINDOW_LOCATION_Y = screenHeight / 2 - HEIGHT_WINDOW / 2 + 30;
		String[] fontSize = {"   ","0","1","2","3","4"};
		
		this.mJFrame = new JFrame();
		this.content = mJFrame.getContentPane();
		this.mJpanle = new JPanel();	
		
		this.mJlGreeting = new JLabel("==-==XXXϵͳ==-==");
		this.mJlOne = new JLabel("[1]����������",SwingConstants.LEFT);
	    this.mJlTwo = new JLabel("[2]��ɾ������");
	    this.mJlThree = new JLabel("[3]���޸�����");
	    this.mJlFour = new JLabel("[4]���鿴����");
	    this.mJlZero = new JLabel("[0]��ϵͳ�˳�");
	    this.mJTextField = new JTextField("������",10);
	    this.mJlPleaseChoose = new JLabel("��ѡ��");
	    this.mJcbPleaseChoose = new JComboBox<Object>(fontSize);
	    this.mJTextArea = new JTextArea(3,50);
	    this.mJbConfirm = new JButton("ȷ��");
		
//	    this.mJpanle.setLayout(null);
		//������ӵ�λ�á���С��
	    this.mJpanle.setLayout(null);
		//***��ӵ������
		this.mJlGreeting.setSize(30, 30);
		this.mJlGreeting.setLocation(12, 5);
		this.mJlGreeting.setFont(new Font("����", Font.BOLD, 24));
		this.mJlGreeting.setBackground(Color.blue);
		this.mJpanle.add(mJlGreeting);
		
		this.mJlOne.setSize(30, 30);
		this.mJlOne.setLocation(100, 200);
		this.mJlOne.setFont(new Font("����", Font.CENTER_BASELINE, 14));
		this.mJlOne.setBackground(Color.BLACK);
		this.mJpanle.add(mJlOne);
		
		this.mJlTwo.setSize(30, 30);
		this.mJlTwo.setLocation(12,25);
		this.mJlTwo.setFont(new Font("����", Font.BOLD, 24));
		this.mJlTwo.setBackground(Color.blue);
		this.mJpanle.add(mJlTwo);
		
		this.mJlThree.setSize(30, 30);
		this.mJlThree.setLocation(12,35);
		this.mJlThree.setFont(new Font("����", Font.BOLD, 24));
		this.mJlThree.setBackground(Color.blue);
		this.mJpanle.add(mJlThree);
		
		this.mJlFour.setSize(30, 30);
		this.mJlFour.setLocation(12,45);
		this.mJlFour.setFont(new Font("����", Font.BOLD, 24));
		this.mJlFour.setBackground(Color.blue);
		this.mJpanle.add(mJlFour);
		
		this.mJlZero.setSize(30, 30);
		this.mJlZero.setLocation(12,55);
		this.mJlZero.setFont(new Font("����", Font.BOLD, 24));
		this.mJlZero.setBackground(Color.blue);
		this.mJpanle.add(mJlZero);
		
		this.mJlPleaseChoose.setSize(30, 30);
		this.mJlPleaseChoose.setLocation(12,65);
		this.mJlPleaseChoose.setFont(new Font("����", Font.BOLD, 24));
		this.mJlPleaseChoose.setBackground(Color.blue);
		this.mJpanle.add(mJlPleaseChoose);
		
		this.mJTextField.setSize(30, 30);
		this.mJTextField.setLocation(12,75);
		this.mJTextField.setFont(new Font("����", Font.BOLD, 24));
		this.mJTextField.setForeground(Color.lightGray);
		this.mJTextField.setBackground(Color.white);
		this.mJTextField.setEnabled(true);
		//this.mJpanle.add(mJTextField);	
		
		this.mJcbPleaseChoose.setSize(30, 30);
		this.mJcbPleaseChoose.setLocation(12,65);
		this.mJcbPleaseChoose.setFont(new Font("����", Font.BOLD, 24));
		this.mJcbPleaseChoose.setBackground(Color.white);
		this.mJcbPleaseChoose.setMaximumRowCount(3);
		this.mJtascrol = new JScrollPane(mJcbPleaseChoose);
		this.mJpanle.add(mJtascrol);

		this.mJTextArea.setSize(50, 50);
		this.mJTextArea.setLocation(12,85);
		this.mJTextArea.setFont(new Font("����", Font.BOLD, 14));
		this.mJTextArea.setBackground(Color.white);
		this.mJTextArea.setEnabled(true);
		this.mJTextArea.setLineWrap(true);
		this.mJtascrol = new JScrollPane(mJTextArea);//���ö����ı��Ĺ�����
		this.mJpanle.add(mJtascrol);
		
		
		this.mJbConfirm.setSize(30,30);
		this.mJbConfirm.setLocation(100, 100);
		this.mJbConfirm.setFont(new Font("����", Font.HANGING_BASELINE, 26));
		this.mJpanle.add(mJbConfirm);
		
		
		this.content.add(mJpanle);//�������ӵ�������
		
		//���ô���
//		this.mJpanle.setLayout(null);
//		this.mJFrame.setLayout(null);
		this.mJFrame.setLocation(WINDOW_LOCATION_X,WINDOW_LOCATION_Y);
		this.mJFrame.setSize(1050,800);
//		this.mJFrame.setResizable(true);
		this.mJFrame.setVisible(true);
//		this.mJFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.mJFrame.setTitle("xxxxϵͳ");	
			
		
		
		this.mJTextField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (mJTextField.getText().equals("������")) {
					mJTextField.setText("");
				}
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String mJcbContent = mJcbPleaseChoose.getSelectedItem().toString();
				
				if (e.getSource() == mJbConfirm) {
					
//					mJTextArea.setText("");
					
					if (mJcbContent.equals("1")) {
//						System.out.println("111111111");
						mJTextArea.append("������������\n");
						
//						System.out.println("111111112");
						InputData input = new InputData();//ʵ�����������ݶ���
//						System.out.println("111111113");
						mJTextArea.requestFocus();
						String name = input.getString1();
//						System.out.println("111111114");
						mJTextArea.setText("���������䣺 ������������֣�\n");
//						System.out.println("111111115");
//						int age = input.getInt1();
//						System.out.println("111111116");
						
//						Person per = new Person(name, age);//ʵ����Person��
						
//						mJTextArea.setText(per.toString());
						
						JOptionPane.showMessageDialog(mJpanle, "��ӳɹ�");
						
						mJTextArea.append("��ӳɹ�\n");
						mJTextArea.append("��ӳɹ�\n");
						mJTextArea.append("��ӳɹ�\n");
						mJTextArea.append("��ӳɹ�\n");
						mJTextArea.append("��ӳɹ�");
					}
					if (mJcbContent.equals("2")) {
						mJTextArea.setText("");
//						Operate.delete();//����ɾ������
						mJTextArea.setText("ɾ���ɹ�");
					}
					if (mJcbContent.equals("3")) {
						mJTextArea.setText("");
						Operate.update();//���ø��²���
						mJTextArea.setText("���³ɹ�");
					}
					if (mJcbContent.equals("4")) {
						mJTextArea.setText("");
						Operate.find();//���ò鿴����
						mJTextArea.setText("�鿴�ɹ�");
					}
					if (mJcbContent.equals("0")) {
						mJTextArea.setText("�ݰ�");
						System.exit(1);//ϵͳ�˳�
						mJTextArea.setText("");
					}else {
						if (mJcbContent.equals("")) {
							mJTextArea.setText("��ѡ��...");
						}
					}
				}	
			}
		});
		
		this.mJFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
		
	}

}
