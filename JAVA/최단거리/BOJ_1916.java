package 최단거리;
import java.util.*;

/*인접리스트 구현*/
public class BOJ_1916 {

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

	static int N;

	static ArrayList<Vertex>[] adj;
	static int[] dist;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();

		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList();
		}

		dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		v = new boolean[N];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			adj[a].add(new Vertex(b, c));
		}

		int start = sc.nextInt() - 1;
		int end = sc.nextInt() - 1;

		PriorityQueue<Vertex> Q = new PriorityQueue<>();
		Q.add(new Vertex(start, 0));
		dist[start] = 0;

		while (!Q.isEmpty()) {
			Vertex p = Q.poll();
//			System.out.println("!");

			if (p.Cost > dist[p.Vertex]) {
				continue;
			}

			for (Vertex next : adj[p.Vertex]) {
				int newDist = dist[p.Vertex] + next.Cost;
				if (newDist < dist[next.Vertex]) {
					dist[next.Vertex] = newDist;
					Q.add(new Vertex(next.Vertex, newDist));
				}
			}
		}

		System.out.println(dist[end]);
	}

}
