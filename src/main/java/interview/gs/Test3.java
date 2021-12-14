package interview.gs;

/*
run length encoding

INPUT = "AABBBCDDD"

OUTOUT = "A2B3C1D3"

 */

public class Test3 {

    public static String solution(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        if (input.length() == 1) {
            return input + "1";
        }

        int count = 1;
        StringBuffer sb = new StringBuffer("");

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                sb.append(input.charAt(i)).append(count);
                count = 1;
            }
        }
        sb.append(input.charAt(input.length() - 1)).append(count);
        return sb.toString();
    }

    public static void main(String[] args) {
        String testString = "AAABAA";
        System.out.println(Test3.solution(testString));
    }
}
