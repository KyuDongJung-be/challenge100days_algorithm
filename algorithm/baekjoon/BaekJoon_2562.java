package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_2562 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.parseInt(bf.readLine());
        int idx = 0;

        for(int i = 1; i < 9; i++) {
            int currNum = Integer.parseInt(bf.readLine());

            if(currNum > max) {
                max = currNum;
                idx = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}
