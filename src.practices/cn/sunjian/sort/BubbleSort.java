package cn.sunjian.sort;
/**
 * �����㷨��
 * 
 * 		֮--ð������
 * 		
 * @author jack
 *
 */
public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = new int[20];//����һ�����͵����鳤��Ϊ100
		
		for(int i=0;i<20;i++){//��ʼ������
			arr[i] = 1+(int)(Math.random()*1000);
		}
		
		System.out.println("����֮ǰ��");
		for(int num : arr){
			System.out.print(num+"��");
		}
		
		//ѡ���Ż�����
		for(int i=0;i<arr.length-1;i++){//��i������	
			for(int j=0;j<arr.length-1-i;j++){
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println("\nʹ��ð�����򷨣�����֮��");
		for(int num : arr){
			System.out.print(num+"��");
		}
	}

}
