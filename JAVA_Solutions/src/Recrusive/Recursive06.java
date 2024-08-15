package Recrusive;

import java.util.Arrays;

/*
 * 순열 
 * 	중복 x, 순서 o
 */
public class Recursive06 {

	public static void main(String[] args) {
		// 원본배열
		int[] arr = { 1, 3, 5 };
		boolean[] v = new boolean[arr.length];
		// int[] sel = new int[arr.length];

		recursive(arr, new int[arr.length], 0, v);
	}

	private static void recursive(int[] arr, int[] sel, int k, boolean[] v) {
		// basis part
		if (k == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		// inductive part
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