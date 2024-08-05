package algorithm.programmers;

public class 조이스틱 {

    public static void main(String[] args) {

        String name = "";
        int solution = solution(name);
        System.out.println(solution);
    }

    public static int solution(String name) {
        int answer = 0;

        for(int i = 0; i < name.length(); i++){
            // A에서 시작하는 방법, A에서 Z로 갔다가 시작하는 방법
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }
        return answer;
    }
}
