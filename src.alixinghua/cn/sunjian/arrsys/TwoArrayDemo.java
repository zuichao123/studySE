package cn.sunjian.arrsys;

public class TwoArrayDemo {

	public static void main(String[] args) {

//		int score[][] = new int [4][3];//4是行3是列
//		score[0][1] = 30;
//		score[1][0] = 30;
//		score[2][2] = 30;
//		score[3][1] = 30;
//		score[1][1] = 30;
		
		int score[][] = {
				{7,87,9},
				{76,54,2,26,},
				{565,34,234,2343,657,},
				{21,34,454,234}
		};
		
		
		for(int i=0;i<score.length;i++){
			for(int j=0;j<score[i].length;j++){
				System.out.print(score[i][j]+"\t");
			}
			System.out.println("");
		}
	}

}
