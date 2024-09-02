package MST;

import java.util.*;

public class BOJ_1647_Prim {

	static class Edge implements Comparable<Edge> {
		int node;
		int weight;

		Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	static int V, E;
	static int[][] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		List<List<Edge>> graph = new ArrayList<>();
		int mstWeight = 0;
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();

			graph.get(from - 1).add(new Edge(to - 1, weight));
			graph.get(to - 1).add(new Edge(from - 1, weight));
		}

		boolean[] v = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0));
		int last_one = 0;
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			int currentNode = current.node;

			if (v[currentNode])
				continue;

			v[currentNode] = true;
			mstWeight += current.weight;
			last_one = current.weight;
			for (Edge edge : graph.get(currentNode)) {
				if (!v[edge.node]) {
					pq.add(edge);
				}
			}
		}
		System.out.println(mstWeight - last_one);
	}

}
