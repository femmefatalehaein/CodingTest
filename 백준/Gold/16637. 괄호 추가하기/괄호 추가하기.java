import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


class Main {
   
   static int n;
   //일단 최솟값으로 설정해두기. 
   static int max = Integer.MIN_VALUE;
   //static으로
   static ArrayList<Integer> num = new ArrayList<>();
   
   static ArrayList<Character> op = new ArrayList<>();
   
   
   public static int cal(int op_idx, int a, int b) {
      
      switch(op.get(op_idx)) {
      case '+':
         return a+b;
      case '-':
         return a-b;
      case '*':
         return a*b;
         }
      return 1;
      
      
      }
   
   //now는 인덱스 !!
   public static void dfs(int now, int sum) {

      /*-------------------*/
      //입력받은 연산자의 개수를 초과하면 max를 갱신하고 종료한다
      if(now>=op.size()) {
         
         max = Math.max(max, sum);
         return;
      }

      
      /*-------------------*/
      //1. 괄호 안치고 진행하기
      //처음 값.
      int one = cal(now, sum, num.get(now+1));
      dfs(now+1, one);

      /*-------------------*/
      //1. 괄호 치고 진행하기
      //현재 위치가 부호 배열 갯수보다 작다면!/*
      if(now+1<op.size()) {
         //인덱스 범위 오류를 제거하기 위해서
         int two = cal (now+1, num.get(now+1), num.get(now+2));
      
         int result = cal(now, sum, two);
   
         dfs(now+2, result);
      }
      
      
      
      
      
   }
   

   public static void main(String [] args) {
   
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();

      String input = sc.next();
      
      /*------ 입력받기 ------*/
      for(int i=0; i<N; i++) {
         //2의 배수라면
         char x = input.charAt(i);
         //문자일때
         if(i%2!=0) {
            op.add(x);
         }
         //숫자
         else {
            num.add(x-'0');
         }
      }
      
      /*------입력받기끝------*/
   
      //시작점.
      int start = num.get(0);
      
      dfs(0, start);
   
      System.out.println(max);
   }
   
   }
