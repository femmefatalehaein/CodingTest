import java.util.Scanner;

public class Main {

    static int R, C, T;
    static int[][] room;
    static int upperR, underR;

    public static void spread() {
        int[][] result = new int[R][C];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (room[r][c] > 0) {
                    int amount = room[r][c] / 5;
                    int cnt = 0;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && room[nr][nc] != -1) {
                            result[nr][nc] += amount;
                            cnt++;
                        }
                    }
                    result[r][c] += room[r][c] - amount * cnt;
                } else if (room[r][c] == -1) {
                    result[r][c] = -1; // Keep air purifier location
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                room[r][c] = result[r][c];
            }
        }
    }

    public static void operateAirPurifier() {
        // Upper part counter-clockwise
        for (int r = upperR - 1; r > 0; r--)
            room[r][0] = room[r - 1][0];

        for (int c = 0; c < C - 1; c++)
            room[0][c] = room[0][c + 1];

        for (int r = 0; r < upperR; r++)
            room[r][C - 1] = room[r + 1][C - 1];

        for (int c = C - 1; c > 1; c--)
            room[upperR][c] = room[upperR][c - 1];
        room[upperR][1] = 0;

        // Lower part clockwise
        for (int r = underR + 1; r < R - 1; r++)
            room[r][0] = room[r + 1][0];

        for (int c = 0; c < C - 1; c++)
            room[R - 1][c] = room[R - 1][c + 1];

        for (int r = R - 1; r > underR; r--)
            room[r][C - 1] = room[r - 1][C - 1];

        for (int c = C - 1; c > 1; c--)
            room[underR][c] = room[underR][c - 1];
        room[underR][1] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();

        room = new int[R][C];

        boolean checkOrder = false;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                room[r][c] = sc.nextInt();
                if (room[r][c] == -1) {
                    if (!checkOrder) {
                        upperR = r;
                        checkOrder = true;
                    } else {
                        underR = r;
                    }
                }
            }
        }

        while (T-- > 0) {
            spread();
            operateAirPurifier();
        }

        int sum = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (room[r][c] > 0) {
                    sum += room[r][c];
                }
            }
        }

        System.out.println(sum);
    }
}