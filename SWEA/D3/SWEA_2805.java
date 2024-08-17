package SWEA;
import java.util.Scanner;

public class SWEA_2805 {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
  
        int T = sc.nextInt();
  
        for (int test_case = 1; test_case <= T; test_case++) {
  
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
  
            /* 입력 부분길이 제한때문에 스트링으로 받기. */
            for (int i = 0; i < N; i++) {
                String tmp = sc.next();
                int length = tmp.length();
  
                for (int j = 0; j < length; j++) {
                    arr[i][N - length + j] = tmp.charAt(j) - '0'; // 숫자로 변환하여 저장
                }
            }
  
            int ans = 0;
  
      
            for (int i = 0; i <= N / 2; i++) {
                for (int j = N / 2 - i; j <= N / 2 + i; j++) {
                    ans += arr[i][j];
                }
            }
  
            for (int i = N / 2 + 1; i < N; i++) {
                for (int j = i - N / 2; j < N - (i - (N / 2)); j++) {
                    ans += arr[i][j];
                }
            }
  
            System.out.printf("#%d %d\n", test_case, ans);
        }
  
        sc.close();
    }
}