package 최단거리;
import java.util.*;

public class BOJ_5972 {

	static int N, M;
	static ArrayList<Edge>[] adj;

	static class Edge implements Comparable<Edge> {
		int to, dist;

		public Edge(int to, int d) {
			super();
			this.to = to;
			this.dist = d;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.dist, o.dist);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int d = sc.nextInt();
			adj[from].add(new Edge(to, d));
			adj[to].add(new Edge(from, d));
		}

		System.out.println(getMinTime());
	}

	private static int getMinTime() {

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[0] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0));

		while (!pq.isEmpty()) {
			Edge p = pq.poll();

			if (p.dist > dist[p.to])
				continue;

			for (Edge next : adj[p.to]) {
				int newDist = dist[p.to] + next.dist;
				if (newDist < dist[next.to]) {
					dist[next.to] = newDist;
					pq.add(new Edge(next.to, newDist));
				}
			}
		}
		return dist[N - 1];
	}

}
