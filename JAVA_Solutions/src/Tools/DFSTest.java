package Tools;

import java.util.Arrays;

public class DFSTest {
	// 지도를 그래프로 사용한다
	static int[][] map;
	static boolean[][] v;
	static int N = 4;

	// 0,0 시작점
	public static void main(String[] args) {
		map = new int[N][N];
		v = new boolean[N][N];
		v[0][0] = true;
		// map[0][0]=1;
		dfs(0, 0, 1);
		// print(map);
		System.out.println(tot);
		System.out.println(max);
		System.out.println(min);
	}

	static int tot = 0;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static void dfs(int r, int c, int cnt) {

		map[r][c] = cnt;

		// 현재위치값 r,c
		//
		// 특정한 종결조건이 있을때 만든다
		// basis part
		if (r == N - 1 && c == N - 1) {
			tot++;
			max = Math.max(max, cnt);
			min = Math.min(min, cnt);
			print(map);
			System.out.println("---------------------");
			return;
		}

		// inductive part
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// nr nc 이동해야될 위치
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
				v[nr][nc] = true;
				dfs(nr, nc, cnt + 1);
				map[nr][nc] = 0;
				v[nr][nc] = false;
			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
}
