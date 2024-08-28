package Implementation;

import java.util.Scanner;

public class BOJ_1913 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] arr = new int[N][N];

		int x, y;
		x = (N - 1) / 2;
		y = (N - 1) / 2;
		int num = 1;
		arr[x][y] = num++;

//		int flag = 0;
//		int i = 0;
//		int dir = 1;
//		while (num <= N * N) {
//			// i가 0 이나 2를 만나면
//			if (flag == dir) {
//				i += 1;
//				flag = 0;
//				if (i == 4)
//					i = 0;
//				if (i == 0 || i == 2) {
//					dir++;
//				}
//			}
//			flag++;
//
//			x += dx[i];
//			y += dy[i];
//			arr[x][y] = num++;
//		}
		int direction = 0;
		int stepCount = 0;
		int stepsInCurrentDirection = 1;

		while (num <= N * N) {
			if (stepCount == stepsInCurrentDirection) {
				stepCount = 0;
				direction = (direction + 1) % 4;
				if (direction % 2 == 0) {
					stepsInCurrentDirection++;
				}
			}
			x += dx[direction];
			y += dy[direction];
			arr[x][y] = num++;
			stepCount++;
		}

		int ans_x = 0;
		int ans_y = 0;
		for (int k = 0; k < N; k++) {
			for (int p = 0; p < N; p++) {
				System.out.print(arr[k][p] + " ");
				if (arr[k][p] == M) {
					ans_x = k;
					ans_y = p;
				}
			}
			System.out.println();
		}
		System.out.println(ans_x + 1 + " " + (ans_y + 1));
	}

}
