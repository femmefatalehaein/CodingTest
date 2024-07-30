
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
		StringBuilder result = new StringBuilder();
		while(n-->0) {
			String tgt = br.readLine();
			switch(tgt) {
			case "pop":
				if(stack.isEmpty()) {
				result.append("-1").append("\n");
				}
				else {
					result.append(stack.pop()).append("\n");	
				}
				
				break;
			case "size":
				result.append(stack.size()).append("\n");
				break;
			case "empty":
				if(stack.isEmpty()) {
					result.append("1").append("\n");
				}
				else {
					result.append("0").append("\n");
				}
				break;
			case "top":
				if(stack.isEmpty()) {
					result.append("-1").append("\n");
				}
				else {
					result.append(stack.peek()).append("\n");
				}
				break;
			default:
				stack.add(Integer.valueOf(tgt.split(" ")[1]));
				break;
			
				
			}
			
		}
		System.out.println(result);
	}
	}