import java.util.Scanner;


class Main{
	
	public static boolean isEurekaNumber(int[] triangleNumbers, int K) {
		for(int i=1; i<=44; i++) {
			for(int j=1; j<=44; j++) {
				for(int k=1; k<=44; k++) {
					int sum = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k];
					if(sum == K) {return true;}
				}
			}
		}
		return false;
	}

	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int triNum[] = new int[45];
		int triangleNumberCount = 0;
		for(int i=1; i<=44; i++) {
			triNum[i] = i*(i+1)/2;
		}
		
		int num[] = new int[T];
		for(int i=0; i<T; i++) {
			num[i] = sc.nextInt();
		}
	
		for(int i=0; i<T; i++) {
			
			boolean ans = isEurekaNumber(triNum,num[i]);
            System.out.println(ans? "1":"0");
		
		}
			
	}
}