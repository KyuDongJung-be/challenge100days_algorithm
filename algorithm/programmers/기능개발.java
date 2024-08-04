package algorithm.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] solution = solution(progresses, speeds);
        System.out.println(solution);
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answerList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            int date = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            if(!queue.isEmpty() && queue.peek() < date) {
                answerList.add(queue.size());
                queue.clear();
            }

            queue.offer(date);
        }

        answerList.add(queue.size());

        int[] answer = new int[answerList.size()];

        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
