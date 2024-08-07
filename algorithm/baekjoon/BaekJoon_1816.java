package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 암호 키 - 완전탐색
 */
public class BaekJoon_1816 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int number = Integer.parseInt(st.nextToken());

            for(int k  = 2; k <= 1000000; k++) {
                if(number % k == 0) { // 100만 이하의 약수가 존재한다.
                    System.out.println("NO");
                    break;
                }

                if(k == 1000000) { // 100만 이하의 약수가 존재하지 않는다.
                    System.out.println("YES");
                }
            }
        }
    }
}
