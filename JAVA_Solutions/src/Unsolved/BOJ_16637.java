package Unsolved;

//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class BOJ_16637 {
//
//	static ArrayList<Integer> arr = new ArrayList<Integer>();
//	static ArrayList<Character> op = new ArrayList<Character>();
//	static int[] arrayCom;
//
//	static int N;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		arrayCom = new int[(N - 1) / 2];
//		for (int i = 0; i < (N - 1) / 2; i++) {
//			arrayCom[i] = i;
//		}
//		sc.nextLine();
//		String str = sc.nextLine();
//
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
//				arr.add(Integer.valueOf(str.charAt(i) - '0'));
//			} else {
//				op.add(str.charAt(i));
//			}
//		}
//
//		boolean[] v = new boolean[arrayCom.length];
//		recursive(arrayCom, new int[arrayCom.length], 0, v);
//
////		System.out.println(arr.toString());
////		System.out.println(op.toString());
//	}
//
//	private static void recursive(int[] arrayCom, int[] sel, int k, boolean[] v) {
//		// basis part
//		if (k == sel.length) {
//			Calculator(sel);
//			return;
//		}
//
//		// inductive part
//		for (int i = 0; i < arrayCom.length; i++) {
//			if (v[i] == false) {
//				v[i] = true;
//				sel[k] = arrayCom[i];
//				recursive(arrayCom, sel, k + 1, v);
//				v[i] = false;
//			}
//		}
//	}
//
//	public static void Calculator(int[] arrayCom) {
//		for (int i = 0; i < arrayCom.length; i++) { // 연산의 횟수 만큼
//			int num1 = arr.get(i);
//			int num2 = arr.get(i);
//			char operator = op.get(arrayCom[i]);
//		}
//	}
//
//	public static int calculate(char operator, int num1, int num2) {
//		int result = 0;
//
//		switch (operator) {
//		case '+':
//			result = num1 + num2;
//			break;
//		case '-':
//			result = num1 - num2;
//			break;
//		case '*':
//			result = num1 * num2;
//			break;
//		}
//		return result;
//	}
//
//}
///*
// * 9 3+8*7-9*2
// */

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_16637 {

    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static ArrayList<Character> op = new ArrayList<Character>();
    static int[] arrayCom;
    static int N;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arrayCom = new int[(N - 1) / 2];
        for (int i = 0; i < (N - 1) / 2; i++) {
            arrayCom[i] = i;
        }
        sc.nextLine();
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                arr.add(Integer.valueOf(str.charAt(i) - '0'));
            } else {
                op.add(str.charAt(i));
            }
        }

        boolean[] v = new boolean[arrayCom.length];
        recursive(arrayCom, new int[arrayCom.length], 0, v);

        System.out.println(maxResult);
    }

    private static void recursive(int[] arrayCom, int[] sel, int k, boolean[] v) {
        // basis part
        if (k == sel.length) {
            Calculator(sel);
            return;
        }

        // inductive part
        for (int i = 0; i < arrayCom.length; i++) {
            if (v[i] == false) {
                v[i] = true;
                sel[k] = arrayCom[i];
                recursive(arrayCom, sel, k + 1, v);
                v[i] = false;
            }
        }
    }

    public static void Calculator(int[] arrayCom) {
        ArrayList<int []> sel = new ArrayList<>();
       
		for (int i = 0; i < arrayCom.length; i++) { // 연산의 횟수 만큼
			System.out.print(arrayCom[i]);
		}
			
    }

    public static int calculate(char operator, int num1, int num2) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
        }
        return result;
    }
}
