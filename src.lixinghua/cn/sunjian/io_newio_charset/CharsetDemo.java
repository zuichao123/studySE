package cn.sunjian.io_newio_charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

/**
 * java��io��Charset�ַ�������
 * 
 *		 �õ�ȫ���Ŀ����ַ�����
 *			��ɱ���ͽ��������
 * 
 * @author jack
 *
 */
public class CharsetDemo {

	public static void main(String[] args) {

		getAllCharset();//�õ����еĿ����ַ����������
		charsetEncoderDecoder();//����ͽ���
	}

	private static void charsetEncoderDecoder() {

		Charset latin1 = Charset.forName("ISO-8859-1");//ֻ�ܱ�ʾӢ���ַ���������GBK��
		CharsetEncoder encoder = latin1.newEncoder();//�õ�������
		CharsetDecoder decoder = latin1.newDecoder();//�õ�������
		
		CharBuffer cb = CharBuffer.wrap("sunjian");//ͨ��CharBuffer���е�warp()����ʵ����
		
		try {
			ByteBuffer buffer = encoder.encode(cb);//���б������
			CharBuffer str = decoder.decode(buffer);//���н������
			
			System.out.println(str);//����������ַ�
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}
		
	}

	private static void getAllCharset() {
		SortedMap<String , Charset> all = null;
		all = Charset.availableCharsets();//�õ�ȫ���Ŀ����ַ���
		
		Iterator<Map.Entry<String, Charset>> iter = null;
		iter = all.entrySet().iterator();
		
		while(iter.hasNext()){
			Map.Entry<String, Charset> me = iter.next();
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
	}

}
