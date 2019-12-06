package cn.sunjian.string;

/**
 * ����һ���ַ������飬�����ֵ�˳����д�С���������
 * {"nba","abc","cba","zz","qq","haha"}
 * 
 * ˼·��
 * 1.���������򣬿�����ѡ��ð�ݣ�
 * 2.forǶ�׺ͱȽ��Լ���λ��
 * 3.�Ƚ��ַ�������
 * 
 * @author sunjian
 *
 */
public class StringSortArray {

	public static void main(String[] args) {
		
		String [] arr = {"nba","abc","cba","zz","qq","haha"};
		
		//��ӡ����
		printArray(arr);
		
		//�����ַ���
		sortString(arr);
		
		//��ӡ����
		printArray(arr);
	}

	public static void sortString(String[] arr) {
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length-1; j++) {
				if (arr[i].compareTo(arr[j])>0) {//�ַ������^��compareTo�������
					swap(arr, i, j);
				}
			}
		}
	}

	private static void swap(String[] arr, int i, int j) {
		
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;				
	}

	//��ӡ���M����
	public static void printArray(String[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i!=arr.length-1)
				System.out.print(arr[i]+", ");
			else
				System.out.println(arr[i]+"]");
		}
	}

	

	

	
	

}
