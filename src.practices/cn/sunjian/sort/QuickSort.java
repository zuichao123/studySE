package cn.sunjian.sort;
/**
 * �����㷨��
 * 
 * 		֮--�������򣻿��ŷ�
 * 		
 * @author jack
 *
 */
public class QuickSort {

	public static void main(String[] args) {

		/*int[] arr = new int[20];//����һ�����͵����鳤��Ϊ100
		
		for(int i=0;i<20;i++){//��ʼ������
			arr[i] = 1+(int)(Math.random()*1000);
		}*/
		
		int[] arr = {513,737,155,723,786,534,205,487,54,334,882,358,2,938,203,665,881,812,126,371};
		
		System.out.println("����֮ǰ��");
		for(int num : arr){
			System.out.print(num+",");
		}
		
		if (arr.length > 0) {
			quickSort(arr, 0, arr.length-1);
		}

		System.out.println("\nʹ�ÿ������򷨣�����֮��");
		for(int num : arr){
			System.out.print(num+",");
		}
	}

	
	/** 
	 * ���ҳ����ᣨĬ�������λlow������arr�������������λ��
     * 
     * @param arr ����������
     * @param low   ��ʼλ��
     * @param high  ����λ��
     * @return  ��������λ��
     */
    public static int getMiddle(int[] arr, int low,int high){
    	
        int temp = arr[low]; //����ĵ�һ����Ϊ����

        while(low < high){
        	
	        while(low < high && arr[high] > temp){
	            high--;
	        }
	        
	        arr[low] = arr[high];//������С�ļ�¼�Ƶ��Ͷ�

	        while(low < high && arr[low] < temp){
	            low++;
	        }
	        
	        arr[high] = arr[low] ; //�������ļ�¼�Ƶ��߶�
        }
        
        arr[low] = temp ; //�����¼��β
        return low ; // ���������λ��
    }
    
    /**
     * �ݹ���ʽ�ķ��������㷨
     * 
     * @param arr ����������
     * @param low  ��ʼλ��
     * @param high ����λ��
     */
    public static void quickSort(int[] arr,int low,int high){
    	
        if(low < high){
        	
        	int middle = getMiddle(arr,low,high); //��arr�������һ��Ϊ��
        	
        	quickSort(arr, low, middle-1);   //�Ե��ֶα���еݹ�����

        	quickSort(arr, middle+1, high); //�Ը��ֶα���еݹ�����
        }
    
    }
	
}
