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
	 * ���ҳ����ᣨĬ�������λleft������arr�������������λ��
     * 
     * @param arr ����������
     * @param left   ��ʼλ��
     * @param right  ����λ��
     * @return ��������λ��
     */
    public static int getMiddle(int[] arr, int left,int right){
    	
        int temp = arr[left]; //����ĵ�һ����Ϊ����

        while(left < right){//�����һ���ű�ֵС�����һ���Ǳ�ֵ

        	/*
        	 * ����������ұ߿�ʼ�����ұ�����С��ֵ
        	 * 
        	 * ������ұߵ�ֵ�������ᣬ�ű������ƶ�һ�����ٴαȽϣ�
        	 * ֱ���ҵ�С�������ֵ�����ҵı�����С����ֵ�ƶ��������
        	 * 
        	 */
	        while(left < right && arr[right] > temp){
	            right--;
	        }
	        //���ҵı�����С����ֵ�ƶ��������
	        arr[left] = arr[right];

	        /*
	         * ��������ߵ�ֵ�������ղ��ƶ�������ֵ��������Ƚϣ��������ߵ�ֵ������С������������Ľű������ƶ�һ�����ٴαȽϣ�
	         * ֱ���ҵ���������ֵ������ֵ�ƶ����������ұߵ�λ�ô�
	         */
	        while(left < right && arr[left] < temp){
	            left++;
	        }
	        //����������ֵ�Ƶ����ұ�
	        arr[right] = arr[left] ;
        }
        
        //���ʼ��������ֵ���ڵ�ǰ����ߵĽǱ�������λ��
        arr[left] = temp ;
        
        // ���������λ��
        return left ;
    }
    
    /**
     * �ݹ���ʽ�ķ��������㷨
     * 
     * @param arr ����������
     * @param left  ��ʼλ��
     * @param right ����λ��
     */
    public static void quickSort(int[] arr,int left,int right){
    	
        if(left < right){
        	
        	//��arr�������һ��Ϊ��
        	int middle = getMiddle(arr,left,right);
        	
        	//�ݹ����򣨴���������ߵ���������һ����
        	quickSort(arr, left, middle-1);

        	//�ݹ����򣨴�������ұ�һ������������һ����
        	quickSort(arr, middle+1, right);
        }
    
    }
	
}
