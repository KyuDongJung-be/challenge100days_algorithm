package algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 타겟넘버_BFS {

    static int cnt = 0;
    static int[] numArr, op = {1, -1};
    static class Num {
        int val, cnt;
        public Num(int val, int cnt) {
            this.cnt = cnt;
            this.val = val;
        }
    }
    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int solution = solution(numbers, target);
        System.out.println(solution);
    }

    public static int solution(int[] numbers, int target) {
        //check = new boolean[numbers.length];
        numArr = numbers.clone();
        bfs(numbers.length, target);
        return cnt;
    }

    public static void bfs(int n, int target) {
        Queue<Num> q = new LinkedList<Num>();
        q.add(new Num(0, 0));

        while(!q.isEmpty()) {
            Num num = q.poll();

            if(num.cnt == n) {
                if(num.val == target) cnt++;
                continue;
            }

            for (int i = 0; i < op.length; i++) {
                int val = num.val + numArr[num.cnt] * op[i];
                q.add(new Num(val, num.cnt + 1));
            }
        }
    }
}
