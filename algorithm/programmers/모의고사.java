package algorithm.programmers;

import java.util.*;

class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] result = new int[3];
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int cnt = answers.length;
        
        one = Arrays.copyOfRange(one, 0, cnt);
        two = Arrays.copyOfRange(two, 0, cnt);
        three = Arrays.copyOfRange(three, 0, cnt);
        
        for(int i = 0; i < cnt; i++) {
            if(one[i] == answers[i]) result[0]++;
            if(two[i] == answers[i]) result[1]++;
            if(three[i] == answers[i]) result[2]++;
        }
        
        /*
        for(int i = 0; i < answers.length; i++) {
            if(one[i % one.length] == answers[i]) result[0]++;
            if(two[i % two.length] == answers[i]) result[1]++;
            if(three[i % three.length] == answers[i]) result[2]++;
        }
        */
        
        int max = Arrays.stream(result).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < result.length; i++) {
            if(max == result[i]) {
                list.add(i+1);
            }
        }
        
        int[] result2 = new int[list.size()];
        for(int i = 0; i < result2.length; i++) {
            result2[i] = list.get(i);
        }
        
        return result2;
    }
}
