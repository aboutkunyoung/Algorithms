package Implementation;

import java.util.Scanner;

public class BOJ_2564{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 가로 길이
		int M = sc.nextInt(); // 세로 길이
		int T = sc.nextInt(); // 상점의 수

		int[] arr = new int[T * 2];

		for (int i = 0; i < T * 2; i++) {
			arr[i] = sc.nextInt();
		}
		int x = sc.nextInt(); // 동근이의 위치
		int y = sc.nextInt();
		int real_ans = 0;

		for (int i = 0; i < T * 2; i += 2) {
			int ans = 0;

			if (x == 1) {
				if (arr[i] == 1) {
					ans = Math.abs(y - arr[i + 1]);
				} else if (arr[i] == 2) {
					ans = M + Math.min(y + arr[i + 1], (N - y) + (N - arr[i + 1]));
				} else if (arr[i] == 3) {
					ans = arr[i + 1] + y;
				} else if (arr[i] == 4) {
					ans = N - y + arr[i + 1];
				}
			} else if (x == 2) {
				if (arr[i] == 1) {
					ans = M + Math.min(y + arr[i + 1], (N - y) + (N - arr[i + 1]));
				} else if (arr[i] == 2) {
					ans = Math.abs(y - arr[i + 1]);
				} else if (arr[i] == 3) {
					ans = y + M - arr[i + 1];
				} else if (arr[i] == 4) {
					ans = N - y + M - arr[i + 1];
				}

			} else if (x == 3) {
				if (arr[i] == 1) {
					ans = arr[i + 1] + y;
				} else if (arr[i] == 2) {
					ans = M - y + arr[i + 1];
				} else if (arr[i] == 3) {
					ans = Math.abs(y - arr[i + 1]);
				} else if (arr[i] == 4) {
					ans = N + Math.min(y + arr[i + 1], M - y + M - arr[i + 1]);
				}
			} else if (x == 4) {
				if (arr[i] == 1) {
					ans = N - arr[i + 1] + y;
				} else if (arr[i] == 2) {
					ans = M - y + N - arr[i + 1];
				} else if (arr[i] == 3) {
					ans = N + Math.min(y + arr[i + 1], M - y + M - arr[i + 1]);
				} else if (arr[i] == 4) {
					ans = Math.abs(y - arr[i + 1]);
				}
			}
			real_ans += ans;
		}
		System.out.println(real_ans);
	}
}
