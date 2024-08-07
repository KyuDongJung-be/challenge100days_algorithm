package algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 유기농 배추 - DFS
 */
public class BaekJoon_1012 {

    final static int MAX = 50 + 10;
    static boolean[][] map;
    static boolean[][] visited; // 생략하고 map을 방문한건 false로 바꿔주는 방법도 고려
    static int T, M, N, K;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if(map[newY][newX] && !visited[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bf.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            // 1. map 정보 반영
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                // 1을 더해줘서 0,0 -> 1,1로 변환하면 좋은점 >>> 상하좌우를 찾을때 인덱스 범위를 고려할 필요 없어진다.
                map[y+1][x+1] = true;
            }

            // 2. dfs 수행
            int answer = 0;
            for(int i = 1; i <= N; i++) { // 세로
                for(int j = 1; j <= M; j++) { // 가로
                    if(map[i][j] && !visited[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            // 3. 출력
            bw.write(String.valueOf(answer));
            bw.newLine();

        }

        bw.close();
        bf.close();
    }
}
