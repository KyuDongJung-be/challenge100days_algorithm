package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_10807 {

    public static void main(String[] args) throws IOException {

        // 내가 푼 방법
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        String[] items = new String[N];
        items= bf.readLine().split(" ");

        st = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(Integer.parseInt(items[i]) == v) cnt++;
        }

        System.out.println(cnt);
    }
}
