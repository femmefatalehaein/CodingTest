import java.io.*;
import java.util.*;


class Main{
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<Character>();

		int cnt = 0;
		//stack
		for(int i=0; i<s.length(); i++) {
			char x = s.charAt(i);
			
			if(x=='(') {
				stack.push(x);
			}
			else if(x==')'&&!stack.isEmpty()) {
				stack.pop();
			}else {
				cnt++;
			}
		}
		
	
		
		System.out.println(cnt+stack.size());
	}
}
