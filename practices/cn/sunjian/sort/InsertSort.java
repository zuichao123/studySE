package cn.sunjian.sort;

/**
 * �����㷨��
 * 
 * 		֮--��������
 * 		
 * @author jack
 *
 */
public class InsertSort {

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
		
        int insertNum;//Ҫ�������
        
        for(int i=1;i<arr.length;i++){//����Ĵ���
            insertNum=arr[i];//Ҫ�������
            int j=i-1;//�Ѿ�����õ�����Ԫ�ظ���
            while(j>=0&&arr[j]>insertNum){//���дӺ�ǰѭ����������insertNum��������ƶ�һ��
                arr[j+1] = arr[j];//Ԫ���ƶ�һ��
                j--;
            }
            arr[j+1]=insertNum;//����Ҫ�����������Ҫ�����λ�á�
        }
		
        long endTime = System.currentTimeMillis();
        
		System.out.println("\nʹ��ѡ�����򷨣�����֮��");
		for(int num : arr){
			System.out.print(num+"��");
		}
		
		System.out.println("\n������ʱ��"+(endTime - startTime)+"����");
	}
}