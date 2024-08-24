package Recrusive;

import java.util.Arrays;

public class 순열 {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5 };
		// int[] sel = new int[arr.length];
		boolean[] v = new boolean[arr.length];
		recursive(arr, new int[arr.length], 0, v);

	}

	private static void recursive(int[] arr, int[] sel, int k, boolean[] v) {
		if (sel.length == k) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[k] = arr[i];
				recursive(arr, sel, k + 1, v);
				v[i] = false;
			}
		}

	}

}