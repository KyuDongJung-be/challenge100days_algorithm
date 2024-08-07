package algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 바이러스 - DFS
 */
public class BaekJoon_2606 {

    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    public static void dfs(int i) {
        visited[i] = true;
        answer++;

        for(int k = 1; k <= N; k++) {
            if(graph[i][k] && !visited[k]) {
                dfs(k);
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        // 1.graph 연결정보 채우기
        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        int x, y;
        for(int i = 1; i <= N+1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. dfs 재귀함수 호출
        dfs(1);

        // 3. 출력
        bw.write(String.valueOf(answer - 1)); // dfs 1번 자기 자신은 제외, 1번이랑 연결된 노드 갯수 구하기

        bf.close();
        bw.close();
    }
}
