package Unsolved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2146 {

	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	static StringBuilder sb = null;
	static int N, M;
	static int arr[][];
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		Arrays.sort(arr);
//		int[] sel = new int[M];
//		v = new boolean[N];
		sb.append(N + " ");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

}
