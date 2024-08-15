package Unsolved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471 {

	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	static StringBuilder sb = null;
	static int N;

	static ArrayList<Integer>[] list;
	static int[] population, area;
	static boolean[] visited;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		population = new int[N + 1];
		list = new ArrayList[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		area = new int[N + 1];
		dfs(1);

 
	}

	private static void dfs(int k) {
		if (k == N + 1) {
			int area1 = 0;
			int area2 = 0;
			for (int i = 1; i <= N; i++) {
				if (area[i] == 1)
					area1 += population[i];
				else if (area[i] == 2)
					area2 += population[i];
			}

			visited = new boolean[N + 1];
			int link = 0;

			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					bfs(i, area[i]);
					link++;
				}
			}

			if (link == 2)
				min = Math.min(min, Math.abs(area1 - area2));
			return;
		}

		area[k] = 1;
		dfs(k + 1);

		area[k] = 2;
		dfs(k + 1);

		area[k] = 0; // Reset area[k] to 0 after recursion
	}

	public static void bfs(int idx, int areaNum) {
		Queue<Integer> q = new LinkedList<>();
		visited[idx] = true;
		q.offer(idx);

		while (!q.isEmpty()) {
			int current = q.poll();

			for (int next : list[current]) {
				if (area[next] == areaNum && !visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
	}
}