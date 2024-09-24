import java.io.*;
import java.util.*;

public class BOJ_14503 {

	public static BufferedReader br;
	public static BufferedWriter bw;
	public static StringBuilder sb;
	public static StringTokenizer st;
	public static int N, M;
	public static int[][] map;
	public static int Ans = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int X, Y, D;
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Clean(X, Y, D);
		System.out.println(Ans);
	}

	static int[] dr = { -1, 0, 1, 0 }; // 북 동 남 서
	static int[] dc = { 0, 1, 0, -1 };

	private static void Clean(int X, int Y, int D) {

		if (map[X][Y] == 0) {
			map[X][Y] = 2;
			Ans++;
		}
		// 현재 칸의 주변 4칸 확인
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int moveX = X + dr[i];
			int moveY = Y + dc[i];
			if (moveX >= 0 && moveX < N && moveY < M && moveY >= 0 && map[moveX][moveY] == 0)
				cnt++;
		}

		// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
		if (cnt != 0) {
			D = (D + 3) % 4;
			// 청소하지 않은 칸 만날떄까지 회전시켜주기

			int moveX = X + dr[D];
			int moveY = Y + dc[D];

			while (map[moveX][moveY] != 0) {
				D = (D + 3) % 4;
				moveX = X + dr[D];
				moveY = Y + dc[D];
			}

			if (moveX >= 0 && moveX < N && moveY < M && moveY >= 0 && map[moveX][moveY] == 0) {
				map[moveX][moveY] = 2;
				Ans++;

				Clean(moveX, moveY, D);
			}
		} else { // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			int moveX = X - dr[D];
			int moveY = Y - dc[D];
			if (0 <= moveX && moveX < N && 0 <= moveY && moveY < M && map[moveX][moveY] != 1) {
				// 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
				Clean(moveX, moveY, D);
			} else {
			}
		}

	}

}
