import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main{
	
	public static boolean isExist(int arr[], int x) {
		int l =0, r=arr.length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			if(arr[mid]>x) {
				r = mid-1;
			}
			else if(arr[mid]<x) {
				l= mid+1;
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//두 수의 합을 저장할 배열 만들기 
		Set<Integer> sums = new HashSet<>();
		//두 수의 합을 set에 저장한다.
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				sums.add(arr[i]+arr[j]);
			}	
		}
		
		Arrays.sort(arr);
		//A+B+C=K를 A+B=K-C 로 생각해보자.
		//배열을 정렬했으니 큰 수에서 작은 수 빼는거임 무조건 양수 
		int ans = -1;
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				int target = arr[j] - arr[i];
				//System.out.println(target);
				if(sums.contains(target))
					ans = Math.max(ans, arr[j]);
			}
		}
		System.out.print(ans);	
	}
}