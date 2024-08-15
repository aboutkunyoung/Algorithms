package SWEA;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
 
public class SWEA_1208 {
    public static void main(String[] args) throws FileNotFoundException {
 
        Scanner sc = new Scanner(System.in);
        int T;
 
        for (int test_case = 1; test_case <= 10; test_case++) {
 
            int N = sc.nextInt();
            int[] arr = new int[100];
 
            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }
             
            for (int i = 0; i < N; i++) {
                Arrays.sort(arr);
                 
                arr[0] += 1;
                arr[arr.length-1] -= 1;
                 
            }
            Arrays.sort(arr);
             
            System.out.printf("#%d %d\n", test_case, arr[arr.length-1]-arr[0]);
 
        }
 
    }
}