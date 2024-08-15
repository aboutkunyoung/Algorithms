package SWEA;

import java.util.Scanner;
import java.util.Stack;
 
public class SWEA_5432 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        sc.nextLine();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.nextLine();
            char[] charArray = str.toCharArray();
            int sum = 0;
            Stack<Character> stack = new Stack<>();
 
            int cnt = 1;
 
            for (int i = 0; i < str.length(); i++) // .length는 속성(for 숫자 배열) .length()는 메소드 문자열 길이
                if (charArray[i] == ')') {
                    if (charArray[i - 1] == '(') {
                        stack.pop();
                        sum += stack.size();
//                      System.out.println("H" + sum);
 
                    } else {
                        stack.pop();
                        sum+=1;
                    }
                } else {
                    stack.push(charArray[i]);
                }
 
            System.out.println("#"+test_case+" "+sum);
        }
 
    }
}
