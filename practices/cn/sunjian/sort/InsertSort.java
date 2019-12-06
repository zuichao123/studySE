package cn.sunjian.sort;

/**
 * 排序算法：
 * 
 * 		之--插入排序；
 * 		
 * @author jack
 *
 */
public class InsertSort {

	public static void main(String[] args) {

		int[] arr = new int[2000];//定义一个整型的数组长度为100
		
		for(int i=0;i<2000;i++){//初始化数组
			arr[i] = 1+(int)(Math.random()*10000);
		}
		
		System.out.println("排序之前：");
		for(int num : arr){
			System.out.print(num+"、");
		}
		
		long startTime = System.currentTimeMillis();
		
        int insertNum;//要插入的数
        
        for(int i=1;i<arr.length;i++){//插入的次数
            insertNum=arr[i];//要插入的数
            int j=i-1;//已经排序好的序列元素个数
            while(j>=0&&arr[j]>insertNum){//序列从后到前循环，将大于insertNum的数向后移动一格
                arr[j+1] = arr[j];//元素移动一格
                j--;
            }
            arr[j+1]=insertNum;//将需要插入的数放在要插入的位置。
        }
		
        long endTime = System.currentTimeMillis();
        
		System.out.println("\n使用选择排序法，排序之后：");
		for(int num : arr){
			System.out.print(num+"、");
		}
		
		System.out.println("\n排序用时："+(endTime - startTime)+"毫秒");
	}
}