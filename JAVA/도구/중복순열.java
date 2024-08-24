package Recrusive;

import java.util.Arrays;

public class 중복순열 {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5 };
		int[] sel = new int[arr.length];
//		boolean[] v = new boolean[arr.length];
		recursive(arr, new int[arr.length], 0);
	}

	private static void recursive(int[] arr, int[] sel, int k) {
		if (k == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			sel[k] = arr[i];
			recursive(arr, sel, k + 1);
		}

	}

}
