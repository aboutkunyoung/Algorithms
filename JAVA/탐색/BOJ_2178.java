package BFS_DFS;

import java.io.*;
import java.util.*;

public class BOJ_2178 {

	static int N, M;
	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	static StringBuilder sb = null;
	static int[][] arr;
	static int val = 1;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
//				arr[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
//				arr[i][j] = Integer.parseInt("" + str.charAt(i));
			}
		}

		visited = new boolean[N][M];
		visited[0][0] = true;
		BFS();

	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	private static void BFS() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, 1 });

		while (!q.isEmpty()) {
			int[] item = q.poll();

			if (item[0] == N - 1 && item[1] == M - 1) {
				System.out.println(item[2]);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int move_x = item[0] + dr[i];
				int move_y = item[1] + dc[i];
				int val = item[2] + 1;
				if (move_x < 0 || move_x >= N || move_y < 0 || move_y >= M || arr[move_x][move_y] != 1
						|| visited[move_x][move_y])
					continue;
				q.offer(new int[] { move_x, move_y, val });
				visited[move_x][move_y] = true;
			}
		}
	}
}
