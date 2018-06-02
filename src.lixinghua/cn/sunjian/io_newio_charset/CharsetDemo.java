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
 * java新io：Charset字符集操作
 * 
 *		 得到全部的可用字符集；
 *			完成编码和解码操作；
 * 
 * @author jack
 *
 */
public class CharsetDemo {

	public static void main(String[] args) {

		getAllCharset();//得到所有的可用字符集，并输出
		charsetEncoderDecoder();//编码和解码
	}

	private static void charsetEncoderDecoder() {

		Charset latin1 = Charset.forName("ISO-8859-1");//只能表示英文字符（中文用GBK）
		CharsetEncoder encoder = latin1.newEncoder();//得到编码器
		CharsetDecoder decoder = latin1.newDecoder();//得到解码器
		
		CharBuffer cb = CharBuffer.wrap("sunjian");//通过CharBuffer类中的warp()方法实例化
		
		try {
			ByteBuffer buffer = encoder.encode(cb);//进行编码操作
			CharBuffer str = decoder.decode(buffer);//进行解码操作
			
			System.out.println(str);//输出解码后的字符
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}
		
	}

	private static void getAllCharset() {
		SortedMap<String , Charset> all = null;
		all = Charset.availableCharsets();//得到全部的可用字符集
		
		Iterator<Map.Entry<String, Charset>> iter = null;
		iter = all.entrySet().iterator();
		
		while(iter.hasNext()){
			Map.Entry<String, Charset> me = iter.next();
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
	}

}
