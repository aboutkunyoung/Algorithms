package BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loc {
	int row;
	int col;
	int cnt;
	boolean destroyed;

	public Loc(int row, int col, int cnt, boolean destroyed) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.destroyed = destroyed;
	}
}

public class BOJ_2206 {

	public static int N, M;
	public static int[][] box;
	public static boolean[][] v;

	public static ArrayList<int[]> list = new ArrayList<>();
	public static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		BFS();
	}

	static int rowArr[] = { -1, 0, 1, 0 };
	static int colArr[] = { 0, 1, 0, -1 };

	private static void BFS() {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(0, 0, 1, false));

		boolean[][][] visited = new boolean[N][M][2];

		while (!q.isEmpty()) {
			Loc now = q.poll();

			if (now.row == N - 1 && now.col == M - 1) {
				System.out.println(now.cnt);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int ni = now.row + rowArr[d];
				int nj = now.col + colArr[d];

				if (ni < 0 || ni >= N || nj < 0 || nj >= M)
					continue;

				int next_cnt = now.cnt + 1;
				if (map[ni][nj] == '0') {
					if (!now.destroyed && !visited[ni][nj][0]) {
						q.add(new Loc(ni, nj, next_cnt, false));
						visited[ni][nj][0] = true;
					} else if (now.destroyed && !visited[ni][nj][1]) {
						q.add(new Loc(ni, nj, next_cnt, true));
						visited[ni][nj][1] = true;
					}

				} else if (map[ni][nj] == '1') {

					if (!now.destroyed) {
						q.add(new Loc(ni, nj, next_cnt, true));
						visited[ni][nj][1] = true;
					}
				}
			}
		}
		System.out.println(-1);

	}
}