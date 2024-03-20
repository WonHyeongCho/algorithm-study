package programmers;

import java.util.Stack;

/**
 * 제공자: Programmers
 * 제목: 큰 수 만들기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42883
 * 난이도: Level 2
 * 풀이완료시간: /40분
 * 성공 여부: 실패
 * 설명:
 */
public class MakeBigNumber {

    public static void main(String[] args) {
        String number = "333222111";
        int k = 3;
        System.out.println(solution(number, k));
    }

    static String solution(String number, int k) {
        String[] split = number.split("");

        Stack<String> stack = new Stack<>();

        for (String s : split) {
            if (stack.isEmpty()) {
                stack.push(s);
            } else {
                while (!stack.isEmpty() && k > 0
                    && Integer.parseInt(stack.peek()) < Integer.parseInt(s)) {
                    stack.pop();
                    k--;
                }
                stack.push(s);
            }
        }

        if(number.length() == stack.size()) {
            for(int i = 0; i < k; i++) {
                stack.pop();
            }
        }

        StringBuilder answer = new StringBuilder();

        while (!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }

        return answer.toString();
    }
}
