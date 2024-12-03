import java.util.*;
import java.io.*;

public class Solution {
    static int N, W, H;
    static int[][] bricks = new int[15][12];  // 원본 맵
    static int[][] map = new int[15][12];     // 작업용 맵
    static int[] pickCol;
    static int min;

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

    // 벽돌 제거 (재귀적으로 처리)
    private static void remove(int row, int col) {
        int range = map[row][col] - 1;
        map[row][col] = 0; // 현재 벽돌 제거

        // 상하좌우로 제거
        for (int i = -range; i <= range; i++) {
            if (row + i >= 0 && row + i < H && map[row + i][col] != 0) {
                remove(row + i, col);
            }
            if (col + i >= 0 && col + i < W && map[row][col + i] != 0) {
                remove(row, col + i);
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
