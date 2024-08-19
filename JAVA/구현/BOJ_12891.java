package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12891 {

	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;
	static StringBuilder sb = null;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		Character[] strArr = new Character[str.length()];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			strArr[i] = ch;
		}

		st = new StringTokenizer(br.readLine());

		int[] minRequired = new int[4];
		minRequired[0] = Integer.parseInt(st.nextToken()); // A
		minRequired[1] = Integer.parseInt(st.nextToken()); // C
		minRequired[2] = Integer.parseInt(st.nextToken()); // G
		minRequired[3] = Integer.parseInt(st.nextToken()); // T
		int validPasswords = 0;
		int[] currentCount = { 0, 0, 0, 0 };

		/* 초기 */
		for (int i = 0; i < P; i++) {
			if (strArr[i] == 'A') {
				currentCount[0]++;
			} else if (strArr[i] == 'C') {
				currentCount[1]++;
			} else if (strArr[i] == 'G') {
				currentCount[2]++;
			} else if (strArr[i] == 'T') {
				currentCount[3]++;
			}
		}
		int flag = 1;
		for (int j = 0; j < 4; j++) {
			if (minRequired[j] > currentCount[j]) {
				flag = 0;
				break;
			}
		}
		if (flag == 1)
			validPasswords += 1;

		for (int i = 0; i < S - P; i++) {

			if (strArr[i] == 'A') {
				currentCount[0]--;
			} else if (strArr[i] == 'C') {
				currentCount[1]--;
			} else if (strArr[i] == 'G') {
				currentCount[2]--;
			} else if (strArr[i] == 'T') {
				currentCount[3]--;
			}

			if (strArr[i + P] == 'A') {
				currentCount[0]++;
			} else if (strArr[i + P] == 'C') {
				currentCount[1]++;
			} else if (strArr[i + P] == 'G') {
				currentCount[2]++;
			} else if (strArr[i + P] == 'T') {
				currentCount[3]++;
			}

			flag = 1;
			for (int j = 0; j < 4; j++) {
				if (minRequired[j] > currentCount[j]) {
					flag = 0;
					break;
				}
			}
			if (flag == 1)
				validPasswords += 1;

		}

		bw.write(validPasswords + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
