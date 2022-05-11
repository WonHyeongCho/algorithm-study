package codility;

import java.util.*;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] A = {10001, 4, 6, 323, 10, 10, 6, 4, 10001};
        System.out.print(solution(A));
    }

    // 타임아웃 발생
//    private static int solution(int[] A) {
//        int answer = 0;
//
//        LinkedList<Integer> pairCheckList = new LinkedList<>();
//
//        for(int number : A) {
//            int numberIndex = -1;
//
//            for(int i = 0; i < pairCheckList.size(); i++) {
//                if(pairCheckList.get(i) == number) {
//                    numberIndex = i;
//                    break;
//                }
//            }
//
//            if(numberIndex > -1) {
//                pairCheckList.remove(numberIndex);
//            }
//            else {
//                pairCheckList.add(number);
//            }
//        }
//
//        answer = pairCheckList.get(0);
//
//        return answer;
//    }

    // 통과
//    private static int solution(int[] A) {
//        int answer = 0;
//
//        HashMap<Integer, Boolean> pairCheckMap = new HashMap<>();
//
//        for(int number : A) {
//            if(pairCheckMap.containsKey(number)) {
//                pairCheckMap.remove(number);
//            }
//            else {
//                pairCheckMap.put(number, true);
//            }
//        }
//
//        answer = (int) pairCheckMap.keySet().toArray()[0];
//
//        return answer;
//    }

    // 비트 연산 XOR 으로 풀이
    private static int solution(int[] A) {
        int answer = 0;

        for(int number : A) {
            answer ^= number;
        }

        return answer;
    }
}
