import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] crane = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			crane[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(crane);

		int M = Integer.parseInt(br.readLine());

		ArrayList<Integer> box = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(box);

//		System.out.println(Arrays.toString(crane));
//		System.out.println(box);
//		System.out.println("-----");

		if (box.get(box.size() - 1) > crane[N - 1]) {
			System.out.println(-1);
			return;
		}

		int time = 0;
		while (!box.isEmpty()) {
			time++;
			int boxIdx = box.size() - 1;
			int craneIdx = N - 1;

			while (craneIdx >= 0 && boxIdx >= 0) {
				if (crane[craneIdx] >= box.get(boxIdx)) {
					craneIdx--;
					box.remove(boxIdx);
					boxIdx--;
				} else if (crane[craneIdx] < box.get(boxIdx)) { // 현재 크레인으로는 못하는 경우니까 탈출 시킨다.
					boxIdx--;
				}
			}

//			System.out.println(box);
//			break;
		}
		sb.append(time);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
