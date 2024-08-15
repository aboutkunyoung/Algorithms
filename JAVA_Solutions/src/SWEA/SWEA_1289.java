package SWEA;
import java.util.Scanner;

public class SWEA_1289 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            String data = sc.next();
            int cnt = 0;
            int prev = 0;
            for (int i = 0; i < data.length(); i++) {
                int cur = data.charAt(i) - '0';
                if (prev != cur) {
                    prev = cur;
                    cnt++;
                }
            }
 
            System.out.printf("#%d %d\n", test_case, cnt);
        }
 
    }
 
}