package SWEA;

import java.util.Scanner;

public class SWEA_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			long ans = 0;
			int sellprice = 0;

			int a = sc.nextInt();
			int[] arr = new int[a];
			for (int j = 0; j < a; j++) {
				arr[j] = sc.nextInt();
			}

			for (int j = a - 1; j >= 0; j--) {
				if (sellprice <= arr[j]) {
					sellprice = arr[j];
				} else {
					ans = ans + sellprice - arr[j];
				}
			}
			System.out.printf("#%d %d\n", i, ans);
		}
		//N = 1,000,000 최대값은 10,000이다. 
		//즉, 10,000,000,000

	}

}
