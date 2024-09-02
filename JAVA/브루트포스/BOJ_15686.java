package Implementation;

import java.util.*;

public class BOJ_15686 {

	static ArrayList<int[]> chicken;
	static ArrayList<int[]> house;
	static int N, M;
	static int Ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		chicken = new ArrayList<>();
		house = new ArrayList<>();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					chicken.add(new int[] { i, j });
				} else if (map[i][j] == 1) { // house
					house.add(new int[] { i, j });
				}
			}
		}
		recursive(new int[M], 0, 0);

		System.out.println(Ans);
	}

	static int Cnt = 0;

	static ArrayList<int[]> alive_chicken;

	private static void recursive(int[] sel, int idx, int k) {

		if (k == sel.length) {
			Cnt++;
			alive_chicken = new ArrayList<>();
			for (int i = 0; i < sel.length; i++) {
				int[] tmp = chicken.get(sel[i]).clone();
				alive_chicken.add(tmp);
			}
			int Count = chickenGame();

			if (Count < Ans) {
				Ans = Count;
			}

			return;
		}
		if (idx == chicken.size()) { // idx end point error!!!!!!!!!
			return;
		}

		sel[k] = idx;
		recursive(sel, idx + 1, k + 1);
		recursive(sel, idx + 1, k);
	}

	private static int chickenGame() {
		int allDistance = 0;

		for (int i = 0; i < house.size(); i++) {

			int size = Integer.MAX_VALUE;

			for (int j = 0; j < alive_chicken.size(); j++) {
				if (size > (Math.abs(house.get(i)[0] - alive_chicken.get(j)[0])
						+ Math.abs(house.get(i)[1] - alive_chicken.get(j)[1]))) {
					size = (Math.abs(house.get(i)[0] - alive_chicken.get(j)[0])
							+ Math.abs(house.get(i)[1] - alive_chicken.get(j)[1]));
				}
			}
			allDistance += size;

		}
		return allDistance;
	}

}
