package 최단거리;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Road {
	int start;
	int end;
	int distance;

	public Road(int from, int to, int weight) {
		super();
		this.start = from;
		this.end = to;
		this.distance = weight;
	}

}

public class BOJ_1446 {

	static int[] dist;
	static int D, E;
	static ArrayList<Road> road = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		E = sc.nextInt(); // 간선 개수
		D = sc.nextInt(); // 정점 개수 5

		int[] distance = new int[D + 1];
		Arrays.fill(distance, 10001);

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt(); 
			int e = sc.nextInt();
			int d = sc.nextInt();

			if (e > D || e - s <= d) {
				continue;
			}
			road.add(new Road(s, e, d));

		} // 원복해보기

		Collections.sort(road, (n1, n2) -> {
			if (n1.start != n2.start) {
				return Integer.compare(n1.start, n2.start);
			} else {
				return Integer.compare(n1.end, n2.end);
			}
		});
		int arrayIdx = 0;
		int location = 0; //현 위치
		distance[0] = 0;

		/*
		 * 0 50 10
		   0 50 20
           50 100 10
		 */
		while (location < D) {
			if (arrayIdx < road.size()) {
				Road r = road.get(arrayIdx);
				if (r.start == location) {
					distance[r.end] = Math.min(distance[r.end], distance[location] + r.distance);
					arrayIdx++;
					continue;
				}
			}
			distance[location + 1] = Math.min(distance[location + 1], distance[location] + 1);
			location++;
		}
		System.out.println(distance[D]);

	}

}