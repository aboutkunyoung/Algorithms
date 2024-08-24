package Recrusive;

/*
 * 부분집합
 */
public class 부분집합 {
	// 원본배열
	static int[] arr = { 1, 3, 5 }; // {{1}, {3}, {5}, {1 3}, {1 5}, {3 5}, {1 3 5}}
	// 선택배열
	// static int[] sel = new int[3];

	public static void main(String[] args) {

		boolean[] sel = new boolean[arr.length];
		recursive(0, 0, sel);
	}

	// idx : 원본배열의 순서값, k 선택한 갯수
	private static void recursive(int idx, int k, boolean[] sel) {
		// basis part (반복의 횟수)
		if (idx == arr.length) {
			// System.out.println(Arrays.toString(sel));
			if (k == 0) {
				for (int i = 0; i < sel.length; i++) {

					if (sel[i] == true) {
						System.out.print(arr[i] + " ");
					}
				}
				System.out.println();
			}
			return;
		}

		// inductive part(하나의 반복의 순간에 발생할수 있는 모든 경우)
		// 선택하는 경우
		sel[idx] = true;
		recursive(idx + 1, k + 1, sel);
		// 선택하지 안는 경우
		sel[idx] = false;
		recursive(idx + 1, k, sel);
	}
}
