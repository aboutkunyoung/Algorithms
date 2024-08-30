package Unsolved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class My_SWEA_2383 {
	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	static StringBuilder sb = null;

	static int[][] stairs = new int[2][3]; // 두 개의 계단 좌표 x, y 계단 길이
	static ArrayList<ArrayList<Integer>> people = new ArrayList<>();
	static int people_size;
	static int ans;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];

			int ct = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] != 0 && arr[i][j] != 1) {
						stairs[ct][0] = i;
						stairs[ct][1] = j;
						stairs[ct][2] = arr[i][j];
						ct++;
					} else if (arr[i][j] == 1) {
						ArrayList<Integer> person = new ArrayList<>();
						person.add(i);
						person.add(j);
						people.add(person);
					}
				}
			}

			people_size = people.size();
			recursive(0, 0, new boolean[people_size]);

			sb.append("#" + test_case + " ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static ArrayList<ArrayList<Integer>> people_stairs1;
	static ArrayList<ArrayList<Integer>> people_stairs2;

	private static void recursive(int idx, int k, boolean[] sel) {
		if (idx == people_size) {
			ans = 0;
			people_stairs1 = new ArrayList<>();
			people_stairs2 = new ArrayList<>();
			for (int i = 0; i < sel.length; i++) {
				ArrayList<Integer> personCopy = new ArrayList<>(people.get(i));
				if (sel[i] == true) {
					int dist = Math.abs(personCopy.get(0) - stairs[0][0]) + Math.abs(personCopy.get(1) - stairs[0][1]);
					personCopy.add(dist);
					people_stairs1.add(personCopy);

				} else {
					int dist = Math.abs(personCopy.get(0) - stairs[1][0]) + Math.abs(personCopy.get(1) - stairs[1][1]);
					personCopy.add(dist);
					people_stairs2.add(personCopy);

				}
			} // PowerSet 생성완료.
			Collections.sort(people_stairs1, new Comparator<ArrayList<Integer>>() {
				@Override
				public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
					return Integer.compare(o1.get(2), o2.get(2));
				}
			});
			Collections.sort(people_stairs2, new Comparator<ArrayList<Integer>>() {
				@Override
				public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
					return Integer.compare(o1.get(2), o2.get(2));
				}
			});
			down();
			if (ans > time) {
				ans = time;
			}
			return;
		}

		sel[idx] = true;
		recursive(idx + 1, k + 1, sel);
		sel[idx] = false;
		recursive(idx + 1, k, sel);
	}

	static int time;

	private static void down() {
		time = 0;

	}

}