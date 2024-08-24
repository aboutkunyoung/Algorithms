package Recrusive;

public class 조합 {

	static int arr[] = { 1, 3, 5, 6 };

	public static void main(String[] args) {

//		boolean[] v = new boolean[2];
		int[] sel = new int[2];
		recursive(0, 0, sel);
	}

	private static void recursive(int idx, int k, int[] sel) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		if (idx == arr.length) {
			return;
		}

		sel[k] = arr[idx];
		recursive(idx + 1, k + 1, sel);
		recursive(idx + 1, k, sel);

	}

}
