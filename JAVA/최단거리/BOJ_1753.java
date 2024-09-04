package 최단거리;
import java.util.*;

public class BOJ_1753 {
	static class Vertex implements Comparable<Vertex> {
		int e, w;

		Vertex(int e, int w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static int V, E, S;
	static ArrayList<Vertex>[] adj;
	static int[] dist;
	static boolean[] v;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		S = sc.nextInt() - 1;

		adj = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList();
		}

		dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);

		v = new boolean[V];

		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a - 1].add(new Vertex(b - 1, c));
		}

		PriorityQueue<Vertex> Q = new PriorityQueue<>();
		Q.add(new Vertex(S, 0));
		dist[S] = 0;

		while (!Q.isEmpty()) {
			Vertex p = Q.poll();

			if (p.w > dist[p.e]) {
				continue;
			}

			for (Vertex next : adj[p.e]) {
				int newDist = dist[p.e] + next.w;
				if (newDist < dist[next.e]) {
					dist[next.e] = newDist;
					Q.add(new Vertex(next.e, newDist));
				}
			}
		}

		for (int i = 0; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

		sc.close();
	}
}
