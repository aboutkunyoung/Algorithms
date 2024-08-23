package Recrusive;

import java.util.Scanner;

public class BOJ_14888 {

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] op_arr = new int[4];
		Character[] operator = new Character[N - 1];

		int index = 0;
		for (int i = 0; i < 4; i++) {
			op_arr[i] = sc.nextInt();

			for (int j = 0; j < op_arr[i]; j++) {
				if (i == 0) {
					operator[index++] = '+';
				} else if (i == 1) {
					operator[index++] = '-';
				} else if (i == 2) {
					operator[index++] = '*';
				} else {
					operator[index++] = '/';
				}
			}
		}
		boolean[] v = new boolean[arr.length];
		recursive(operator, new Character[operator.length], 0, v);

		System.out.println(max);
		System.out.println(min);

	}

	static int cnt = 1;

	private static void recursive(Character[] operator, Character[] sel, int k, boolean[] v) {
		if (sel.length == k) {

			for (int i = 0; i <= k; i++) {
//				System.out.print(arr[i]);
//				if (i != k)
//					System.out.print(sel[i]);
			}
			int ans = arr[0];

			for (int i = 0; i < k; i++) {
				ans = calculator(ans, arr[i + 1], sel[i]);
			}
//			System.out.println(" = " + ans);

			if (ans > max) {
				max = ans;
			}
			if (ans < min) {
				min = ans;
			}
			return;
		}

		for (int i = 0; i < operator.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[k] = operator[i];
				recursive(operator, sel, k + 1, v);
				v[i] = false;
			}
		}
	}

	public static int calculator(int a, int b, char op) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		default:
			throw new IllegalArgumentException("Invalid operator. Only +, -, *, / are allowed.");
		}
	}
}
