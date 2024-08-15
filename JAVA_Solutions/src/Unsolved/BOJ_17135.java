package Unsolved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17135 {
	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	static StringBuilder sb = null;
	static int N, M, D;
	static int arr[][];
	static boolean[] v;
	static int[] picked = new int[3];
	static int MAX = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pick(0, 0);
		System.out.println(MAX);
	}

	private static void pick(int cnt, int start) { // 조합 코드
		if (cnt == 3) {
			MAX = Math.max(MAX, game());
//			for (int i = 0; i < 3; i++)
//				System.out.print(picked[i] + " ");
//			System.out.println();
			return;
		}
		for (int i = start; i < M; i++) {
			picked[cnt] = i;
			pick(cnt + 1, i + 1);
		}
	}

	private static int game() {
		int count = 0; // 현재 조합에서 처치한 적의
		int[][] status = new int[N][M]; // 적이 공격 당했는지 상태 기록

		for (int line = N; line > 0; line--) {
			for (int pick : picked) {
				for (int d = 1; d <= D; d++) {
					int cnt = attack(status, d, line, pick);
					if (cnt < 0)
						continue;
					count += cnt;
					break;
				}
			}
		}
		return count;
	}

	private static int attack(int[][] status, int d, int line, int pick) { // d 사거리 line 현재 행 pick 궁수 위치 
		int nn;
		for (int nm = pick - d; nm <= pick + d; nm++) {
			nn = line - (d - Math.abs(nm - pick));
			if (nn < 0 || nn >= line || nm < 0 || nm >= M)
				continue;
			if (arr[nn][nm] == 0)
				continue;
			if (status[nn][nm] == 0) {
				status[nn][nm] = line;
				return 1;
			} else if (status[nn][nm] == line)
				return 0;
		}

		return -1;
	}
}
