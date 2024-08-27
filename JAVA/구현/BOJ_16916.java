package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16916 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		int N, M, R;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int t = 0; t < R; t++) { // 반복 횟수

			for (int i = 0; i < Math.min(N, M) / 2; i++) { // Math.min(N, M) 이 부분이 핵심
				int temp = arr[i][i];

				// left
				for (int j = i; j < M - 1 - i; j++) {
					arr[i][j] = arr[i][j + 1];
				}

				// up
				for (int j = i; j < N - 1 - i; j++) {
					arr[j][M - 1 - i] = arr[j + 1][M - 1 - i];
				}

				// right
				for (int j = M - i - 1; j > i; j--) {
					arr[N - i - 1][j] = arr[N - i - 1][j - 1];
				}

				// down
				for (int j = N - i - 1; j > i; j--) {
					arr[j][i] = arr[j - 1][i];
				}
				arr[i + 1][i] = temp;

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
