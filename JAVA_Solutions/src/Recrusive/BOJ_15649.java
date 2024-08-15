package Recrusive;

import java.util.Scanner;

public class BOJ_15649 {

	public static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int[] arr = new int[N];
		boolean[] v = new boolean[arr.length];

		for (int i = 0; i < N; i++)
			arr[i] = i + 1;

		recursive(arr, new int[M], 0, v);
	}

	private static void recursive(int[] arr, int[] sel, int k, boolean[] v) {

		if (k == sel.length) {
//			System.out.println(Arrays.toString(sel));
//			System.out.println(sel.length);
			for(int i=0;i<sel.length;i++){
				System.out.print(sel[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<arr.length;i++){
			if (v[i] == false) {
				v[i] = true;
				sel[k] = arr[i];
				recursive(arr, sel, k + 1, v);
				v[i] = false;
			}
		}

	}

}
