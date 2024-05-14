import java.util.Scanner;

class Main {
		
	public static void main(String args[]) {
		

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		int cnt = 1;
		int x = N;
		while(x/B!=0) {
			x = x/B;
			cnt++;
		}

		int [] arr = new int[cnt];
		
		int y = N;
		int i = 0;
		while(y/B!=0) {
			arr[i] = y%B;
			y = y/B;
			i++;
		}
		arr[i] = y%B;
		
		
		for(i=arr.length-1; i>=0; i--) {
			if(arr[i]<10) {
				System.out.print(arr[i]);
			}
			else {
				char c = (char)(arr[i]+55);
				System.out.print(c);
			}
		}
		
		
	}
}