import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

	public static void main(String args []) throws  IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		int white[][] = new int[102][102];
		//색종이 칠하기 !
		
		for (int i=0; i<N; i++) {
			
			
			
			String s = br.readLine();
			int x = Integer.parseInt(s.split(" ")[0]);
			int y = Integer.parseInt(s.split(" ")[1]);
			
			for(int j = x; j<x+10; j++) {
				for(int k =y; k<y+10; k++) {
					
						white[j+1][k+1] = 1;
					
					
				}
			}
		}
		
		int dr[] = {1,-1,0,0};
		int dc[] = {0,0,1,-1};
		
		int cnt = 0;
		
		// 둘레 더하기!
		for(int j = 1; j<101; j++) {
			
			for(int k = 1; k<101; k++) {
				
				if(white[j][k]!=0) {
			
					for(int i=0; i<4; i++) {
					
						int tmpX = j+dr[i];
						int tmpY = k+dc[i];
						
							if(white[tmpX][tmpY] == 0) 
								cnt++;

					}
				}
				
				
				
			}
			
		}
		
		
		System.out.println(cnt);
		
		
	}
	
}
