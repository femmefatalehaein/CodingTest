import java.util.*;
import java.io.*;

public class Main {
	
	static int N, K;
	
	public static void main(String [] args) throws IOException {
		
		//사람이 제거되는 순서를 (N,K) 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();

		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		sb.append("<");
		int cnt = 1;
		
		while (!q.isEmpty()) {
			for (int i = 1; i < K; i++) { // K번째 요소가 나올 때까지 앞으로 보냄
				q.add(q.poll());
			}
			sb.append(q.poll()); // K번째 요소 제거
			
			if (!q.isEmpty()) { // 마지막 요소가 아니면 쉼표 추가
				sb.append(", ");
			}
		}
		
		sb.append(">");
		System.out.println(sb.toString());	
	}

}
