package Implementation;

import java.util.Scanner;

public class BOJ_16918 {

	static int company_x, company_y, home_x, home_y;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt(); // time
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		sc.nextLine();
		char[][] prev_arr = new char[R][C];
		char[][] next_arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < C; j++) {
				next_arr[i][j] = tmp.charAt(j);
			}
		} // insert

		for (int t = 2; t <= N; t++) { // N cho
			// copy to previous
			if (t % 2 == 0) { // 설치
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						prev_arr[i][j] = next_arr[i][j];
						next_arr[i][j] = 'O';
					}
				}

			} else { // 폭발
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (prev_arr[i][j] == 'O') {
							next_arr[i][j] = '.';
							for (int dir = 0; dir < 4; dir++) {
								if ((i + dx[dir] >= 0 && i + dx[dir] < R) && (j + dy[dir] >= 0 && j + dy[dir] < C)) { // 경계값 설정 잘하
									next_arr[i + dx[dir]][j + dy[dir]] = '.';
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(next_arr[i][j]);
			}
			System.out.println();
		}

		sc.close();

	}

}
