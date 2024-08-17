package SWEA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Swea_7699 {
	// 지도를 그래프로 사용한다
	static Character[][] map;
	static boolean[][] v;
	static int R;
	static int C;
	static HashSet<Character> road = new HashSet<>();
	static int max;

	// 0,0 시작점
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			max = Integer.MIN_VALUE;
			road = new HashSet<>();
			R = sc.nextInt();
			C = sc.nextInt();
			sc.nextLine();

			map = new Character[R][C];
			for (int i = 0; i < R; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			v = new boolean[R][C];
			v[0][0] = true;
			road.add(map[0][0]);
			dfs(0, 0);

			System.out.printf("#%d %d\n", test_case, max);
		}

	}

	static void dfs(int r, int c) {
		// 특정한 종결조건이 있을때 만든다
		// basis part
		max = Math.max(max, road.size());

//		System.out.println(road);
		// inductive part
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// nr nc 이동해야될 위치
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc] && !road.contains(map[nr][nc])) {
				v[nr][nc] = true;
				road.add(map[nr][nc]);

				dfs(nr, nc);
				/* 백트래킹 문제 */
				road.remove(map[nr][nc]); // 생 각 못 함
				v[nr][nc] = false;
			}
		}
	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
}
