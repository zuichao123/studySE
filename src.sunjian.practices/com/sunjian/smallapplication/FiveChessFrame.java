package com.sunjian.smallapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
public class FiveChessFrame extends JFrame implements MouseListener, Runnable {
        private static final long serialVersionUID = 1L;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int hight = Toolkit.getDefaultToolkit().getScreenSize().height;
        // ����ͼƬ
        BufferedImage bjImage = null;
        // ������������
        int x = 0;
        int y = 0;
        // ����֮ǰ�¹�����������
        // �������ݣ�0:��ʾ�����û������ 1����ʾ���� 2����ʾ����
        int[][] allChess = new int[19][19];
        // ��ʶ��ǰ�Ǻ��廹�ǰ�������һ��
        boolean isBlack = true;
        // ��ʶ��ǰ��Ϸ�Ƿ���Լ���
        boolean canPlay = true;
        // ������ʾ����ʾ��Ϣ
        String message = "�ڷ�����";
        // �������ӵ�ж���ʱ��(��)
        int maxTime = 0;
        // ������ʱ���߳���
        Thread t = new Thread(this);
        // ����ڷ���׷���ʣ��ʱ��
        int blackTime = 0;
        int whiteTime = 0;
        // ����˫��ʣ��ʱ�����ʾ��Ϣ
        String blackMessage = "������";
        String whiteMessage = "������";
 
