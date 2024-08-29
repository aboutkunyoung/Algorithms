package BFS_DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_13023 {
	static ArrayList<Integer>[] node;
	static boolean[] v;
	static int ans = 0;
	static int cnt = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		node = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			node[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			node[from + 1].add(to + 1);
			node[to + 1].add(from + 1);
		}

		for (int i = 1; i <= N; i++) {
			cnt = 1;
			v = new boolean[N + 1];
			DFS(i);
		}

		System.out.println(ans);
	}

	private static void DFS(int i) {

		if (cnt == 5) {
			ans = 1;
			return;
		}

		v[i] = true;
		for (int next : node[i]) {
			if (!v[next]) {
				cnt += 1;
				DFS(next);
				cnt -= 1;
				if (ans == 1)
					return;
			}
		}
		v[i] = false;
	}

}
