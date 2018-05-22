package cn.sunjian.sort;
/**
 * 排序算法：
 * 
 * 		之--快速排序；快排法
 * 		
 * @author jack
 *
 */
public class QuickSort {

	public static void main(String[] args) {

		/*int[] arr = new int[20];//定义一个整型的数组长度为100
		
		for(int i=0;i<20;i++){//初始化数组
			arr[i] = 1+(int)(Math.random()*1000);
		}*/
		
		int[] arr = {513,737,155,723,786,534,205,487,54,334,882,358,2,938,203,665,881,812,126,371};
		
		System.out.println("排序之前：");
		for(int num : arr){
			System.out.print(num+",");
		}
		
		if (arr.length > 0) {
			quickSort(arr, 0, arr.length-1);
		}

		System.out.println("\n使用快速排序法，排序之后：");
		for(int num : arr){
			System.out.print(num+",");
		}
	}

	
	/** 
	 * 查找出中轴（默认是最低位low）的在arr数组排序后所在位置
     * 
     * @param arr 带查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return  中轴所在位置
     */
    public static int getMiddle(int[] arr, int low,int high){
    	
        int temp = arr[low]; //数组的第一个作为中轴

        while(low < high){
        	
	        while(low < high && arr[high] > temp){
	            high--;
	        }
	        
	        arr[low] = arr[high];//比中轴小的记录移到低端

	        while(low < high && arr[low] < temp){
	            low++;
	        }
	        
	        arr[high] = arr[low] ; //比中轴大的记录移到高端
        }
        
        arr[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    }
    
    /**
     * 递归形式的分治排序算法
     * 
     * @param arr 带排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void quickSort(int[] arr,int low,int high){
    	
        if(low < high){
        	
        	int middle = getMiddle(arr,low,high); //将arr数组进行一分为二
        	
        	quickSort(arr, low, middle-1);   //对低字段表进行递归排序

        	quickSort(arr, middle+1, high); //对高字段表进行递归排序
        }
    
    }
	
}
