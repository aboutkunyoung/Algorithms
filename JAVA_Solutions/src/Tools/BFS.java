package Tools;

import java.util.ArrayDeque;
import java.util.Queue;

class Point {
	int r, c, cnt;

	Point(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class BFS {

	static int N = 10;
	static int[][] map = new int[N][N];
	static boolean[][] v = new boolean[N][N];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bfs();
		print(map);
	}

	private static void bfs() {
		int Sr = 4, Sc = 4;
		int Er = 1, Ec = 1;
		int cnt = 1;
		map[Sr][Sc] = cnt++;
		v[Sr][Sc] = true;

		Queue<Point> Q = new ArrayDeque();
		Q.offer(new Point(Sr, Sc, 0));
		L: while (!Q.isEmpty()) {

//			int size = Q.size();
//			for (int s = 0; s < size; s++) {
			Point p = Q.poll();

			if (p.r == Er && p.c == Ec) {
				// System.out.println(cnt);
				System.out.println(p.cnt);
				map[Er][Ec] = 9;

				break L;
			}
			// 연된결된애들 불러
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] != 7) {
					v[nr][nc] = true;
					// map[nr][nc] = cnt;
					Q.offer(new Point(nr, nc, p.cnt + 1));
				}
			}
//			}
//			cnt++;
		}

	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	private static void print(int[][] map) {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}


/*
private static void bfs(int start) {
    boolean[] visited = new boolean[adjList.length]; // 방문한 노드를 기록할 배열
    Queue<Integer> queue = new ArrayDeque<>(); // BFS를 위한 큐

    queue.add(start); // 시작 노드를 큐에 추가
    visited[start] = true; // 시작 노드를 방문 처리

    while (!queue.isEmpty()) {
        int current = queue.poll(); // 큐에서 노드를 꺼냄
        System.out.print(current + " "); // 현재 노드를 출력

        // 현재 노드의 모든 인접 노드를 탐색
        for (Node neighbor : adjList[current]) {
            if (!visited[neighbor.v]) { // 인접 노드가 방문되지 않았으면
                visited[neighbor.v] = true; // 방문 처리
                queue.add(neighbor.v); // 큐에 추가
            }
        }
    }
    System.out.println(); // BFS 완료 후 줄 바꿈
}

*
*/
