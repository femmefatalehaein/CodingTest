
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		int N = Integer.parseInt(br.readLine());
		
		
		for (int i=0; i<N; i++) {
			
			String s = br.readLine();
		
			for(int j=0; j<s.length(); j++) {
				
				if(s.charAt(j)=='(') {
					stack.add(s.charAt(j));
			
				}
				else if(stack.isEmpty()&&s.charAt(j)==')') {
					stack.add(s.charAt(j));
					break;
				}
				else if(!stack.isEmpty()&&s.charAt(j)==')') {
					stack.pop();}
			
			}
			if(stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		
			stack.clear();	
		}
		
		br.close();
	
	}
}