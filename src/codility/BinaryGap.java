package codility;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(solution(74901729));
    }

    static int solution(int N) {
        int answer = 0;

        String binary = Integer.toBinaryString(N);

        String[] splited = binary.split("");

        boolean flag = false;
        int binaryGap = 0;
        for (String s : splited) {
            if (!flag && s.equals("1")) {
                flag = true;
            } else if (flag && s.equals("1")) {
                if (binaryGap > answer) {
                    answer = binaryGap;
                }
                binaryGap = 0;
            } else if (flag && s.equals("0")) {
                binaryGap++;
            }
        }

        return answer;
    }
}
