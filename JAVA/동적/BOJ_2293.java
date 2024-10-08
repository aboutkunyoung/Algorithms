import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		int[] dp = new int[100001];
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for (int j = arr[i]; j <= K; j++) {
				dp[j] = dp[j] + dp[j - arr[i]];
			}
		}

		sb.append(dp[K]);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
