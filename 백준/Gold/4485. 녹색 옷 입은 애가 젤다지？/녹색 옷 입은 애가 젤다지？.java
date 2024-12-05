

import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int [][] map;
	static int [] dx = new int [] {-1,1,0,0};
	static int [] dy = new int [] {0,0,-1,1};
	
	static int Dijkstra(int startR, int startC) {
		
		int dist [][] = new int[N][N];
		int INF = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
		    Arrays.fill(dist[i], INF); // 각 행을 INF로 초기화
		}
	
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
		
		//시작점 넣기
		pq.offer(new int[] {startR,startC,map[startR][startC]});
		
		//시작점 까지의 가중치는 0이다.
		dist[startR][startC] = map[startR][startC];
		
		while(!pq.isEmpty()) {
			
			int [] curNode = pq.poll();
			int curR = curNode[0];
			int curC = curNode[1];
			// 연결된 아이들 중에서 
			for(int i=0; i<4; i++) {
				
					int nextR = curR+dx[i];
					int nextC = curC+dy[i];
				
					//범위밖의 아이는 넘기기
					if(nextR>=N||nextR<0||nextC>=N||nextC<0) continue;
					//현재 노드를 들려서 다음 노드를 방문하는게 ..이득이라면? 
					int nextCost = map[nextR][nextC];
					
					if(dist[nextR][nextC]>dist[curR][curC]+nextCost) {
						dist[nextR][nextC] = dist[curR][curC]+nextCost;
						pq.offer(new int[] {nextR,nextC,dist[nextR][nextC]});
					}
			}
			
		}
		
		
		return(dist[N-1][N-1]);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			
			if(N==0) {break;}
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Problem ").append(t).append(": ").append(Dijkstra(0,0)).append("\n");
			t++;
		}
		
		System.out.print(sb.toString());
		br.close();
		
	}

}
