package Unsolved;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt(); // time
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		sc.nextLine();
		char[][] initial_arr = new char[R][C];
		char[][] first_boom_arr = new char[R][C];
		char[][] second_boom_arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < C; j++) {
				initial_arr[i][j] = tmp.charAt(j);
				first_boom_arr[i][j] = 'O';
				second_boom_arr[i][j] = 'O';
			}
		}

		// First explosion calculation
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (initial_arr[i][j] == 'O') {
					first_boom_arr[i][j] = '.';
					for (int dir = 0; dir < 4; dir++) {
						int ni = i + dx[dir];
						int nj = j + dy[dir];
						if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
							first_boom_arr[ni][nj] = '.';
						}
					}
				}
			}
		}

		// Second explosion calculation
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (first_boom_arr[i][j] == 'O') {
					second_boom_arr[i][j] = '.';
					for (int dir = 0; dir < 4; dir++) {
						if (i + dx[dir] >= 0 && i + dx[dir] < R && j + dy[dir] >= 0 && j + dy[dir] < C) {
							second_boom_arr[i + dx[dir]][j + dy[dir]] = '.';
						}
					}
				}
			}
		}

		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print('O');
				}
				System.out.println();
			}
		} else if (N == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(initial_arr[i][j]);
				}
				System.out.println();
			}
		} else if (N % 4 == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(second_boom_arr[i][j]);
				}
				System.out.println();
			}
		} else if (N % 4 == 3) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(first_boom_arr[i][j]);
				}
				System.out.println();
			}

		}

		sc.close();
	}

}
