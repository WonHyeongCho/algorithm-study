package codility;

import java.util.Arrays;
import java.util.HashMap;

public class Distinct {

    public static void main(String[] args) {
//        int[] A = new int[]{2, 1, 1, 2, 3, 1};
        int[] A = new int[]{};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        HashMap<Integer, Boolean> numberMap = new HashMap<Integer, Boolean>();

        for(int number : A) {
            if(!numberMap.containsKey(number)) {
                numberMap.put(number, true);
            }
        }

        return numberMap.size();
    }


    // Performance 에러... 스트림을 쓰면 안될듯
//    private static int solution(int[] A) {
//        return (int) Arrays.stream(A).distinct().count();
//    }
}
