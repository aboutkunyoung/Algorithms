package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class adjacencyList {
	static class Node {
		int v;

		Node(int v) {
			this.v = v;
		}

		@Override
		public String toString() {
			return v + " ";
		}

	}

	static ArrayList<Node>[] adjList = new ArrayList[7];
	static boolean[] v = new boolean[7];

	public static void main(String[] args) {

		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList();
		}

		adjList[1].add(new Node(2));
		adjList[1].add(new Node(3));
		adjList[1].add(new Node(4));
		adjList[2].add(new Node(5));
		adjList[2].add(new Node(6));
		// 단방향
		adjList[2].add(new Node(1));
		adjList[3].add(new Node(1));
		adjList[4].add(new Node(1));
		adjList[5].add(new Node(2));
		adjList[6].add(new Node(2));
		// 양방향
		bfs(1);

		dfs(1);

	}

	private static void dfs(int i) {
		if (v[i]) {
			return;
		}
		v[i] = true;
		System.out.print(i + " ");
		for (Node neighbor : adjList[i]) {
			if (!v[neighbor.v])
				dfs(neighbor.v);
		}

	}

	private static void bfs(int i) {
		boolean[] visited = new boolean[adjList.length]; // 방문한 노드를 기록할 배열

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(i);
		visited[i] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");

			for (Node neighbor : adjList[current]) {
				if (!visited[neighbor.v]) {
					visited[neighbor.v] = true;
					queue.add(neighbor.v);
				}
			}
		}
		System.out.println();
	}
}
