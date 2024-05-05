import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			
			int test = sc.nextInt();
			int count = 0;
			int child [] = new int[20];
	
			
			for(int j=0; j<20; j++){
				child[j] = sc.nextInt();
			}

			for(int k=0; k<20; k++) {
				for(int l=k; l<20; l++) {
					if(child[k]>child[l]) {
					 count++;
					}
				}
			}
			
			System.out.print(test+" ");
			System.out.print(count+"\n");
			
		}
			
	}
}