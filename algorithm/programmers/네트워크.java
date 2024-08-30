package algorithm.programmers;

public class 네트워크 {

    static int num;
    public static void main(String[] args) {

        /**
         * 1번 노드부터 각 노드에서 연결되어 있는 모든 노드를 최대한 탐색한 후, 더 이상 연결된 노드가 없으면 탐색을 종료한다.
         * 탐색을 종료하면 answer의 값을 1 증가시킨 후, 다음 노드에 연결된 노드들을 모두 탐색하는 동일한 과정을 진행한다.
         * 더 이상 탐색할 노드가 없으면 알고리즘을 종료한 후 정답을 return 한다.
         */
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int solution = solution(n, computers);
        System.out.println(solution);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        num = 0;

        /* 모든 컴퓨터를 살펴보며 네트워크에 연결되어있는 컴퓨터는 true 처리하며 개수 세기 */
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(n, computers, visited, i);
                num++;
            }
        }

        answer = num;
        return answer;
    }

    public static void dfs(int n, int[][] computers, boolean[] visited, int i){
        visited[i] = true;

        // 연결되어있다면 타고 들어가기
        for(int j = 0; j < n; j++){
            if(computers[i][j] == 1 && !visited[j] && j != i){
                dfs(n, computers, visited, j);
            }
        }
    }
}
