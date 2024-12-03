import java.util.*;
import java.io.*;

public class Solution {
    static int N, W, H;
    static int[][] bricks = new int[15][12];  // 원본 맵
    static int[][] map = new int[15][12];     // 작업용 맵
    static int[] pickCol;
    static int min;
    static int dr [] = new int [] {-1,1,0,0,};
    static int dc [] = new int [] {0,0,-1,1};

    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            pickCol = new int[N];

            // 입력 데이터 처리
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    bricks[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE; // 최소 남은 벽돌 개수를 초기화
            
            permutation(0); // 중복 순열 생성

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        
        System.out.println(sb);
    }

    // 중복 순열을 통해 구슬 위치 결정
    private static void permutation(int cnt) {
        if (cnt == N) { // 구슬을 쏠 열의 위치를 모두 정한 경우
            // 작업용 맵 복사
            for (int r = 0; r < H; r++) {
                System.arraycopy(bricks[r], 0, map[r], 0, W);
            }

            // 구슬 발사
            for (int i = 0; i < N; i++) {
                shot(pickCol[i]);
            }

            // 남은 벽돌 개수 계산
            min = Math.min(min, getBrickCount());
            return;
        }

        for (int c = 0; c < W; c++) {
            pickCol[cnt] = c; // 구슬을 쏠 열 선택
            permutation(cnt + 1);
        }
    }

    // 구슬 발사
    private static void shot(int col) {
        int r;
        for (r = 0; r < H; r++) { // 구슬이 명중할 첫 번째 벽돌 찾기
            if (map[r][col] != 0) break;
        }
        if (r == H) return; // 벽돌이 없으면 종료
        // 벽돌 제거
        remove(r, col);
        // 중력 적용
        down();
    }


    private static void remove(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col, map[row][col]}); // 큐에 초기 위치와 벽돌 숫자 추가
        map[row][col] = 0; // 현재 벽돌 제거

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0]; // 현재 행
            int c = current[1]; // 현재 열
            int range = current[2] - 1; // 제거 범위 (벽돌 숫자 - 1)

            // 상하좌우 탐색
            for (int d = 0; d < 4; d++) { // 4방향 탐색
                for (int i = 1; i <= range; i++) { // 벽돌 숫자만큼 퍼짐
                    int nr = r + i * dr[d]; // 다음 행 (R[d]는 방향 벡터)
                    int nc = c + i * dc[d]; // 다음 열 (C[d]는 방향 벡터)

                    // 범위 밖이거나 이미 제거된 벽돌이면 스킵
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 0) {
                        continue;
                    }

                    // 큐에 추가하고 벽돌 제거
                    if (map[nr][nc] > 1) { // 연쇄 반응 가능한 벽돌
                        queue.add(new int[]{nr, nc, map[nr][nc]});
                    }
                    map[nr][nc] = 0; // 벽돌 제거
                }
            }
        }
    }


    // 중력 적용
    private static void down() {
        for (int c = 0; c < W; c++) {
            int downHeight = 0;
            for (int r = H - 1; r >= 0; r--) {
                if (map[r][c] == 0) {
                    downHeight++;
                } else if (downHeight > 0) {
                    map[r + downHeight][c] = map[r][c];
                    map[r][c] = 0;
                }
            }
        }
    }

    // 남은 벽돌 개수 계산
    private static int getBrickCount() {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) count++;
            }
        }
        return count;
    }
}
