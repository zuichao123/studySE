package cn.sunjian.main;

public class TestMain {

	public static void main(String args[]) {

//		if(args.length!=3){
//			System.out.println("����Ĳ������������������˳�");
//			System.exit(1);//�����0����������˳�
//		}
		for(int i=0; i<args.length;i++){
			System.out.println("����"+(i+1)+"="+args[i]);
		}
	}

}
