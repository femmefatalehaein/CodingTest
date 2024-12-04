import java.util.*;
import java.io.*;

class Solution {
    static int[] arr;
    static int[][][] dp;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스의 수 입력
        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        // 각 테스트 케이스 처리
        for (int tc = 0; tc < T; tc++) {

            // N: 사람 수, K: 일 수
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 각 일이 선택된 횟수를 저장하는 배열
            int[] wantCnt = new int[K];
            // 각 사람이 원하는 일을 저장하는 배열
            int[] iWantThisWork = new int[N];

            // 우선순위 큐: 설득 비용이 낮은 순으로 정렬
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[1] - b[1]; // 두 번째 값(설득 비용) 기준 오름차순 정렬
                }
            });

            // 사람들이 원하는 일을 입력받음
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(st.nextToken()) - 1; // 일을 0-indexed로 변환
                iWantThisWork[i] = a; // i번째 사람이 원하는 일
                wantCnt[a]++; // 해당 일이 선택된 횟수 증가
            }

            // 설득 비용 입력받음
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(st.nextToken()); // 설득 비용
                pq.offer(new int[]{i, a}); // {사람 번호, 설득 비용}을 우선순위 큐에 삽입
            }

            // 선택되지 않은 일의 개수를 계산
            int missingWorks = 0;
            
            for (int i = 0; i < K; i++) {
                if (wantCnt[i] == 0) // 선택되지 않은 일이면
                    missingWorks++; // 카운트 증가
            }

            long answer = 0; // 최소 설득 시간

            // 선택되지 않은 일을 모두 배정할 때까지 반복
            while (missingWorks != 0) {
                int[] p = pq.poll(); // 설득 비용이 가장 낮은 사람 선택
                
                // 현재 사람이 원하는 일이 이미 1명에게 배정된 경우 안 그럼 두명 설득해야하니까..
                if (wantCnt[iWantThisWork[p[0]]] == 1) {
                    continue; // 근데 이 뽑은 사람이 원하는 일이 나만 원해 ! 그럼 그냥 스무스하게 넘어감
                } else {
                    // 그렇지 않으면
                    wantCnt[iWantThisWork[p[0]]]--; // 현재 사람이 원하는 일을 다른 사람이 맡도록 포기시키는거임.. 왜냐? 설득비용 제일 적으니까
                    answer += p[1]; // 설득 비용 추가
                    missingWorks--; // 선택되지 않은 일의 개수 감소
                }
            }

            // 테스트 케이스 결과 저장
            sb.append("#").append((tc + 1)).append(" ").append(answer).append("\n");
        }

        // 모든 결과 출력
        System.out.println(sb);
        br.close();
    }
}