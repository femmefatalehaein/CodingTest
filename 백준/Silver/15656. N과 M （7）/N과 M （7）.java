import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] arr, printArr;
	static StringBuilder sb = new StringBuilder(); // 시간초과 해결용
	
	public static void main(String[] args) throws IOException{
			Scanner sc = new Scanner(System.in);
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new int[N];
			printArr = new int[M];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			sc.close();
			
			Arrays.sort(arr); // 입력받은 배열을 오름차순으로 정렬한다.
			
			dfs(0, 0);
			
			System.out.println(sb);
	}
	
	static void dfs(int start, int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(printArr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			printArr[depth] = arr[i];
			dfs(i + 1, depth + 1); 
		}
	}
}