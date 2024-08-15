package Implementation;

import java.util.Scanner;

public class BOJ_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int P = sc.nextInt();

		for (int i = 0; i < P; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			int cnt = 0;
			if (gender == 1) {
				for (int j = num - 1; j < N; j += num) {
					if (arr[j] == 0) {
						arr[j] = 1;
					} else {
						arr[j] = 0;
					}
				}
			} else if (gender == 2) {
				while (true) {
					int left_idx = num - 1 - cnt - 1;
					int right_idx = num - 1 + cnt + 1;
					if (left_idx < 0 | right_idx >= N) {
						break;
					} else if (arr[left_idx] == arr[right_idx]) {
						cnt += 1;

					} else {
						break;
					}
				}
				for (int j = num - 1 - cnt; j <= num - 1 + cnt; j++) {
					if (arr[j] == 0) {
						arr[j] = 1;
					} else {
						arr[j] = 0;
					}
				}
			}

		}
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
			if ((i + 1) % 20 == 0)
				System.out.println();

		}

	}
}

// 0 1 0 1 0 0 0 1