package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BaekJoon_10818 {

    public static void main(String[] args) throws IOException {

        // 1. 시간초과
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
//        int N = Integer.parseInt(st.nextToken());
//
//        String[] items = bf.readLine().split(" ");
//        // 오름차순 정렬
//        Arrays.sort(items, ((o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2)));
//
//        System.out.println(items[0]);
//        System.out.println(items[N-1]);

        // 2. 시간통과
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] itmes = new int[N];

        String[] strings = bf.readLine().split(" ");

        for(int i = 0; i < itmes.length; i++) {
            itmes[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(itmes);
        System.out.print(itmes[0] + " " + itmes[N - 1]);
    }
}
