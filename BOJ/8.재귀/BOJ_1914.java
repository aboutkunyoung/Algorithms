package BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1914 {

	static int K = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		BigInteger big = new BigInteger("2");
		BigInteger c = big.pow(N).subtract(BigInteger.ONE);
		System.out.println(c);

		if (N <= 20) {
			Hannoi(N, 1, 3, 2);
		}

	}

	static void Hannoi(int N, int start, int end, int mid) {
		if (N == 1) {
			System.out.println(start + " " + end);
			return;
		}
		Hannoi(N - 1, start, mid, end);
		System.out.println(start + " " + end);
		Hannoi(N - 1, mid, end, start);
	}

}
