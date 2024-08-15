package BFS_DFS;

import java.util.Scanner;

public class BOJ_4963 {

	static int W;
	static int H;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int ans = 0;
			W = sc.nextInt();
			H = sc.nextInt();

			if (W == 0 && H == 0) {
				break;
			}
			if (W == 1 && H == 1) {
				int a = sc.nextInt();
				if (a == 0)
					System.out.println(0);
				else
					System.out.println(1);
				continue;
			}
			map = new int[H][W];
			v = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (v[i][j] != true && map[i][j] != 0) {
						ans += 1;
						dfs(i, j);
					}
				}
			}

			System.out.println(ans);
		}
	}

	static int[] dr = { 1, 0, -1, 0, 1, -1, 1, -1 };
	static int[] dc = { 0, 1, 0, -1, 1, -1, -1, 1 };

	static void dfs(int r, int c) {

		v[r][c] = true;

		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < H && nc >= 0 && nc < W && !v[nr][nc] && map[nr][nc] != 0) {
				dfs(nr, nc);

			}
		}

	}

}