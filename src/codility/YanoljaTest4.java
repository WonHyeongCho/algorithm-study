package codility;

import java.util.Arrays;
import java.util.Stack;

public class YanoljaTest4 {
    public static void main(String[] args) {
//        int[] A = {4, 9, 8, 2, 6};
//        int[] A = {5, 6, 3, 4, 2};
//        int[] A = {2, 2, 2, 2, 2};
        int[] A = {2, 3, 3, 5, 5};
        int K = 3;
        System.out.print(solution(A, K));
    }

    private static int solution(int[] A, int K) {
        if(A.length < K) {
            return -1;
        }

        Stack<Integer> oddStack = new Stack<>();
        Stack<Integer> evenStack = new Stack<>();

        Arrays.sort(A);

        for (int number : A) {
            if (number % 2 == 1) {
                oddStack.push(number);
            } else {
                evenStack.push(number);
            }
        }

        int count = K;
        int sum = 0;

        while (count > 0) {
            if((oddStack.empty() && evenStack.empty())
                    || (oddStack.size() < 2 && evenStack.empty())) {
                break;
            }

            if(evenStack.empty() && count%2==0) {
                for(int i = 0; i < count; i++) {
                    sum += oddStack.pop();
                    count--;
                }
                break;
            }
            else if(evenStack.empty() && count%2!=0){
                break;
            }

            if(oddStack.size() >=2 && count > 1) {
                int oddTop = oddStack.pop();
                int oddNextTop = oddStack.pop();
                int evenTop = evenStack.pop();

                if((oddTop + oddNextTop) > evenTop) {
                    sum = sum + oddTop + oddNextTop;
                    evenStack.push(evenTop);
                    count = count-2;
                }
                else {
                    sum = sum + evenTop;
                    oddStack.push(oddTop);
                    oddStack.push(oddNextTop);
                    count--;
                }
            }
            else {
                sum += evenStack.pop();
                count--;
            }

            System.out.println(sum);
        }

        if(count > 0) {
            sum = -1;
        }

        return sum;
    }
}
