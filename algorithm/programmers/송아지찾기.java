package algorithm.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS
 */
public class 송아지찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        /**
         * 5 14 3
         * 8 3 5
         */

        int s = Integer.parseInt(st.nextToken()); // 시작점
        int e = Integer.parseInt(st.nextToken()); // 송아지 위치

        int bfs = bfs(s, e);
        System.out.println(bfs);
    }

    private static int bfs(int s, int e) {
        int[] distance = {-1, 1, 5}; // 한번의 점프로 이동하는 거리
        boolean[] checked = new boolean[10001]; // 중복되는 좌표를 걸러내기위해(직선의 좌표는 1~10000)

        int level = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);

        while(!q.isEmpty()) {
            int len = q.size();

            for(int i = 0; i < len; i++) {
                int n = q.poll();

                for(int j : distance) {
                    int n2 = n + j;

                    if(n2 == e) {
                        return level + 1;
                    }

                    if(n2 >= 1 && n2 <= 10000 && !checked[n2]) {
                        checked[n2] = true;
                        q.offer(n2);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
