//package SWEA;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//import Unsolved.PointXY;
//
//class PointXY {
//	int row;
//	int col;
//
//	PointXY(int row, int col) {
//		this.row = row;
//		this.col = col;
//	}
//}
//
//public class SWEA_4192 {
//
//	static int[][] arr;
//	static int A, B, C, D, N;
//	static int rowArr[] = { -1, 0, 1, 0 };
//	static int colArr[] = { 0, 1, 0, -1 };
//	static boolean[][] v;
//	static Queue<PointXY> queue;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//
//		for (int test_case = 1; test_case <= T; test_case++) {
//			int ans;
//			N = sc.nextInt();
//			arr = new int[N][N];
//			v = new boolean[N][N];
//			queue = new LinkedList<>();
//
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					int tmp = sc.nextInt();
//					if (tmp == 1) {
//						arr[i][j] = -1;
//					}
//
//				}
//			}
//			A = sc.nextInt();
//			B = sc.nextInt();
//			C = sc.nextInt();
//			D = sc.nextInt();
//
//			ans = BFS();
//
//			System.out.printf("#%d %d\n", test_case, ans);
//		}
//
//	}
//
//	private static int BFS() {
//		queue.add(new PointXY(A, B));
//		v[A][B] = true;
//
//		while (!queue.isEmpty()) {
//			PointXY point = queue.poll();
//			int row = point.row;
//			int col = point.col;
//
//			for (int i = 0; i < 4; i++) {
//				int moveRow = row + rowArr[i];
//				int moveCol = col + colArr[i];
//				if (checkPoint(moveRow, moveCol)) {
//					queue.add(new PointXY(moveRow, moveCol));
//					arr[moveRow][moveCol] = arr[row][col] + 1;
//					v[moveRow][moveCol] = true;
//					if (moveRow == C && moveCol == D)
//						return arr[moveRow][moveCol];
//				}
//			}
//		}
//		return -1;
//	}
//
//	private static boolean checkPoint(int row, int col) {
//		if (row < 0 || row >= N || col < 0 || col >= N || arr[row][col] == -1) { /* 범위 밖 + 장애물 만나는 케이스 */
//			return false;
//		} else if (!v[row][col] && arr[row][col] == 0) { /* 갈 수 있는 곳 */
//			return true;
//		} else {
//			return false;
//		}
//
//	}
//}
