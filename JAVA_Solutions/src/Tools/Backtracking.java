package Tools;

import java.util.Arrays;

public class Backtracking {
	static int cnt;

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5 };
		// exhaustive(arr,new int[arr.length],0);
		backTracking(arr, new int[arr.length], 0, new boolean[arr.length]);
		System.out.println(cnt);
	}

	private static void backTracking(int[] arr, int[] sel, int k, boolean[] v) {
		// basis part
		if (k == sel.length) {
			cnt++;
			System.out.println(Arrays.toString(sel));
			return;
		}
		// inductive part
		for (int i = 0; i < sel.length; i++) {
			// prunning (가지치기)
			if (v[i])
				continue; // arr 의 index 가 사용이 됬다면 파생시키지 안는다
			v[i] = true;
			sel[k] = arr[i];
			backTracking(arr, sel, k + 1, v);
			v[i] = false;
		}
	}
	private static void exhaustive(int[] arr, int[] sel, int k) {
		// basis part
		if (k == sel.length) {
			cnt++;

			// 중복된 값이 있는 배열을 빼자
			boolean[] ckeck = new boolean[1024];
			for (int i = 0; i < sel.length; i++) {
				if (ckeck[sel[i]])
					return;
				ckeck[sel[i]] = true;
			}
			System.out.println(Arrays.toString(sel));
			return;
		}
		// inductive part
		for (int i = 0; i < sel.length; i++) {
			sel[k] = arr[i];
			exhaustive(arr, sel, k + 1);
		}
	}
}
