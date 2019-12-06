package cn.sunjian.other_practice;
/**
 * 二维数组定义的格式
 * @author sunjian
 *
 */
public class TestTwoArray {

	public static void main(String[] args) {
		int [][] arr =new int [3][2];
		
		System.out.println(arr.length);
		System.out.println(arr[1].length);
		
		int[][] arr1 = {{1,3,5,7,4},{8,3,9},{5,3,5}};
		
		int sum = 0;
		for(int i=0; i<arr1.length; i++){
			for(int j=0;j<arr1[i].length;j++){
				System.out.print(arr1[i][j]);
				sum += arr1[i][j];
			}
		}
		
		System.out.println("\n"+"sum="+sum);
	}
}
