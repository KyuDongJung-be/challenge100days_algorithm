package algorithm.programmers;

public class 겹치는선분의길이 {

    public static void main(String[] args) {

        int[][] lines = {{}};
        int solution = solution(lines);
        System.out.println(solution);
    }

    public static int solution(int[][] lines) {

        // arr 배열 초기화 및 변수 초기화
        int answer = 0;
        int[] arr = new int[200];

        // lines 정보를 arr 배열에 적용
        // -100 ≤ a < b ≤ 100 ---> -100 : 0, 0 : 100
        for(int i = 0; i < lines.length; i++) {
            for(int j = lines[i][0] + 100; j < lines[i][1] + 100; j++) {
                arr[j]++; // [0,1] --> arr[100]++, 1에서 끝나니 1은 겹치는 선이 아님
            }
        }

        // arr 배열에서 겹치 부분 제거
        for(int i = 0; i < 200; i++) {
            if(arr[i] > 1) {
                answer++;
            }
        }

        return answer;
    }
}
