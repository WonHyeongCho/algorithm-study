package codility;

public class YanoljaTest3 {
    public static void main(String[] args) {
        int A = 1402;
        int B = 404;
        System.out.print(solution(A, B));
    }

    private static int solution(int A, int B) {
        int number = A*B;

        int count = 0;

        while (number != 0) {
            System.out.println("Number: " + number + "," + Integer.toBinaryString(number));
            System.out.println("Number-1: " + (number-1) + "," + Integer.toBinaryString(number-1));

            number = number&(number-1);
            count++;
        }

        return count;
    }

//    private static int solution(int A, int B) {
//        int number = A*B;
//
//        int count = 0;
//
//        while (number != 0) {
//            count = (number%2 ==1) ? count+1 : count;
//            number /= 2;
//        }
//
//        return count;
//    }
}
