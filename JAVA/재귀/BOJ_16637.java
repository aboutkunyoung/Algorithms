package For_A;

import java.util.Scanner;

public class BOJ_16637 {

	static char[] op;
	static int[] arr;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		op = new char[(N - 1) / 2];
		arr = new int[(N + 1) / 2];

		String str = sc.nextLine();
		int r = 0;
		int c = 0;
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				arr[r++] = Character.getNumericValue(str.charAt(i));
			} else {
				op[c++] = str.charAt(i);
			}
		}
		recursive(0, arr[0]);

		System.out.println(result);
	}

	private static void recursive(int idx, int total) {
		if (idx == op.length) {
			result = Math.max(result, total);
			return;
		}

		int cal = calculate(total, arr[idx + 1], op[idx]);
		recursive(idx + 1, cal);

		if (idx + 2 <= arr.length - 1) {
			cal = calculate(total, calculate(arr[idx + 1], arr[idx + 2], op[idx + 1]), op[idx]);
			recursive(idx + 2, cal);
		}
	}

	private static int calculate(int a, int b, char operator) {
		if (operator == '-')
			return a - b;
		else if (operator == '+')
			return a + b;
		else
			return a * b;
	}
}
