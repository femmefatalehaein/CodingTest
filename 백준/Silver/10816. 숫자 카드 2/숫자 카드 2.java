import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

class Main{
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 숫자카드의 갯수
        int N = Integer.parseInt(br.readLine());
        int[] arrCard = new int[N];
        String[] input = br.readLine().split(" ");
        
        // 숫자 카드의 숫자들을 배열에 저장
        for (int i = 0; i < N; i++) 
            arrCard[i] = Integer.parseInt(input[i]);
        
        // 해시맵을 사용하여 각 숫자의 등장 횟수를 저장
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = arrCard[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // 주어진 정수의 갯수
        int M = Integer.parseInt(br.readLine());
        int[] arrNum = new int[M];
        String[] input2 = br.readLine().split(" ");
        
        // 주어진 정수들을 배열에 저장하면서 등장 횟수 출력
        for (int i = 0; i < M; i++) {
            arrNum[i] = Integer.parseInt(input2[i]);
            int count = countMap.getOrDefault(arrNum[i], 0);
            bw.write(count + " ");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}