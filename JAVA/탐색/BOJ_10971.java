package BFS_DFS;

import java.util.*;

public class BOJ_10971 {

	static int N;
	static boolean[] v;
	static int[][] map;
	static int result_min;
	static int cur_node;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			v = new boolean[N];
			result_min = Integer.MAX_VALUE;
			cur_node = i; // 현재 시작 노드 설정
			v[i] = true;
			DFS(i, 0);
			ans = Math.min(ans, result_min); // 최소 비용 갱신
		}
		System.out.println(ans);
	}

	private static void DFS(int V, int cost) {
		if (allVisited()) {
			if (map[V][cur_node] != 0) {
				result_min = Math.min(result_min, cost + map[V][cur_node]);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i] && map[V][i] != 0) {
				v[i] = true;
				DFS(i, cost + map[V][i]);
				v[i] = false;
			}
		}
	}

	public static boolean allVisited() {
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				return false;
			}
		}
		return true;
	}
}
