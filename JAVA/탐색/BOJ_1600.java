package BFS_DFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PointXY {
	int row;
	int col;
	int dist;
	int used;

	public PointXY(int row, int col, int dist, int used) {
		this.row = row;
		this.col = col;
		this.dist = dist;
		this.used = used;
	}
}

public class BOJ_1600 {

	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	static StringBuilder sb = null;
	public static int W, H, N;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		BFS();
	}

	static int rowArr[] = { -1, 0, 1, 0 };
	static int colArr[] = { 0, 1, 0, -1 };
	static int h_rowArr[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int h_colArr[] = { -2, -1, 1, 2, -2, -1, 1, 2 };

	private static void BFS() {
		Queue<PointXY> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[H][W][N + 1];

		q.add(new PointXY(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			PointXY point = q.poll();
			int row = point.row;
			int col = point.col;
			int used = point.used;
			int dist = point.dist;

			if (row == H - 1 && col == W - 1) {
				System.out.println(point.dist);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int moveRow = row + rowArr[i];
				int moveCol = col + colArr[i];

				if (moveRow < 0 || moveRow >= H || moveCol < 0 || moveCol >= W) {
					continue;
				}
				if (visited[moveRow][moveCol][used]) {
					continue;
				}
				if (arr[moveRow][moveCol] != 1) {
					visited[moveRow][moveCol][used] = true;
					q.add(new PointXY(moveRow, moveCol, dist + 1, used));
				}
			}
			if (used < N) {
				for (int i = 0; i < 8; i++) {
					int moveRow = row + h_rowArr[i];
					int moveCol = col + h_colArr[i];

					if (moveRow < 0 || moveRow >= H || moveCol < 0 || moveCol >= W) {
						continue;
					}
					if (visited[moveRow][moveCol][used + 1]) {
						continue;
					}
					if (arr[moveRow][moveCol] != 1) {
						visited[moveRow][moveCol][used + 1] = true;
						q.add(new PointXY(moveRow, moveCol, dist + 1, used + 1));
					}
				}
			}

		}
		System.out.println(-1);
	}

}