package algorithm.programmers;

import java.util.Arrays;

public class 가장큰수 {

    public static void main(String[] args) {

        //System.out.println(("2" + "10").compareTo("10" + "2")); // 내림차순 1, 양수
        //System.out.println(("10" + "2").compareTo("2" + "10")); // 오름차순 -1, 음수

        int[] numbers = {3, 30, 34, 5, 9};
        String solution = solution(numbers);
        System.out.println(solution);
    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] temp = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        // 두 수를 합친 값이 큰 순서대로(내림차순)
        // o1 : 10, o2 : 2 라면 102와 210중 뭐가 더 큰지 비교
        Arrays.sort(temp, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        Arrays.stream(temp).forEach(System.out::println);

        // 첫번째 수가 0이면 0으로만 이뤄진 배열이므로 0을 리턴
        if(temp[0].equals("0")) {
            return "0";
        }

        return String.join("", temp);
    }
}
