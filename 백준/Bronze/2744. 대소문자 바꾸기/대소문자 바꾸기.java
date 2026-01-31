import java.io.*;

class Main {
	
	public static void main(String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for (char a : input.toCharArray()) {
			if(Character.isUpperCase(a)) {
				sb.append(Character.toLowerCase(a));
			}else {
				sb.append(Character.toUpperCase(a));
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
}