        @SuppressWarnings("deprecation")
        public FiveChessFrame() {
                this.setTitle("������");
                this.setSize(500, 500);
                this.setLocation((width - 500) / 2, (hight - 500) / 2);
                this.addMouseListener(this);
                // this.setResizable(false);
                this.setVisible(true);
 
                t.start();
                t.suspend();// �̹߳���
 
                // �մ򿪵�ʱ��ˢ����Ļ,��ֹ��ʼ��Ϸʱ�޷���ʾ������
                this.repaint();
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                try {
                        bjImage = ImageIO.read(new File("tools/background.jpg"));
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
 
        @Override
        public void paint(Graphics g) {
                // ˫���漼�� ��ֹ��Ļ��˸ ����֪��Ϊʲô��ʹ��˫���漼���Ժ�Ч���ز��ã�����û�ã����ʹ�õĻ�������� g ��Ϊ g2 �Ϳ�����
                // BufferedImage bi=new
                // BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);
                // Graphics g2=bi.createGraphics();
 
                g.drawImage(bjImage, 0, 20, this);
                g.setFont(new Font("����", Font.BOLD, 20));
                g.drawString("��Ϸ��Ϣ��" + message, 120, 60);
                g.setFont(new Font("����", 0, 14));
                g.drawString("�ڷ�ʱ�䣺" + blackMessage, 30, 470);
                g.drawString("�׷�ʱ�䣺" + whiteMessage, 260, 470);
 
                // ��������
                for (int i = 0; i < 19; i++) {
                        g.drawLine(10, 70 + 20 * i, 370, 70 + 20 * i);
                        g.drawLine(10 + 20 * i, 70, 10 + 20 * i, 430);
                }
                // ��עСԲ��λ
                g.fillOval(68, 128, 4, 4);
                g.fillOval(308, 128, 4, 4);
                g.fillOval(308, 368, 4, 4);
                g.fillOval(68, 368, 4, 4);
                g.fillOval(188, 128, 4, 4);
                g.fillOval(68, 248, 4, 4);
                g.fillOval(188, 368, 4, 4);
                g.fillOval(188, 248, 4, 4);
                g.fillOval(308, 248, 4, 4);
 
                // //��������
                // x=(x-10)/20*20+10; //��Ϊ��ȡ�ý���������
                // y=(y-70)/20*20+70;
                // //����
                // g.fillOval(x-7, y-7, 14, 14);
                // //����
                // g.setColor(Color.BLACK);
                // g.fillOval(x-7, y-7, 14, 14);
                // g.setColor(Color.BLACK);
                // g.drawOval(x-7, y-7, 14, 14);
 
                // ���������������ֵ
                // ����ȫ������
                for (int i = 0; i < 19; i++) {
                        for (int j = 0; j < 19; j++) {
                                if (allChess[i][j] == 1) {
                                        // ����
                                        int tempX = i * 20 + 10;
                                        int tempY = j * 20 + 70;
                                        g.fillOval(tempX - 7, tempY - 7, 14, 14);
                                }
                                if (allChess[i][j] == 2) {
                                        // ����
                                        int tempX = i * 20 + 10;
                                        int tempY = j * 20 + 70;
                                        g.setColor(Color.WHITE);
                                        g.fillOval(tempX - 7, tempY - 7, 14, 14);
                                        g.setColor(Color.BLACK);
                                        g.drawOval(tempX - 7, tempY - 7, 14, 14);
                                }
                        }
 
                }
        }
 
        @Override
        public void mouseClicked(MouseEvent e) {
        }
 
        private boolean checkWin() {
                boolean flag = false;
                // ���湲�ж�����ͬ��ɫ��������
                int count = 1;
                // �жϺ��� �ص㣺allChess[x][y]��yֵ��ͬ
                int color = allChess[x][y];
                // �жϺ���
                count = this.checkCount(1, 0, color);
                if (count >= 5) {
                        flag = true;
                } else {
                        // �ж�����
                        count = this.checkCount(0, 1, color);
                        if (count >= 5) {
                                flag = true;
                        } else {
                                // �ж���������
                                count = this.checkCount(1, -1, color);
                                if (count >= 5) {
                                        flag = true;
                                } else {
                                        // �ж���������
                                        count = this.checkCount(1, 1, color);
                                        if (count >= 5) {
                                                flag = true;
                                        }
                                }
                        }
                }
                return flag;
        }
 
        // �ж�������������
        private int checkCount(int xChange, int yChange, int color) {
                int count = 1;
                int tempX = xChange;
                int tempY = yChange;
                while (x + xChange >= 0 && x + xChange <= 18 && y + yChange >= 0
                                && y + yChange <= 18
                                && color == allChess[x + xChange][y + yChange]) {
                        count++;
                        if (xChange != 0) {
                                xChange++;
                        }
                        if (yChange != 0) {
                                if (yChange > 0) {
                                        yChange++;
                                } else {
                                        yChange--;
                                }
                        }
                }
                xChange = tempX;
                yChange = tempY;
                while (x - xChange >= 0 && x - xChange <= 18 && y - yChange >= 0
                                && y - yChange <= 18
                                && color == allChess[x - xChange][y - yChange]) {
                        count++;
                        if (xChange != 0) {
                                xChange++;
                        }
                        if (yChange != 0) {
                                if (yChange > 0) {
                                        yChange++;
                                } else {
                                        yChange--;
                                }
                        }
                }
                return count;
        }
 
        @Override
        public void mouseEntered(MouseEvent arg0) {
        }
 
        @Override
        public void mouseExited(MouseEvent arg0) {
        }
 
        @SuppressWarnings("deprecation")
        @Override
        public void mousePressed(MouseEvent e) {
                if (canPlay == true) {
                        x = e.getX();
                        y = e.getY();
                        if (x >= 10 && x <= 370 && y >= 70 && y <= 430) {
                                // System.out.println("�����̷�Χ�ڣ�"+x+"--"+y);
                                x = (x - 10) / 20; // ��Ϊ��ȡ�ý���������
                                y = (y - 70) / 20;
                                if (allChess[x][y] == 0) {
                                        // �жϵ�ǰҪ�µ���ʲô����
                                        if (isBlack == true) {
                                                allChess[x][y] = 1;
                                                isBlack = false;
                                                message = "�ֵ��׷�";
                                        } else {
                                                allChess[x][y] = 2;
                                                isBlack = true;
                                                message = "�ֵ��ڷ�";
                                        }
                                        // �ж���������Ƿ��������������5��
                                        boolean winFlag = this.checkWin();
                                        if (winFlag == true) {
                                                JOptionPane.showMessageDialog(this, "��Ϸ����,"
                                                                + (allChess[x][y] == 1 ? "�ڷ�" : "�׷�") + "��ʤ!");
                                                canPlay = false;
                                        }
                                } else {
                                        JOptionPane.showMessageDialog(this, "��ǰλ���Ѿ������ӣ����������ӣ�����");
                                }
 
                                this.repaint();
                        }
                }
                // ��� ��ʼ��Ϸ ��ť
                if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 70
                                && e.getY() <= 100) {
                        int result = JOptionPane.showConfirmDialog(this, "�Ƿ����¿�ʼ��Ϸ��");
                        if (result == 0) {
                                // �������¿�ʼ��Ϸ
                                // ���¿�ʼ��Ҫ���Ĳ�����1)���������,allChess������ȫ�����ݹ�0��
                                // 2)��Ϸ�����Ϣ��ʾ��ʼ��
                                // 3)����һ�������Ϊ�ڷ�
                                for (int i = 0; i < 19; i++) {
                                        for (int j = 0; j < 19; j++) {
                                                allChess[i][j] = 0;
                                        }
                                }
                                // ��һ�ַ�ʽ allChess=new int[19][19]
                                message = "�ڷ�����";
 
                                isBlack = true;
                                blackTime = maxTime;
                                whiteTime = maxTime;
                                if (maxTime > 0) {
                                        blackMessage = maxTime / 3600 + ":"
                                                        + (maxTime / 60 - maxTime / 3600 * 60) + ":"
                                                        + (maxTime - maxTime / 60 * 60);
                                        whiteMessage = maxTime / 3600 + ":"
                                                        + (maxTime / 60 - maxTime / 3600 * 60) + ":"
                                                        + (maxTime - maxTime / 60 * 60);
                                        t.resume();
                                } else {
                                        blackMessage = "������";
                                        whiteMessage = "������";
                                }
                                this.repaint();// ��������µ��ã�����治��ˢ��
 
                        }
 
                }// ��� ��Ϸ���� ��ť
                if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 120
                                && e.getY() <= 150) {
                        String input = JOptionPane
                                        .showInputDialog("��������Ϸ�����ʱ��(��λ������)���������0 ����ʾû��ʱ������");
                        try {
                                maxTime = Integer.parseInt(input) * 60;
                                if (maxTime < 0) {
                                        JOptionPane.showMessageDialog(this, "����ȷ��ʾ��Ϣ�����������븺��");
                                }
                                if (maxTime == 0) {
                                        int result = JOptionPane.showConfirmDialog(this,
                                                        "������ɣ��Ƿ����¿�ʼ��Ϸ��");
                                        if (result == 0) {
                                                // �������¿�ʼ��Ϸ
                                                // ���¿�ʼ��Ҫ���Ĳ�����1)���������,allChess������ȫ�����ݹ�0��
                                                // 2)��Ϸ�����Ϣ��ʾ��ʼ��
                                                // 3)����һ�������Ϊ�ڷ�
                                                for (int i = 0; i < 19; i++) {
                                                        for (int j = 0; j < 19; j++) {
                                                                allChess[i][j] = 0;
                                                        }
                                                }
                                                // ��һ�ַ�ʽ allChess=new int[19][19]
                                                message = "�ڷ�����";
 
                                                isBlack = true;
                                                blackTime = maxTime;
                                                whiteTime = maxTime;
                                                blackMessage = "������";
                                                whiteMessage = "������";
                                                this.repaint();// ��������µ��ã�����治��ˢ��
 
                                        }
                                }
                                if (maxTime > 0) {
                                        int result = JOptionPane.showConfirmDialog(this,
                                                        "������ɣ��Ƿ����¿�ʼ��Ϸ��");
                                        if (result == 0) {
                                                // �������¿�ʼ��Ϸ
                                                // ���¿�ʼ��Ҫ���Ĳ�����1)���������,allChess������ȫ�����ݹ�0��
                                                // 2)��Ϸ�����Ϣ��ʾ��ʼ��
                                                // 3)����һ�������Ϊ�ڷ�
                                                for (int i = 0; i < 19; i++) {
                                                        for (int j = 0; j < 19; j++) {
                                                                allChess[i][j] = 0;
                                                        }
                                                }
                                                // ��һ�ַ�ʽ allChess=new int[19][19]
                                                message = "�ڷ�����";
 
                                                isBlack = true;
                                                blackTime = maxTime;
                                                whiteTime = maxTime;
                                                blackMessage = maxTime / 3600 + ":"
                                                                + (maxTime / 60 - maxTime / 3600 * 60) + ":"
                                                                + (maxTime - maxTime / 60 * 60);
                                                whiteMessage = maxTime / 3600 + ":"
                                                                + (maxTime / 60 - maxTime / 3600 * 60) + ":"
                                                                + (maxTime - maxTime / 60 * 60);
                                                t.resume();
                                                this.repaint();// ��������µ��ã�����治��ˢ��
 
                                        }
                                }
                        } catch (NumberFormatException e1) {
                                JOptionPane.showMessageDialog(this, "����ȷ��ʾ��Ϣ");
                        }
                }// ��� ��Ϸ˵�� ��ť
                if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 170
                                && e.getY() <= 200) {
                        JOptionPane.showMessageDialog(this,
                                        "����һ����������Ϸ���򣬺ڰ�˫���������壬��ĳһ����������ʱ����Ϸ������");
                }// ��� ���� ��ť
                if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 270
                                && e.getY() <= 300) {
                        int result = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ�����䣿");
                        if (result == 0) {
                                if (isBlack) {
                                        JOptionPane.showMessageDialog(this, "�ڷ����Ѿ����䣬��Ϸ����!!!");
                                } else {
                                        JOptionPane.showMessageDialog(this, "�׷����Ѿ����䣬��Ϸ����!!!");
                                }
                                canPlay = false;
                        }
                }// ��� ���� ��ť
                if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 320
                                && e.getY() <= 350) {
                        JOptionPane.showMessageDialog(this,
                                        "����Ϸ�ɲ��񰢽���������������⣬������ϵ����QQ��474280917��");
                }// ��� �˳� ��ť
                if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 370
                                && e.getY() <= 400) {
                        JOptionPane.showMessageDialog(this, "��Ϸ�˳�");
                        System.exit(0);
                }
        }
 
        @Override
        public void mouseReleased(MouseEvent arg0) {
 
        }
 
        @Override
        public void run() {
                // �ж��Ƿ���ʱ������
                if (maxTime > 0) {
                        while (true) {
                                if (isBlack) {
                                        blackTime--;
                                        if (blackTime == 0) {
                                                JOptionPane.showMessageDialog(this, "�ڷ���ʱ����Ϸ����!");
                                        }
                                } else {
                                        whiteTime--;
                                        if (whiteTime == 0) {
                                                JOptionPane.showMessageDialog(this, "�׷���ʱ����Ϸ����!");
                                        }
                                }
                                blackMessage = blackTime / 3600 + ":"
                                                + (blackTime / 60 - blackTime / 3600 * 60) + ":"
                                                + (blackTime - blackTime / 60 * 60);
                                whiteMessage = whiteTime / 3600 + ":"
                                                + (whiteTime / 60 - whiteTime / 3600 * 60) + ":"
                                                + (whiteTime - whiteTime / 60 * 60);
                                this.repaint();
                                try {
                                        Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }
 
                        }
                }
        }
 
        public static void main(String[] args) {
                @SuppressWarnings("unused")
                FiveChessFrame mf = new FiveChessFrame();
        }
 
}
