package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class adjacencyMatrix {
	static int[][] adjMat = new int[7][7];
	static boolean[] v = new boolean[7];

	public static void main(String[] args) {

		adjMat[1][2] = 1;
		adjMat[1][3] = 1;
		adjMat[1][4] = 1;
		adjMat[2][5] = 1;
		adjMat[2][6] = 1;
		// 무방향을 위해서 반대로도 설정해준다
		adjMat[2][1] = 1;
		adjMat[3][1] = 1;
		adjMat[4][1] = 1;
		adjMat[5][2] = 1;
		adjMat[6][2] = 1;

		bfs(1);

		dfs(1);
	}

	private static void dfs(int curr) {
		if (v[curr]) {
			return;
		}
		v[curr] = true;
		System.out.print(curr + " ");
		for (int i = 0; i < adjMat.length; i++) {
			if (adjMat[curr][i] == 1 && !v[i]) { // 인접 노드이고 방문하지 않은 경우
				dfs(i); // 재귀 호출
			}
		}

	}

	private static void bfs(int curr) {
		boolean[] visited = new boolean[7]; // 방문한 노드를 기록할 배열
		Queue<Integer> queue = new ArrayDeque<>(); // BFS를 위한 큐

		queue.add(curr); // 시작 노드를 큐에 추가
		visited[curr] = true; // 시작 노드를 방문 처리

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			for (int i = 1; i < 7; i++) {
				if (adjMat[current][i] == 1 && !visited[i]) { // 인접 노드이고 방문하지 않은 경우
					visited[i] = true; // 방문 처리
					queue.add(i); // 큐에 추가
				}
			}
		}
		System.out.println();
	}
}
