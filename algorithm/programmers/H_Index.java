package algorithm.programmers;

import java.util.Arrays;

public class H_Index {

    public static void main(String[] args) {

        int[] citations = {3, 0, 6, 1, 5};
        int solution = solution(citations);
        System.out.println(solution);
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        // 0 1 3 5 6  --> 정렬
        // 0 4 3 2 1  ---> 필요한 논문수
        for(int i = 0; i < citations.length; i++) {
            // citations.length - i; // 인용된 논문의 수
            int minNum = Arrays.copyOfRange(citations, i, citations.length).length;
            System.out.println(citations[i] + " " + minNum);

            if (citations[i] >= minNum) {
                answer = minNum;
                break;
            }
        }

        return answer;
    }
}
