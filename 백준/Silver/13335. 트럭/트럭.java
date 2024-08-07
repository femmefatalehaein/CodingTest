import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;


class Main{
	

	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String s = br.readLine();
		
		//트럭 댓수
		int cnt =Integer.parseInt(s.split(" ")[0]); 
		
		//다리 길이
		int length = Integer.parseInt(s.split(" ")[1]); 	
		
		//최대 부하
		int maxWeight = Integer.parseInt(s.split(" ")[2]); 
		
	
	
		Queue<Integer> bridge = new LinkedList<Integer>();
		//트럭들 무게를 arr 배열에 저장했다.
		String t = br.readLine();
		int arr[] = new int [cnt];
		for(int i =0; i<cnt ; i++) {
			arr[i]= Integer.parseInt(t.split(" ")[i]);
			//만약에 queue 안에 애들은
		}
	
	
		//다리 길이만큼 큐에 0을 넣어준다.
		while(length-->0) {
			bridge.add(0);
		}
	

		int time = 0;
		int i = 0;
		
		int sum = 0;
		while(true)
		{
			//여기서 시간이 1초 간다.
			time ++;
			//값을 넣어야 되니.
			
			//일단 bridge 에서 poll하고 sum 에서 그 값을 빼준다.
			sum-=bridge.poll();
			//들어가려는 값과 bridge에 있는 값의 합이 maxWeight을 넘지 않는다면.
			if(i<cnt&&sum+arr[i]<=maxWeight) {
				//여기서 넣는다.
				bridge.add(arr[i]);
				//총합에 넣은 값을 넣어준다.
				sum+=arr[i];
	
				i++;
			}
			//들어가려는 값과 bridge에 있는 값의 합이 maxWeight을 넘는다면..
			else {
				//아무것도 못들어가...0 넣어줘...
				bridge.add(0);
			}
			
			//bridge안의 값이 모두 0일때는 다 건넌 거라고 간주할수 있지? while문 빠져나와!!
			if(sum ==0) {
				break;
			}
	
		}
	
		System.out.println(time);
	

	}
}
