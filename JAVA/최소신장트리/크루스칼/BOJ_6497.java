package Kruskal;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_6497 {

	static int V, E;
	static int[][] graph;
	static int[] parent;
	static int final_cost;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			V = sc.nextInt();
			E = sc.nextInt();
			if (V == 0 && E == 0) {
				break;
			}
			graph = new int[E][3];
			parent = new int[V];
			int sum = 0;
			for (int i = 0; i < E; i++) {
				graph[i][0] = sc.nextInt();
				graph[i][1] = sc.nextInt();
				graph[i][2] = sc.nextInt();
				sum += graph[i][2];
			}
			final_cost = 0;
			Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

			for (int i = 0; i < V; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < E; i++) {

				if (find(graph[i][0]) != find(graph[i][1])) {
					union(graph[i][0], graph[i][1]);
					final_cost += graph[i][2];
				}
			}
			System.out.println(sum - final_cost);
		}
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
		if (parent[i] == i)
			return i;
		return find(parent[i]);
	}
}
