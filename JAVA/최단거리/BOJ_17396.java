package 최단거리;
import java.util.*;

public class BOJ_17396 { // 17396

	
	/*
	 * 정점의 개수 10만 / 간선의 개수 30만 / 간선의 비용 10만 (10만 -1) x 100,000 = 9,999,900,000
	 * Integer 범위 벗어남
	 */
	static class Vertex implements Comparable<Vertex> {
		int Vertex;
		long Cost;

		public Vertex(int vertex, long cost) {
			super();
			Vertex = vertex;
			Cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			if (this.Cost > o.Cost)
				return 1;
			else {
				return -1;
			}
		}
	}

	static int N, M;
	static ArrayList<Vertex>[] adj;
	static long[] dist;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		adj = new ArrayList[N];
		int[] cv = new int[N];

		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList();
			cv[i] = sc.nextInt();
		}

		dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);

		v = new boolean[N];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if ((a != N - 1 && cv[a] == 1) || (b != N - 1 && cv[b] == 1))
				continue;
			adj[a].add(new Vertex(b, c));
			adj[b].add(new Vertex(a, c));

		}

//		for (int i = 0; i < adj.length; i++) {
//			for (Vertex t : adj[i]) {
//				System.out.println("i : " + i + "Node: " + t.Vertex + ", Cost: " + t.Cost);
//			}
//		}
		// 다익스트라 짜기

		dist[0] = 0;
		PriorityQueue<Vertex> Q = new PriorityQueue<>();
		Q.add(new Vertex(0, 0));

		while (!Q.isEmpty()) {
			Vertex p = Q.poll();

			if (p.Cost > dist[p.Vertex]) {
				continue;
			}

			for (Vertex next : adj[p.Vertex]) {
				long newCost = dist[p.Vertex] + next.Cost;
				if (dist[next.Vertex] > newCost) {
					dist[next.Vertex] = newCost;
					Q.add(new Vertex(next.Vertex, newCost));
				}
			}
		}
		if (dist[N - 1] == Long.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dist[N - 1]);
	}

}
