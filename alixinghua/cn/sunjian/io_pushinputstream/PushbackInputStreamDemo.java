package cn.sunjian.io_pushinputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * java.io��ϰ��������
 * 
 * 		PushbackInputStream��
 * 
 * @author jack
 *
 */
public class PushbackInputStreamDemo {

	public static void main(String[] args) throws IOException {

		String str = "www.mldnjava.cn" ;		// �����ַ���
		
		PushbackInputStream push = null ;		// �������������
		ByteArrayInputStream bai = null ;		// �����ڴ�������
		bai = new ByteArrayInputStream(str.getBytes()) ;	// ʵ�����ڴ�������
		push = new PushbackInputStream(bai) ;	// ���ڴ��ж�ȡ����
		System.out.print("��ȡ֮�������Ϊ��") ;
		int temp = 0 ; 
		while((temp=push.read())!=-1){	// ��ȡ����
			if(temp=='.'){	// �ж��Ƿ��ȡ���ˡ�.��
				push.unread(temp) ;	// �Żص�������֮��
				temp = push.read() ;	// �ٶ�һ��
				System.out.print("���˻�"+(char)temp+"��") ;
			}else{
				System.out.print((char)temp) ;	// �������
			}
		}
	}

}
