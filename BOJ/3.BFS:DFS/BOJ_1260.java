package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {

	static int N, M;
	static ArrayList<Integer>[] node;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		node = new ArrayList[N + 1];
		v = new boolean[N + 1];
		// 인접 리스트 구현
		for (int i = 1; i <= N; i++) {
			node[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			node[from].add(to);
			node[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(node[i]);
		}

		DFS(V);
		Arrays.fill(v, false);
		System.out.println();
		BFS(V);
	}

	private static void DFS(int V) {
		if (v[V]) {
			return;
		}
		v[V] = true;
		System.out.print(V + " ");
		for (int next : node[V]) {
			if (!v[next]) {
				DFS(next);
			}
		}
	}

	private static void BFS(int V) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		v[V] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			for (int next : node[current]) {
				if (!v[next]) {
					queue.add(next);
					v[next] = true;
				}
			}
		}
	}

}
