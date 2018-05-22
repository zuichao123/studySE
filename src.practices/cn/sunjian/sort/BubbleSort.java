package cn.sunjian.sort;
/**
 * 排序算法：
 * 
 * 		之--冒泡排序；
 * 		
 * @author jack
 *
 */
public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = new int[20];//定义一个整型的数组长度为100
		
		for(int i=0;i<20;i++){//初始化数组
			arr[i] = 1+(int)(Math.random()*1000);
		}
		
		System.out.println("排序之前：");
		for(int num : arr){
			System.out.print(num+"、");
		}
		
		//选择优化排序
		for(int i=0;i<arr.length-1;i++){//第i趟排序	
			for(int j=0;j<arr.length-1-i;j++){
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println("\n使用冒泡排序法，排序之后：");
		for(int num : arr){
			System.out.print(num+"、");
		}
	}

}
