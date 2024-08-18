package Backtracking;

import java.util.Scanner;

public class BOJ_2023 {

	static int[] num;
	public static int N;
	static int[] arr = { 1, 3, 5, 7, 9 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		num = new int[N];

		int[] ini_set = { 2, 3, 5, 7 };

		for (int i = 0; i < 4; i++) {
			num[0] = ini_set[i];
			recursive(arr, new int[N - 1], 0);
		}
	}

	private static void recursive(int[] arr, int[] sel, int k) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				num[i + 1] = sel[i];
			}
			int number = 0;
			for (int n : num) {
				number = number * 10 + n;
			}
			System.out.println(number);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			sel[k] = arr[i];

			int partialNumber = num[0];
			for (int j = 0; j <= k; j++) {
				partialNumber = partialNumber * 10 + sel[j];
			}
			if (isPrime(partialNumber)) {
				recursive(arr, sel, k + 1);
			}
		}

	}

	public static boolean isPrime(int num) {
		if (num < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}