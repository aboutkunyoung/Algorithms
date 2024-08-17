package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PointXY {
	int row;
	int col;
	int dist;

	PointXY(int row, int col, int dist) {
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
}

public class SWEA_4193 {

	static int[][] arr;
	static int A, B, C, D, N;
	static int rowArr[] = { -1, 0, 1, 0 };
	static int colArr[] = { 0, 1, 0, -1 };
	static boolean[][] v;
	static Queue<PointXY> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int ans;
			N = sc.nextInt();
			arr = new int[N][N];
			v = new boolean[N][N];
			queue = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
			D = sc.nextInt();
			queue.add(new PointXY(A, B, 0));
			v[A][B] = true;
			ans = BFS();
			System.out.printf("#%d %d\n", test_case, ans);
		}

	}

	static int time = 1;

	private static int BFS() {
		while (!queue.isEmpty()) {
			PointXY point = queue.poll();
			int row = point.row;
			int col = point.col;
			int dist = point.dist;

			for (int i = 0; i < 4; i++) {
				int moveRow = row + rowArr[i];
				int moveCol = col + colArr[i];
				if (checkPoint(moveRow, moveCol) == 1) {/* 도착 */
					return point.dist + 1;
				} else if (checkPoint(moveRow, moveCol) == 2) {/* 회오리 만날 경우 */
					if (dist % 3 == 2) {
						v[moveRow][moveCol] = true;
						queue.add(new PointXY(moveRow, moveCol, dist + 1));
					} else {
//                      v[row][col] = true;
						queue.add(new PointXY(row, col, dist + 1));
					}
				} else if (checkPoint(moveRow, moveCol) == 3) {
					v[moveRow][moveCol] = true;
					queue.add(new PointXY(moveRow, moveCol, dist + 1));
				}
			}

		}
		return -1;
	}

	private static int checkPoint(int row, int col) {
		if (row < 0 || row >= N || col < 0 || col >= N || arr[row][col] == 1 || v[row][col]) {
			return -1;
		} else if (row == C && col == D) {
			return 1;
		}
		if (arr[row][col] == 2) {
			return 2;
		} else {
			return 3;
		}
	}
}