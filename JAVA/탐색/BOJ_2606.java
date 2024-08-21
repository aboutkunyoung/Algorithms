package BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606 {

	static int N, M;
	static ArrayList<Integer>[] node;
	static boolean[] v;

	public static void main(String[] arges) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		node = new ArrayList[N + 1];
		v = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			node[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			node[from].add(to);
			node[to].add(from);
		}

		BFS(1);

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (v[i] == true) {
				cnt += 1;
			}
		}
		System.out.println(cnt - 1);
	}

	private static void BFS(int N) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		v[N] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : node[current]) {
				if (!v[next]) {
					queue.add(next);
					v[next] = true;
				}
			}
		}
	}

}
