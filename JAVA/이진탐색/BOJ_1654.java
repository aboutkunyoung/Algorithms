package BinarySerach;

import java.util.*;

public class BOJ_1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K, N;

		K = sc.nextInt();
		N = sc.nextInt();

		int[] arr = new int[K];
		long end = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			if (end < arr[i])
				end = arr[i];
		}
		long start = 1;
		long result = 0;

		while (start <= end) {

			long mid = (start + end) / 2;
			long cnt = 0;

			for (int i = 0; i < K; i++) {
				cnt += arr[i] / mid;
			}

			if (cnt >= N) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}

}
