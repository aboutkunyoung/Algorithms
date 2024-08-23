package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931 {

	public static class Room {
		int start;
		int end;

		Room(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Room[] arr = new Room[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new Room(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(arr, new Comparator<Room>() {
			@Override
			public int compare(Room r1, Room r2) {
				if (r1.end == r2.end) {
					return Integer.compare(r1.start, r2.start);
				} else {
					return Integer.compare(r1.end, r2.end);
				}
			}
		});
		int end_time = arr[0].end;

		int count = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i].start >= end_time) {
				count += 1;
				end_time = arr[i].end;
			}
		}

		System.out.println(count);
	}

}
