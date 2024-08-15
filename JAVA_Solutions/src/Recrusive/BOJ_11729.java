package Recrusive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_11729 {

	static int K = 0;

	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	static StringBuilder sb = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		BigInteger bi = new BigInteger("2");
		BigInteger c = bi.pow(N).subtract(BigInteger.ONE);
		System.out.println(c);

		if (N <= 20) {
			Hannoi(N, 1, 3, 2);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	static void Hannoi(int N, int start, int end, int mid) {
		if (N == 1) {
			sb.append(start + " " +end + "\n");
			return;
		}
		Hannoi(N - 1, start, mid, end);
		sb.append(start + " " +end + "\n");
		Hannoi(N - 1, mid, end, start);
	}

}
