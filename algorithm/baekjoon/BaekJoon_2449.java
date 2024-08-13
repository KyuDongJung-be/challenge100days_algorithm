package algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 전구 - DP
 */
public class BaekJoon_2449 {

    final static int INF = 1 << 30;
    static int[] a;
    static int[][] dp;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        10 3
        1 1 2 3 3 3 2 2 1 1
        */

        // 0. 입력 받으며 중복 숫자 제거
        int N = sc.nextInt();
        int K = sc.nextInt();
        a = new int[N + 1];
        dp = new int[N + 1][N + 1];

        for(int i =  1; i <= N; i++) {
            a[i] = sc.nextInt();
            if(a[i] == a[i - 1]) {
                a[i] = 0;
                N--;
                i--;
            }
        }

        // 1. dp 배열 초기화 : i부터 j까지의 전구를 하나로 통일하기 위한 최소 변경 수
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = INF;
            }
            dp[i][i] = 0; // i부터 i까지의 전구를 하나로 통일하기 위한 변경의 수
        }

        // 2. 두 개 이상의 전구들 간의 최솟값 계산
        for (int size = 2; size <= N; size++) {
            for (int start = 1; start <= N - size + 1; start++) {
                int end = start + size - 1;

                // [1,5]
                // [1,1] [2,5] + a[1] vs a[2] 다르면 + 1
                // [1,2] [3,5] + a[1] vs a[3] 다르면 + 1
                // [1,3] [4,5] + a[1] vs a[4] 다르면 + 1
                // [1,4] [5,5] + a[1] vs a[5] 다르면 + 1
                for (int mid = start; mid < end; mid++) {
                    int newValue = dp[start][mid] + dp[mid + 1][end];
                    if (a[start] != a[mid + 1])
                        newValue++;
                    if (dp[start][end] > newValue) // 최소값 찾기
                        dp[start][end] = newValue;
                }
            }

            System.out.println(dp[1][N]); // 중요
            sc.close();
        }
    }
}
