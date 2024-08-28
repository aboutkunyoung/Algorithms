package Tools;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2252 {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		int[] edgeCount = new int[N + 1];

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			graph.get(from).add(to);
			edgeCount[to] += 1;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (edgeCount[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int nodeNo = q.poll();
			System.out.print(nodeNo + " ");

			List<Integer> list = graph.get(nodeNo);

			for (int i = 0; i < list.size(); i++) {
				edgeCount[list.get(i)]--;

				if (edgeCount[list.get(i)] == 0) {
					q.offer(list.get(i));
				}
			}
		}
	}

}
