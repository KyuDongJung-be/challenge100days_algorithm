package algorithm.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class 디스크컨트롤러 {

    public static void main(String[] args) {

        int[][] jobs = {{0, 3},  {2, 6}, {1, 9}};
        // [작업이 요청되는 시점, 작업의 소요시간]
        solution(jobs);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        // 작업의 요청 ~ 종료 시간의 평균이 최소가 되어아햠

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 요청 시간 오름차순

        Arrays.stream(jobs).flatMapToInt(s -> Arrays.stream(s)).forEach(System.out::println);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 소요 시간

        int sec = 0; // 시간
        int idx = 0; // 배열 인덱스
        int cnt = 0; // 요청 수행 갯수

        while(cnt < jobs.length)



        while(!pq.isEmpty()) {
            Arrays.stream(pq.poll()).forEach(System.out::println);
        }

        return answer;
    }
}
