
import java.util.*;
import java.io.*;

class Main {
	
 //첫번째 줄에 과목의 수N 와 선수조건의 수 M이 주어진다.
 // 선수과목 조건은 M개의 줄에 걸쳐 한 줄에 정수 A B 형태로 주어진다.
	static int N, M;
	static ArrayList<Integer> [] list;
	static int [] inDegree; //진입차수 배열
	static int [] semester;
	
	public static void main(String[] args) throws IOException {
		// a번과목이 B 과목의 선수과목
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list  = new ArrayList[N+1];
		inDegree = new int[N+1];
		semester = new int[N+1];
		//초기화 해주기.
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to  = Integer.parseInt(st.nextToken());
			list[from].add(to);
			inDegree[to]++;
		}
		
		//1. 진입차수가 0인 노드 큐에 추가 및 학기 설정
		Queue<Integer> q = new ArrayDeque<>();
		
		//맨 처음에 방문할 아이들.
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0) {
				q.offer(i);
				semester[i] = 1; //진입차수 0이면 첫학기에 방문 가능 ㅋ 
			}
		}
		
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			//현재 노드와 연결된 애들 방문할거임.
			for(int next : list[cur]) {
				inDegree[next] --; //진입차수 감소..시키고 (왜냐면 cur을 방문했으니) 진입차수 0이면 방문할거임
				if(inDegree[next] == 0) {
					q.offer(next); //방문할거임. 그럼 1개 더 추가인거임
					semester[next] = semester[cur]+1;
				}
				
			}
			
		}

		StringBuilder sb = new StringBuilder ();
		for(int i=1; i<=N; i++) {
			sb.append(semester[i]).append(" ");
		}
		System.out.print(sb.toString().trim());
		br.close();
		
	}
}
