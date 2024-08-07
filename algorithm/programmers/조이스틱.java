package algorithm.programmers;

public class 조이스틱 {

    public static void main(String[] args) {

        String name = "ZYXAAAAAB";
        int solution = solution(name);
        System.out.println(solution);
    }

    public static int solution(String name) {

        // 커서의 방향을 구하는게 핵심
        /*
        커서 위치가 바뀌게 되는 경우는 총 세 가지이다.
        1. 처음부터 쭉 오른쪽으로 가는 경우
        가장 일반적인 경우로 name.length() - 1로 해당한다.
        2. 오른쪽으로 갔다 다시 리턴하여 왼쪽으로 가는 경우
        ex) BBAAAAAYYY 의 경우, BB까지 갔다가 다시 돌아가 YYY를 완성해준다.
        3. 왼쪽으로 갔다 다시 리턴하여 오른쪽으로 가는 경우
        ex) CCCAAAAAAY 의 경우, 처음부터 왼쪽으로 움직여 Y를 완성해주고 다시 오른쪽으로 돌아가 CCC를 완성해준다.
        */

        //'연속된 A' 여부에 따라 좌우 조작 방식이 바뀌게 되는 점을 착안하여 로직을 구현
        //만약 내 다음 알파벳이 'A'라면, 'A'가 끝나는 지점을 구한다.
        /*
        ex) 'ZYXAAAAAB'인 경우
        현재 내 위치는 'X', index : 2 연속된 'A'가 끝나는 지점은 index : 8에 해당한다.
        [1]   index : 0에서 'X'가 있는 2까지 왔다가 다시 0으로 돌아간 후, 왼쪽으로 더 움직여 B를 바꾸는 경우
               즉, ZYXYZB순으로 움직인 경우
               (i * 2) + (name.length() - 연속된 A가 끝나는 지점)
               여기서 i는 현재 내 위치, 즉 'X'의 index이다.
        [2]  index : 0에서 왼쪽으로 움직였다 다시 0으로 온 후, 오른쪽으로 움직인 경우
               즉, ZBZYX순으로 움직인 경우
              (name.length() - 연속된 A가 끝나는 지점) * 2 + i
         */

        int answer = 0;
        int move = name.length() - 1; // 오른쪽으로 쭉 간 횟수

        for(int i = 0; i < name.length(); i++){
            // A에서 시작하는 방법, A에서 Z로 갔다가 시작하는 방법
            // 위아래로 조작했을 때 최소값 구하기
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                // A가 끝나는 지점을 세팅
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A')
                    endA++;
                // 더 짧은 방향을 move에 넣어줌
                move = Math.min(move, i * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
            }
        }

        return answer + move;
    }

    public static int solution2(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            if(i < name.length() - 1 && name.charAt(i+1) == 'A') {
                int endA = i+1;
                while(endA < name.length() && name.charAt(endA) == 'A') {
                    endA++;
                }

                move = Math.min(move, 2 * i + (name.length() - endA)); // 오른쪽 -> 왼쪽
                move = Math.min(move, 2 * (name.length() - endA) + i); // 왼쪽 -> 오른쪽
            }
        }

        return answer + move;
    }
}
