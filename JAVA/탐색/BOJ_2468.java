package BFS_DFS;

import java.io.*;
import java.util.*;

public class BOJ_2468 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int N, ans;
	static boolean[][] v;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int real_ans = 0;
		for (int t = 0; t <= 100; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (t == map[i][j]) {
						map[i][j] = 0;
					}
				}
			}
			ans = 0;
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (v[i][j] != true && map[i][j] != 0) {
						ans += 1;
						dfs(i, j);
					}
				}
			}

			if (real_ans < ans)
				real_ans = ans;
			if (ans == 0)
				break;
		}
		System.out.println(real_ans);
	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static void dfs(int r, int c) {

		v[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] != 0) {
				dfs(nr, nc);
			}
		}

	}

}
