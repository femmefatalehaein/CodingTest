import java.util.Scanner;
import java.util.Arrays;

class Main{
	
	static boolean BinarySearch(String[] arr, String x) {
		int l =0 , r = arr.length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			
			//compareTo메서드..
			int compareResult = arr[mid].compareTo(x);
			//arr[mid]가 더 앞선다.
			if(compareResult<0) {
				l = mid+1;
			}
			else if(compareResult>0) {
				r= mid-1;
			}
			else {
				return true;
			}
		}
		return false;	
	}
	
	
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String arr[] = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.next();
		}
		//정렬하기
		Arrays.sort(arr);
		int cnt = 0;
		for(int i=0; i<m; i++) {
			String x = sc.next();
			if(BinarySearch(arr,x)) {
				cnt++;
			}
		}
		System.out.print(cnt);
		
	}
	
}