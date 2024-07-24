package SWEA;

import java.util.HashSet;
import java.util.Scanner;
 
public class SWEA_1974 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T;
        T = sc.nextInt();
 
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
 
        for (int test_case = 1; test_case <= T; test_case++) {
 
            int arr[][] = new int[9][9];
 
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int flag = 1;
            for (int i = 1; i <= 7; i += 3) {
                for (int j = 1; j <= 7; j += 3) {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(arr[i][j]);
                    for (int dir = 0; dir < 8; dir++)
                        set.add(arr[i + dx[dir]][j + dy[dir]]);
                    if (set.size() != 9) {
                        flag = 0;
                        break;
                    }
                }
            }
            for (int i = 0; i < 9; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    set.add(arr[i][j]);
                }
                if (set.size() != 9) {
                    flag = 0;
                    break;
                }
            }
             
            for (int i = 0; i < 9; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    set.add(arr[j][i]);
                }
                if (set.size() != 9) {
                    flag = 0;
                    break;
                }
            }
             
            System.out.printf("#%d %d\n", test_case, flag);
             
        }
 
    }
}


