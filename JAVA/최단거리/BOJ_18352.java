package 최단거리;

import java.util.*;

public class BOJ_18352 {

	static ArrayList<Integer>[] adj;
	static int[] dist;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M, K, X;
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();

		adj = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList();

		}
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			adj[from].add(to);
		}

		dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

		dist[X - 1] = 0;
		pq.add(new int[] { 0, X - 1 });

		while (!pq.isEmpty()) {
			int[] current = pq.poll();

			int d = current[0];
			int u = current[1];

			if (d > dist[u])
				continue;

			for (int next : adj[u]) {
				int newDist = dist[u] + 1;
				if (newDist < dist[next]) {
					dist[next] = newDist;
					pq.add(new int[] { newDist, next });
				}
			}
//			System.out.println(Arrays.toString(dist));
		}
		boolean found = false;
		for (int i = 0; i < N; i++) {
			if (dist[i] == K) {
				System.out.println(i + 1);
				found = true;
			}
		}

		if (!found) {
			System.out.println(-1);
		}
	}

}
