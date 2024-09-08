import java.io.*;
import java.util.*;

public class BOJ_2647 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		int[] ans_set = new int[2];
		int i, j;
		i = 0;
		j = N - 1;
		int target = Integer.MAX_VALUE;

		while (i < j) {

			int tmp = arr[i] + arr[j];
			if (Math.abs(tmp) < target) {
				target = Math.abs(tmp);
				ans_set[0] = arr[i];
				ans_set[1] = arr[j];
				if (tmp == 0)
					break;
			}

			if (tmp < 0) {
				i += 1;
			} else {
				j -= 1;
			}

		}
		System.out.println(ans_set[0] + " " + ans_set[1]);
	}

}
