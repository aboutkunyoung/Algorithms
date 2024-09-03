
import java.util.*;

public class BOJ_1504 {

	static class Vertex implements Comparable<Vertex> {
		int Vertex, Cost;

		public Vertex(int vertex, int cost) {
			super();
			Vertex = vertex;
			Cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.Cost, o.Cost);
		}

	}

	static ArrayList<Vertex>[] adj;
	static int[] dist;
	static int N, E;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();

		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			adj[a].add(new Vertex(b, c));
			adj[b].add(new Vertex(a, c));

		}

		int[] via = new int[4];
		via[0] = 0;
		via[3] = N - 1;
		for (int i = 1; i <= 2; i++) {
			via[i] = sc.nextInt() - 1;
		}

		int Ans1 = 0;
		for (int i = 0; i < 3; i++) {
			dist = new int[N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			PriorityQueue<Vertex> Q = new PriorityQueue<>();
			int K = dijkstra(Q, via[i], via[i + 1]);
			if (K == Integer.MAX_VALUE) {
				Ans1 = -1;
				break;
			} else {
				Ans1 += K;
			}
		}

		int Ans2 = 0;
		int tmp = via[2];
		via[2] = via[1];
		via[1] = tmp;

		for (int i = 0; i < 3; i++) {
			dist = new int[N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			PriorityQueue<Vertex> Q = new PriorityQueue<>();
			int K = dijkstra(Q, via[i], via[i + 1]);
			if (K == Integer.MAX_VALUE) {
				Ans2 = -1;
				break;
			} else {
				Ans2 += K;
			}
		}

		if (Ans1 == -1 && Ans2 < -1)
			System.out.println(-1);
		else if (Ans1 == -1 && Ans2 != -1) {
			System.out.println(Ans2);
		} else if (Ans2 == -1 && Ans1 != -1) {
			System.out.println(Ans1);
		} else {
			System.out.println(Ans1 > Ans2 ? Ans2 : Ans1);
		}
	}

	private static int dijkstra(PriorityQueue<Vertex> q, int from, int to) {

		dist[from] = 0;

		q.add(new Vertex(from, 0));

		while (!q.isEmpty()) {
			Vertex p = q.poll(); //
			if (p.Cost > dist[p.Vertex]) {
				continue;
			}

			for (Vertex next : adj[p.Vertex]) {
				int newDist = dist[p.Vertex] + next.Cost;
				if (newDist < dist[next.Vertex]) {
					dist[next.Vertex] = newDist;
					q.add(new Vertex(next.Vertex, newDist));
				}
			}
		}

		return dist[to];
	}
}
