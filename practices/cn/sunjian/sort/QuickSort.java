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
	 * 查找出中轴（默认是最低位left）的在arr数组排序后所在位置
     * 
     * @param arr 带查找数组
     * @param left   开始位置
     * @param right  结束位置
     * @return 中轴所在位置
     */
    public static int getMiddle(int[] arr, int left,int right){
    	
        int temp = arr[left]; //数组的第一个作为中轴

        while(left < right){//如果第一个脚标值小于最后一个角标值

        	/*
        	 * 从数组的最右边开始依次找比中轴小的值
        	 * 
        	 * 如果最右边的值大于中轴，脚本往左移动一个，再次比较；
        	 * 直到找到小于中轴的值，将找的比中轴小的数值移动到最左边
        	 * 
        	 */
	        while(left < right && arr[right] > temp){
	            right--;
	        }
	        //将找的比中轴小的数值移动到最左边
	        arr[left] = arr[right];

	        /*
	         * 再拿最左边的值（包括刚才移动过来的值）和中轴比较，如果最左边的值比中轴小，将数组最左的脚本往右移动一个，再次比较；
	         * 直到找到比中轴大的值，将改值移动到现在最右边的位置处
	         */
	        while(left < right && arr[left] < temp){
	            left++;
	        }
	        //比中轴大的数值移到最右边
	        arr[right] = arr[left] ;
        }
        
        //将最开始的中轴数值放在当前最左边的角标所处的位置
        arr[left] = temp ;
        
        // 返回中轴的位置
        return left ;
    }
    
    /**
     * 递归形式的分治排序算法
     * 
     * @param arr 带排序数组
     * @param left  开始位置
     * @param right 结束位置
     */
    public static void quickSort(int[] arr,int left,int right){
    	
        if(left < right){
        	
        	//将arr数组进行一分为二
        	int middle = getMiddle(arr,left,right);
        	
        	//递归排序（从数组最左边到中轴的左边一个）
        	quickSort(arr, left, middle-1);

        	//递归排序（从中轴的右边一个到数组的最后一个）
        	quickSort(arr, middle+1, right);
        }
    
    }
	
}
