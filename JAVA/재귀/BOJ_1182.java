package Greedy;

import java.util.Scanner;

public class BOJ_1182 {

	public static int[] arr;
	public static int N, S;
	public static int Count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		recursive(0, 0);
		System.out.println(S == 0 ? Count - 1 : Count);
	}

	private static void recursive(int idx, int sum) {
		if (idx == arr.length) {
			if (sum == S) {
				Count++;
			}
			return;
		}

		recursive(idx + 1, sum + arr[idx]);
		recursive(idx + 1, sum);
	}

}
