package Unsolved;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17070 {
	static int[][] arr;
	static int Count = 0;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		DFS(0, 1, 0);
		System.out.println(Count);
	}

	static int[] garo_x = { 0, 1 };
	static int[] garo_y = { 1, 1 };
	static int[] sero_x = { 1, 1 };
	static int[] sero_y = { 0, 1 };
	static int[] coro_x = { 0, 1, 1 };
	static int[] coro_y = { 1, 0, 1 };

	private static void DFS(int x, int y, int status) {

		if (x == N - 1 && y == N - 1) {
			Count += 1;
			return;
		}

		if (status == 0) { // 가로
			for (int i = 0; i < 2; i++) {
				int move_x = x + garo_x[i];
				int move_y = y + garo_y[i];

				if (i == 0 && move_y < N && arr[move_x][move_y] == 0) {
					DFS(move_x, move_y, 0);
				}
				if (i == 1 && move_x < N && move_y < N && arr[move_x][move_y] == 0 && arr[move_x][y] == 0
						&& arr[x][move_y] == 0) {
					DFS(move_x, move_y, 2);
				}
			}
		} else if (status == 1) { // 세로
			for (int i = 0; i < 2; i++) {
				int move_x = x + sero_x[i];
				int move_y = y + sero_y[i];

				if (i == 0 && move_x < N && arr[move_x][move_y] == 0) {
					DFS(move_x, move_y, 1);
				}
				if (i == 1 && move_x < N && move_y < N && arr[move_x][move_y] == 0 && arr[move_x][y] == 0
						&& arr[x][move_y] == 0) {
					DFS(move_x, move_y, 2);
				}
			}
		} else if (status == 2) { // 대각선
			for (int i = 0; i < 3; i++) {
				int move_x = x + coro_x[i];
				int move_y = y + coro_y[i];

				if (i == 0 && move_y < N && arr[move_x][move_y] == 0) {
					DFS(move_x, move_y, 0);
				} else if (i == 1 && move_x < N && arr[move_x][move_y] == 0) {
					DFS(move_x, move_y, 1);
				}
				if (i == 2 && move_x < N && move_y < N && arr[move_x][move_y] == 0 && arr[move_x][y] == 0
						&& arr[x][move_y] == 0) {
					DFS(move_x, move_y, 2);
				}
			}
		}

	}

}