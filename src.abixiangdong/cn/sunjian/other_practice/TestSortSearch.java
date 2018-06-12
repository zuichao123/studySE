package cn.sunjian.other_practice;
/**
 * 练习数组有序查找
 * @author sunjian
 *
 */
public class TestSortSearch {
	public static void main(String[] args) {
		int arr[] = {4,1,2,3,9,5,6,7,3,0};
		int index = getIndex(arr, 14);
		System.out.println(index);
	}
	
	public static int getIndex(int[] arr,int key){
		for(int i =0;i<arr.length-1;i++){
			if (key==arr[i]) {
				return i;
			}
		}		
		return -1;
	}
}
