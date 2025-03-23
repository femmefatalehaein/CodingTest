import java.io.*;
import java.util.*;
public class Main {
	
	static int N ;
	static int [] board;
	static int count;
	
	
	public static void main (String [] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		count = 0; 
		//어차피 N개의 말을 두는 거라면 일차원 배열도 가능하지
		// int[row] = col 의 형태로 
		board = new int[N];
		trackingBoard(0);
		System.out.println(count);
	}

	//1. 일단 선택할 행을 선택한다. 
	public static void trackingBoard(int row) {
		
		//종료조건
		if(row == N) {
			count ++;
			return;
		}
		
		//2. 열을 선택한다.
		for(int col=0; col<N; col ++) {
			//3. 대각선에 있는지 확인해야함.
			if(isValid(row,col)) {
				board[row] = col;
				trackingBoard(row+1);
				board[row] = -1; // 백트래킹 board[row]=col에 안두고 다른데에 두는 경우의 수를 돌린다.
			}	
		}
		
	}
	
	public static boolean isValid(int row, int col) {
		//같은 열에 퀸이 있는지 확인한다. → 행을 돌린다.
		for(int i=0; i<row; i++) {
			if(board[i] == col ||
					board[i]-i == col - row ||
					board[i]+i == col + row) {
				return false;
			}
		}
		return true;
	}
	
}
