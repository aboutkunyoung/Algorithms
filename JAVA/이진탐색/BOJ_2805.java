package BinarySerach;

import java.util.Scanner;

public class BOJ_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M, N;

		N = sc.nextInt();
		M = sc.nextInt();// 가져갈 최소 길이

		int[] arr = new int[N];
		long end = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (end < arr[i])
				end = arr[i];
		}

		long start = 0;
		long mid = (start + end) / 2;
		long result = 0;

		while (start <= end) {
			long getWoods = 0;
			mid = (start + end) / 2;
			for (int i = 0; i < N; i++) {
				if (arr[i] - mid >= 0) {
					getWoods += arr[i] - mid;
				}
			}
			if (getWoods >= M && result < mid) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);

	}

}
