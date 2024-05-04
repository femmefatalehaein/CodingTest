import java.util.Scanner;
class Main{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] map = new char[N][M];
		
		for (int i=0; i<N; i++)
			map[i] = sc.next().toCharArray();
		
		int rowCount = 0;
		int colCount = 0;
		
		//행고정
		for(int i=0; i<N; i++) {
			boolean exist = false;
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'X') {
					exist = true;
				}
				if(exist) {rowCount ++;
				break;}
			}	
		}
		
		//열고정
		for(int i=0; i<M; i++) {
			boolean exist = false;
			for(int j=0; j<N; j++) {
				if(map[j][i] == 'X') {
					exist = true;					
				}
				if(exist) {colCount ++;
				break;}
			}
			
		}
		
		
		if(M-colCount>N-rowCount) {
			System.out.print(M-colCount);
		}
		else {
			System.out.print(N-rowCount);
		}

		
		
	}
}