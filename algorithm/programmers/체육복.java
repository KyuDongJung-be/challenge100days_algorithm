package algorithm.programmers;

import java.util.HashSet;

public class 체육복 {

    public static void main(String[] args) {

        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};

        int solution = solution(n, lost, reserve);
        System.out.println(solution);

        int solution2 = solution2(n, lost, reserve);
        System.out.println(solution2);
    }

    public static int solution(int n, int[] lost, int[] reserve) {

        // HashSet이용

        // 1. Set을 만든다.
        HashSet<Integer> reserveSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        for(int i : reserve) reserveSet.add(i);
        for(int i : lost) {
            if(reserveSet.contains(i)) reserveSet.remove(i);
            else lostSet.add(i);
        }

        // 2. 여분을 기준으로 앞뒤로 확인하여 체육복을 빌려준다.
        for(int i : reserveSet) {
            if(lostSet.contains(i-1)) lostSet.remove(i-1);
            else if(lostSet.contains(i+1)) lostSet.remove(i+1);
        }

        // 3.전체 학생수에서 lostSet에 남은 학생수를 빼준다.
        return n - lostSet.size();
    }

    public static int solution2(int n, int[] lost, int[] reserve) {

        // Array이용

        // 1. student 배열 생성
        int[] student = new int[n+2];
        int answer = 0;

        // 2. reserve / lost 정보 반영
        for(int i : lost)
            student[i]--;
        for(int i : reserve)
            student[i]++;

        // 3. 여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다.
        // 0번과 n+1 인덱스를 생성하여 -> 분기처리없이 코드를 깔끔하게 만들고, 처음부터 0으로 초기화해서 영향 없음
        for(int i = 1; i <= n; i++) {
            if(student[i] == 1) {
                if(student[i-1] == -1) {
                    student[i]--;
                    student[i-1]++;
                } else if(student[i+1] == -1) {
                    student[i]--;
                    student[i+1]++;
                }
            }
        }

        // 4. 체육복을 갖고 있는 학생수를 계산한다.
        for(int i = 1; i <= n; i++) {
            if(student[i] >= 0) { // 여분이 남은 학생도 고려
                answer++;
            }
        }
        
        return answer;
    }
}
