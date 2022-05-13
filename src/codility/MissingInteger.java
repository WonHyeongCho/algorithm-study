
package codility;

import java.util.Arrays;

public class MissingInteger {
    public static void main(String[] args) {
//        int[] A = new int[]{1, 5, 7, 9, 11};
        int[] A = new int[]{1, 2, 3};
//        int[] A = new int[]{-1, -3};
//        int[] A = new int[]{1, 1, 2, 3, 4, 6};
//        int[] A = new int[]{4, 4, 4, 4, 4, 8};
        System.out.print(solution(A));
    }

    private static int solution(int[] A) {
        Arrays.sort(A);

        int answer = 1;

        for(int num : A) {
            if(answer == num)
                answer++;
        }

        return answer;
    }

    // 밑에 모두 문제를 잘못알고 풀었다
        // 22점 ...
//    private static int solution(int[] A) {
//        A = Arrays.stream(A)
//                .distinct()
//                .sorted()
//                .toArray();
//
//        int answer = 0;
//
//        if(A.length == 1) {
//            answer = A[0];
//        }
//        else if(A.length == 2) {
//            answer = 2*A[1]-A[0];
//        }
//        else {
//            int diff = A[1] - A[0];
//            for(int i = 1; i < A.length; i++) {
//                if(i == A.length-1) {
//                    answer = A[i] + diff;
//                    break;
//                }
//
//                int currentNum = A[i];
//                int nextNum = A[i+1];
//
////                System.out.println(currentNum + ", " + nextNum);
//
//                if(i == 1 && (nextNum-currentNum) != diff) {
//                    answer = currentNum - diff/2;
//                    break;
//                }
//                else if((nextNum-currentNum) != diff) {
//                    answer = currentNum + diff;
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }

    // 실패작
//    private static int solution(int[] A) {
//        Arrays.sort(A);
//
//        int answer = 0;
//
//        if(A.length == 1) {
//            answer = A[0] + 1;
//        }
//        else if(A.length == 2) {
//            answer = 2*A[1]-A[0];
//        }
//        else {
//            int diff = A[1] - A[0];
//            for(int i = 2; i < A.length; i++) {
//                int lastNum = A[i-1];
//                int currentNum = A[i];
//
//                if(lastNum == currentNum) continue;
//
//                if(i == 2 && (currentNum-lastNum) != diff) {
//                    answer = lastNum - diff/2;
//                    break;
//                }
//                else if (i == A.length-1) {
//                    answer = currentNum + diff;
//                }
//                else if((currentNum-lastNum) != diff) {
//                    answer = lastNum + diff;
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }
}
