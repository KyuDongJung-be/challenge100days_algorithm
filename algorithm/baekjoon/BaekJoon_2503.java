package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숫자 야구 - 완전탐색
 */
public class BaekJoon_2503 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            String number = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            int[] num = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();

            for(int n = 1; n <= 9; n++) {
                for(int j = 0; j <= 9; j++) {
                    for(int x = 0; x <= 9; x++) {

                    }
                }
            }

        }
    }
}
