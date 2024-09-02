package MST;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1647_Kruskal {

	static int V, E;
	static int[][] graph;
	static int[] parent;
	static int final_cost;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		graph = new int[E][3];
		parent = new int[V];

		for (int i = 0; i < E; i++) {
			graph[i][0] = sc.nextInt();
			graph[i][1] = sc.nextInt();
			graph[i][2] = sc.nextInt();
		}
		final_cost = 0;
		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

//		for (int i = 0; i < E; i++) {
//			System.out.println(graph[i][0] + " " + graph[i][1] + " " + graph[i][2]);
//
//		}
//		System.out.println(Arrays.toString(graph));
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
		int memo = 0;

		for (int i = 0; i < E; i++) {
			if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
				union(graph[i][0] - 1, graph[i][1] - 1);
				memo = graph[i][2];
				final_cost += graph[i][2];
			}
		}
		System.out.println(final_cost - memo);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int find(int i) {
		if (parent[i] == i) {
			return i;
		} else {
			return find(parent[i]);
		}
	}
}
