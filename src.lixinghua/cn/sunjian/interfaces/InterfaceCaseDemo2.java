package cn.sunjian.interfaces;

/**
 * 为接口实例化对象
 * 
 * @author sunjian
 *
 */
interface USB{//定义接口
	public void start();
	public void stop();
}

class Computer{//定义计算机类
	public static void plugin(USB usb){
		
		usb.start();
		System.out.println("------usb设备工作----------");
		usb.stop();
		
	}
}

class Flash implements USB{//Flash类实现USB接口
	public void start(){//覆写方法
		System.out.println("U盘开始工作");
	}
	public void stop(){//覆写方法
		System.out.println("U盘停止工作");
	}
}
class Print implements USB{
	public void start(){
		System.out.println("打印机开始工作");
	}
	public void stop(){
		System.out.println("打印机停止工作");
	}
}




public class InterfaceCaseDemo2 {

	public static void main(String[] args) {

		Computer.plugin(new Flash());
		Computer.plugin(new Print());
		
	}

}
