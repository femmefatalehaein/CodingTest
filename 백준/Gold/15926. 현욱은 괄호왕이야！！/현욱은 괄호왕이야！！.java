
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {
	public static void main(String [] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		String x = br.readLine();
		boolean [] chk = new boolean[n];
		
		for(int i=0; i<n; i++) {
		
		if(x.charAt(i)=='(') {
			stack.add(i);
		}else {
			if(!stack.isEmpty()) {
				chk[stack.pop()]=true;
				chk[i]=true;
			}
		}

		}
		
		//chk 배열의 연속 최댓값!
		int max =0, t=0;
		
		for(int i =0; i<n; i++) {
			if(chk[i]) {
				t++;
				max = Math.max(max, t);
			}else {
				t=0;
			}
		}
		
		System.out.println(max);
	}
	}