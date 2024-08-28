package For_A;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17281 {
	static int cnt = 0;
	static int max = Integer.MIN_VALUE;
	static int N;
	static int[][] score_board;

	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	static StringBuilder sb = null;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		score_board = new int[N][9];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				score_board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeEntry(0, new int[9], new boolean[9]);
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static void makeEntry(int idx, int[] sel, boolean[] v) {
		if (idx == sel.length) {
			int score = play(sel);
			max = Math.max(max, score);
			return;
		}
		if (idx == 3) {
			sel[idx] = 1;
			makeEntry(idx + 1, sel, v);

		} else {
			for (int i = 2; i <= 9; i++) {
				if (v[i - 1] == false) {
					v[i - 1] = true;
					sel[idx] = i;
					makeEntry(idx + 1, sel, v);
					v[i - 1] = false;
				}

			}
		}
	}

	private static int play(int[] entry) {
		int sum = 0;
		int idx = 0;
		for (int r = 0; r < N; r++) {
			int inningScore = 0;
			int out = 0;
			boolean[] base = new boolean[4];
			while (out < 3) {
				switch (score_board[r][entry[idx] - 1]) {
				case 0: // 아웃
					out++;
					break;
				case 1: // 안타
					if (base[3]) {
						inningScore++;
						base[3] = false;
					}
					if (base[2]) {
						base[3] = true;
						base[2] = false;
					}
					if (base[1]) {
						base[2] = true;
					}
					base[1] = true;
					break;
				case 2: // 2루타
					if (base[3]) {
						inningScore++;
						base[3] = false;
					}
					if (base[2]) {
						inningScore++;
					}
					if (base[1]) {
						base[3] = true;
						base[1] = false;
					}
					base[2] = true;
					break;
				case 3: // 3루타
					if (base[3]) {
						inningScore++;
					}
					if (base[2]) {
						inningScore++;
						base[2] = false;
					}
					if (base[1]) {
						inningScore++;
						base[1] = false;
					}
					base[3] = true;
					break;

				case 4: // 홈런
					if (base[3]) {
						inningScore++;
						base[3] = false;
					}
					if (base[2]) {
						inningScore++;
						base[2] = false;
					}
					if (base[1]) {
						inningScore++;
						base[1] = false;
					}
					inningScore++;
					break;
				}
				idx++;
				if (idx >= 9) {
					idx = 0;
				}
			}
			sum += inningScore;
		}

		return sum;
	}

}
