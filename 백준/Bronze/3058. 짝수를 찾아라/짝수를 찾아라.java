import java.util.Scanner;
class Main{
	
	public static boolean checkDouble(int x) {
		if(x%2==0) {
			return true;
		}
		return false;
	}
	
	public static int checkMin(int arr[]) {
		int min = 101;
		for(int i=0; i<7; i++) {
			if(arr[i]<min&&checkDouble(arr[i]))
				min= arr[i];
		}
		return min;
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int sum = 0;
			int[]arr = new int[7];
			for(int i=0; i<7; i++) {
				int x = sc.nextInt();
				arr[i] = x;
				if(checkDouble(x)) {
					sum+=x;
				}		
			}
			System.out.println(sum+" "+checkMin(arr));
		}
		
	}
	
}