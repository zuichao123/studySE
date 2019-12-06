package cn.sunjian.generic_define;

/**
 * ���ͽӿڣ������Ͷ����ڽӿ���
 * 
 * @author sunjian
 *
 */
public class GenericDefineDemo3 {

	public static void main(String[] args) {
		
		InterImp im = new InterImp();
		im.show("abc");
		
		InterImp1<String> imp1 = new InterImp1<String>();
		imp1.show("mab");
		InterImp2<Boolean> imp2 = new InterImp2<Boolean>();
		imp2.show(true);
	}

}


interface Inter<T>{
	public void show(T t);
}

//ʵ�ֽӿ�ʱ����ȷ���õ���������
class InterImp implements Inter<String>{

	@Override
	public void show(String t) {
		System.out.println("show:"+t);
	}
	
}

//ʵ�ֽӿ�ʱ������ȷ���õ���������
class InterImp1<Q> implements Inter<Q>{

	@Override
	public void show(Q q) {
		System.out.println("show:"+q);
	}
	
}
class InterImp2<W> implements Inter<W>{

	@Override
	public void show(W t) {
		System.out.println("show:"+t);
	}
	
}