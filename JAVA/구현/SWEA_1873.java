package SWEA;

import java.util.Scanner;

public class SWEA_1873 {

	static int T, H, W, x, y, d;
	static char[][] map;
	static int[][] dir = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 동서남북
	
	static int[] dx = {0, 0, 0, 1, -1};
	static int[] dy = {0, 1, -1, 0, 0}; //제자리, 위 아래 오른 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			H = sc.nextInt();
			W = sc.nextInt();

			map = new char[H][W];

			x = 0; //위
			y = 0;
			
			d = 0; // 1: 동, 2: 서, 3: 남, 4: 북
			
			
			//insert
			for (int i = 0; i < H; i++) {
				String st = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = st.charAt(j);

					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						if (map[i][j] == '^')
							d = 4;
						else if (map[i][j] == 'v')
							d = 3;
						else if (map[i][j] == '<')
							d = 2;
						else if (map[i][j] == '>')
							d = 1;
						x = i;
						y = j;
					}
				}
			}
			

			int N = sc.nextInt();

			String str = sc.next();

			for (int i = 0; i < N; i++) {
				char cur = str.charAt(i);
				int nx, ny;

				if (cur == 'U' || cur == 'D' || cur == 'L' || cur == 'R') { //MOVING
					if (cur == 'U') {
						d = 4;
						map[x][y] = '^';
					} else if (cur == 'D') {
						d = 3;
						map[x][y] = 'v';
					} else if (cur == 'L') {
						d = 2;
						map[x][y] = '<';
					} else if (cur == 'R') {
						d = 1;
						map[x][y] = '>';
					}
					//{ { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 동서남북
					nx = x + dir[d][0];
					ny = y + dir[d][1];

					if (isInside(nx, ny)) {
						if (map[nx][ny] == '.') {
							map[nx][ny] = map[x][y];
							map[x][y] = '.';
							x = nx;
							y = ny;
						}
					}
				} else if (cur == 'S') {// SHOOTING
					nx = x;
					ny = y;

					while (true) {
						nx += dir[d][0];
						ny += dir[d][1];
						if (!isInside(nx, ny) || map[nx][ny] == '#')//강철 
							break;
						else if (map[nx][ny] == '*') {//벽돌 
							map[nx][ny] = '.';//평
							break;
						}
					}
				}
			}

			// print
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	public static boolean isInside(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
}