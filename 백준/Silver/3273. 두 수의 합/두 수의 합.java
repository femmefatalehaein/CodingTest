import java.util.Scanner;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		
		boolean exist[] = new boolean[1000001];
		for(int i=0; i<N; i++) {
			exist[arr[i]] = true;
		}
		
		int cnt = 0;
		//절반만 본다.어차피 그 뒤로 넘어가면 중복임.
		for(int i=1; i<=(sum-1)/2; i++) {
			//이 조건은 왜..?
			if(i<=1000000 && sum-i <= 1000000)
				//둘 다 존재해야함.
				cnt += (exist[i] && exist[sum-i])? 1: 0;
		}
		
		System.out.println(cnt);
	
	}
}