package Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9963 {

	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	static StringBuilder sb = null;
	static int N;
	static int[] arr;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		nQueen(0);
		System.out.println(count);
	}

	private static void nQueen(int depth) {
		if (depth == N) {
			count++;
		}
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if (check(depth))
				nQueen(depth + 1);

		}
	}

	public static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[i] == arr[col]) // 이전 퀸들의 "행 위치" 비교
				return false;
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) // 대각선에 위치하면 안된다. 
				return false;
		}

		return true;
	}

}
