package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2017 연세대학교 프로그래밍 경시대회 - 완전탐색
 */
public class BaekJoon_14568 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int candy = Integer.parseInt(st.nextToken());

        int answer = 0;
        for(int i = 1; i <= candy; i++) {
            for(int j = 1; j <= candy; j++) {
                for(int x = 1; x <= candy; x++) {
                    if(i + j + x == candy) {
                        if(i >= j + 2) {
                            if(x % 2 == 0) {
                                answer++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
