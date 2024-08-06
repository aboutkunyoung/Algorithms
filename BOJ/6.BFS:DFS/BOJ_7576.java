package BOJ;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PointXY {
	int row;
	int col;

	public PointXY(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class BOJ_7576 {

	static int N, M, H;
	static int[][] boxes;

	static int rowArr[] = { -1, 0, 1, 0 };
	static int colArr[] = { 0, 1, 0, -1 };
	static boolean[][] v;

	static Queue<PointXY> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // column
		N = sc.nextInt(); // row

		boxes = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boxes[i][j] = sc.nextInt();
				if (boxes[i][j] == 1) {
					queue.add(new PointXY(i, j));
					v[i][j] = true;
				}
			}
		}
		System.out.println(BFS());
	}

	private static int BFS() {
		while (!queue.isEmpty()) {
			PointXY point = queue.poll();
			int row = point.row;
			int col = point.col;

			for (int i = 0; i < 4; i++) {
				int moveRow = row + rowArr[i];
				int moveCol = col + colArr[i];
				if (checkPoint(moveRow, moveCol)) {
					queue.add(new PointXY(moveRow, moveCol));
					boxes[moveRow][moveCol] = boxes[row][col] + 1;
					v[moveRow][moveCol] = true;
				}
			}
		}

		int result = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (boxes[i][j] == 0)
					return -1;
				result = Math.max(result, boxes[i][j]);
			}
		}
		if (result == 1)
			return 0;
		else
			return result - 1;

	}

	private static boolean checkPoint(int row, int col) {
		if (row < 0 || row >= N || col < 0 || col >= M) {
			return false;
		}
		if (!v[row][col] && boxes[row][col] == 0) {
			return true;
		}
		return false;
	}

}
