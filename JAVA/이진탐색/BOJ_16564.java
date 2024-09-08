import java.util.*;

public class BOJ_16564 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N, K;

		N = sc.nextInt();
		K = sc.nextInt();

		int[] X = new int[N];
		for (int i = 0; i < N; i++) {
			X[i] = sc.nextInt();
		}

		Arrays.sort(X);

		int start = X[0];
		int end = X[0] + K;

		int ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (mid > X[i]) {
					sum += mid - X[i];
				}
			}
			if (sum <= K) {
				start = mid + 1;
				ans = mid;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(ans);

	}

}
