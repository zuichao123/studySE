package cn.sunjian.sort;
/**
 * �����㷨��
 * 
 * 		֮--ѡ������
 * 		
 * @author jack
 *
 */
public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = new int[2000];//����һ�����͵����鳤��Ϊ100
		
		for(int i=0;i<2000;i++){//��ʼ������
			arr[i] = 1+(int)(Math.random()*10000);
		}
		
		System.out.println("����֮ǰ��");
		for(int num : arr){
			System.out.print(num+"��");
		}
		
		long startTime = System.currentTimeMillis();
		
		//ѡ���Ż�����
		for(int i=0;i<arr.length-1;i++){//��i������
			
			int k = i;//��¼��Сֵ�ĽǱ�
			for(int j=k+1;j<arr.length;j++){
				if (arr[j]<arr[k]) {//����ڶ���С�ڵ�һ��
					k = j;//��¼�ڶ����ĽǱ�
				}
			}
			
			//�ҵ�������С�����Ժ󣬽��н���
			if (i != k) {
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("\nʹ��ѡ�����򷨣�����֮��");
		for(int num : arr){
			System.out.print(num+"��");
		}
		
		System.out.println("\n������ʱ��"+(endTime - startTime)+"����");
	}

}
