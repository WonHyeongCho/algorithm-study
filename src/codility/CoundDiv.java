package codility;

public class CoundDiv {
    public static void main(String[] args) {
        int A = 6;
        int B = 11;
        int K = 2;
        System.out.print(solution(A, B, K));
    }

    private static int solution(int A, int B, int K) {
        return (int) (Math.floor(B/K) - Math.ceil(A/K) + 1);
    }

    // 이것도 시간 에러
//    private static int solution(int A, int B, int K) {
//        int answer = 0;
//        int number = 0;
//
//        for(int i = A; i < B; i++) {
//            if(i%K == 0) {
//                number = i;
//                break;
//            }
//        }
//
//        while(number < B) {
//            answer++;
//            number += K;
//        }
//
//        return answer;
//    }

    // Performance 떨어짐
//    private static int solution(int A, int B, int K) {
//        int answer = 0;
//
//        for(int i = A; i <= B; i++) {
//            if(i%K == 0) answer++;
//        }
//
//        return answer;
//    }
}
