package SWEA;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6730 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int up_max = 0;
			int down_max = 0;

			for (int i = 0; i < N - 1; i++) {
				int val = arr[i] - arr[i + 1];
				if (val < 0) {
					if (up_max < val * -1) {
						up_max = val * -1;
					}
				} else if (val > 0) {
					if (down_max < val) {
						down_max = val;
					}
				}

			}

			System.out.printf("#%d %d %d\n", test_case, up_max, down_max);

		}

	}
}
