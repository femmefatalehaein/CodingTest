import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		int cnt[] = new int[10001];
		
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			cnt[num]++;
		}
		
		for(int j=0; j<10001; j++) {
			while(cnt[j]>0) {
				bw.write(j+"\n");
				cnt[j]--;
			}			
		}
	
  		bw.flush();
	}
}