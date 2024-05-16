import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main{
	

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//용액 받았어.
		int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) 
            arr[i] = Integer.parseInt(input[i]);
        
		//배열 정렬
		Arrays.sort(arr);
		
		int min = Integer.MAX_VALUE;
		
		int left = 0;
		int right = N-1;
		int sol1 = 0;
		int sol2 = 0;
		
		while(left<right) {
			int value = Math.abs(arr[left]+arr[right]);
			if(value<min) {
				min = value;
				sol1 = left;
				sol2 = right;
				
				if(value == 0) break;
			}
			if(Math.abs(arr[left])<Math.abs(arr[right]))
				right--;
			else
				left++;
		}
		System.out.println(arr[sol1]+" "+arr[sol2]);
		
		
	}
}