package algorithm.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 더맵게 {

    public static void main(String[] args) {

        int[] scoville = {};
        int K = 0;

        solution(scoville, K);

    }

    public static int solution(int[] scoville, int K) {

        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while(!pq.isEmpty()) {

            if(pq.peek() >= K) {
                break;
            }

            if(pq.size() >= 2) {
                answer++;
                int num = pq.poll() + (pq.poll() * 2);
                pq.add(num);
            } else {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
