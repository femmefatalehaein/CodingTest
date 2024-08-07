import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            // 스택이 비어있지 않고, 현재 높이가 스택의 최상단 높이보다 작다면
            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                count++;
            }
            
            // 현재 높이가 이전 높이와 다를 경우에만 스택에 추가
            if (stack.isEmpty() || stack.peek() < y) {
                stack.push(y);
            }
        }
        
        // 스택에 남은 높이들 처리
        while (!stack.isEmpty() && stack.peek() > 0) {
            stack.pop();
            count++;
        }
        
        System.out.println(count);
    }
}
