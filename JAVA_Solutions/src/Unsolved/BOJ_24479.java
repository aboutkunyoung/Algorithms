package Unsolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_24479 {

	static class Node {
		int v;

		Node(int v) {
			this.v = v;
		}

		@Override
		public String toString() {
			return v + " ";
		}
	}

	ArrayList<Node>[] list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		ArrayList<Node>[] list = new ArrayList[6];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList();
		}

		for (int i = 0; i < 5; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[from].add(new Node(to));
		}
		for (int i = 0; i < list.length; i++) {
			list[i].sort();
		}

	}

}
