package algorithm.programmers;

public class 큰수만들기 {

    public static void main(String[] args) {

        String number = "4177252841";
        int k = 4;
        String solution = solution(number, k);
        System.out.println(solution);
    }

    public static String solution(String number, int k) {

        int len = number.length() - k - 1; // return이 몇자리 문자인지
        int startIndex = 0;

        StringBuilder sb = new StringBuilder();

        System.out.println("len ::: " + len);

        while(len >= 0) {
            char max = '0';
            for(int i = startIndex; i < number.length() - len; i++) {
                if(number.charAt(i) > max) {
                    max = number.charAt(i);
                    startIndex = i + 1;
                    if(number.charAt(i) == '9') {
                        break;
                    }
                }

                sb.append(max);
                len--;
            }
        }

        System.out.println(sb.toString());

        return sb.toString();
    }
}
