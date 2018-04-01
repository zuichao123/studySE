package cn.sunjian.main;

public class TestMain {

	public static void main(String args[]) {

//		if(args.length!=3){
//			System.out.println("输入的参数不足三个，程序退出");
//			System.exit(1);//传入非0，代表程序退出
//		}
		for(int i=0; i<args.length;i++){
			System.out.println("参数"+(i+1)+"="+args[i]);
		}
	}

}
