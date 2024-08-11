package algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 정렬
 */
public class K번째수 {

    public static void main(String[] args) {

        int[] array ={};
        int[][] commands = {};
        int[] solution = solution(array, commands);

    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // 1번째 풀이
        for(int i = 0; i < commands.length; i++) {
           ArrayList<Integer> list = new ArrayList<>();

           for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
               list.add(array[j]);
           }

           Collections.sort(list);

           answer[i] = list.get(commands[i][2] - 1);
        }

        // 2번째 풀이
        for(int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }
}
