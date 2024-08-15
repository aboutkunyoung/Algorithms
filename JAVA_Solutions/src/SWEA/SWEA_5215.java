package SWEA;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_5215 {

	public static int ans_kcal = 0;
	public static int ans_score = 0;
	public static int L = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			int N = sc.nextInt();
			L = sc.nextInt();

			for (int i = 0; i < N; i++) {
				int score = sc.nextInt();
				int kcal = sc.nextInt();
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(score);
				tmp.add(kcal);
				list.add(tmp);
			}
			boolean[] sel = new boolean[list.size()];

			recursive(list, 0, 0, sel);

			System.out.printf("#%d %d\n", test_case, ans_score);
			ans_kcal = 0;
			ans_score = 0;
		}
	}

	private static void recursive(ArrayList<ArrayList<Integer>> list, int idx, int k, boolean[] sel) {
		if (idx == list.size()) {
			int local_score = 0;
			int local_kcal = 0;
			for (int i = 0; i < sel.length; i++) {
				if (sel[i] == true) {
					local_score += list.get(i).get(0);
					local_kcal += list.get(i).get(1);
				}
			}
			// System.out.println("Local_score =" + local_score + " local_kcal = " +
			// local_kcal);

			if (local_kcal <= L && local_score >= ans_score) {

				ans_kcal = local_kcal;
				ans_score = local_score;
			}
			return;
		}
		sel[idx] = true;
		recursive(list, idx + 1, k + 1, sel);

		sel[idx] = false;
		recursive(list, idx + 1, k, sel);

	}

}
