package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PointXYZ {
    int height;
    int row;
    int col;

    public PointXYZ(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }
}

public class BOJ_7569 {

    static int N, M, H;
    static int[][][] boxes;
    static boolean[][][] v;  // Changed to boolean[][][] for visited tracking

    static int rowArr[] = { -1, 0, 1, 0, 0, 0 };
    static int colArr[] = { 0, 1, 0, -1, 0, 0 };
    static int heightArr[] = { 0, 0, 0, 0, 1, -1 };

    static Queue<PointXYZ> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // column
        N = sc.nextInt(); // row
        H = sc.nextInt(); // height

        boxes = new int[H][N][M];
        v = new boolean[H][N][M];  // Initialize visited array

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    boxes[i][j][k] = sc.nextInt();
                    if (boxes[i][j][k] == 1) {
                        queue.add(new PointXYZ(i, j, k));
                        v[i][j][k] = true;  // Mark as visited
                    }
                }
            }
        }

        System.out.println(BFS());
    }

    private static int BFS() {
        while (!queue.isEmpty()) {
            PointXYZ point = queue.poll();
            int height = point.height;
            int row = point.row;
            int col = point.col;

            for (int i = 0; i < 6; i++) {
                int moveHeight = height + heightArr[i];
                int moveRow = row + rowArr[i];
                int moveCol = col + colArr[i];
                if (checkPoint(moveHeight, moveRow, moveCol)) {
                    queue.add(new PointXYZ(moveHeight, moveRow, moveCol));
                    boxes[moveHeight][moveRow][moveCol] = boxes[height][row][col] + 1;
                    v[moveHeight][moveRow][moveCol] = true;  // Mark as visited
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (boxes[i][j][k] == 0)
                        return -1;
                    result = Math.max(result, boxes[i][j][k]);
                }
            }
        }
        if (result == 1)
            return 0;
        else
            return result - 1;
    }

    private static boolean checkPoint(int height, int row, int col) {
        if (height < 0 || height >= H || row < 0 || row >= N || col < 0 || col >= M) {
            return false;
        }
        if (!v[height][row][col] && boxes[height][row][col] == 0) {
            return true;
        }
        return false;
    }
}
