import java.util.Scanner;
class Main{
	
	//일단 진법으로 변환한다.
	public static int convertBase(int x, int base, int[] reverseDigit) {
		//2^20 = 백만이니까 충분~
		//int[] reverseDigit = new int[20];
		int len = 0;
		while(x>0) {
			//len 후위연산자
			reverseDigit[len++] = x%base;
			x/=base;
		}
		return len;
	}
	
	//2. 변환된 수가 회문이 될 수 있는지 확인한다. -> 아니다를 판단하는게 더 빠른가...
	public static boolean isPalindrome(int [] digit, int length) {
		for(int i=0; i<length/2; i++) {
			if(digit[i]!=digit[length-i-1]) {
				return false;}
			}
		return true;
	}
	
	public static boolean checking(int x) {
		boolean ans = false;
		for(int i=2; i<=64; i++) {
			int[] baseDigit = new int[20];
			//진법 변환
			int baseLength = convertBase(x,i,baseDigit);
			if(isPalindrome(baseDigit, baseLength)) {
				ans = true;
				break;
			}
		}
		return ans;
	}
		
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();


		while(T-->0) {
			int x=sc.nextInt();
			System.out.println(checking(x)?1:0);
		}
			
	}
}