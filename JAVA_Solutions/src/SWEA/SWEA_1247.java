package SWEA;

import java.util.Scanner;

public class SWEA_1247 {

	static int company_x, company_y, home_x, home_y;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			company_x = sc.nextInt();
			company_y = sc.nextInt();
			home_x = sc.nextInt();
			home_y = sc.nextInt();

			int[] arr_x = new int[N];
			int[] arr_y = new int[N];

			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr_x[i] = x;
				arr_y[i] = y;
			}
			boolean[] v = new boolean[N];
			recursive(arr_x, arr_y, new int[N], new int[N], 0, v);
			System.out.printf("#%d %d\n", test_case, ans);
			ans = Integer.MAX_VALUE;

		}
		sc.close();
	}

	private static void recursive(int[] arr_x, int[] arr_y, int[] sel_x, int[] sel_y, int k, boolean[] v) {
		// basis part
		if (k == sel_x.length) {
			int distance = Math.abs(sel_x[0] - company_x) + Math.abs(sel_y[0] - company_y);
			int checker = 0;
			for (int i = 0; i < sel_x.length - 1; i++) {
				distance += Math.abs(sel_x[i + 1] - sel_x[i]) + Math.abs(sel_y[i + 1] - sel_y[i]);
			}
			distance += Math.abs(sel_x[sel_x.length - 1] - home_x) + Math.abs(sel_y[sel_x.length - 1] - home_y);

			if (distance <= ans) {
				ans = distance;
			}

			return;
		}

		// inductive part
		for (int i = 0; i < arr_x.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel_x[k] = arr_x[i];
				sel_y[k] = arr_y[i];
				recursive(arr_x, arr_y, sel_x, sel_y, k + 1, v);
				v[i] = false;
			}
		}

	}

}
