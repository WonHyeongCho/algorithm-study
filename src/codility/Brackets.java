package codility;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
//        String S = "{[()()]}";
        String S = "([)()]";
        System.out.print(solution(S));
    }

    private static int solution(String S) {
        int answer = 1;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < S.length(); i++) {
            char bracket = S.charAt(i);

            if(bracket == '{' || bracket == '(' || bracket == '[') {
                stack.push(bracket);
            }
            else {
                if(!stack.empty()){
                    Character character = stack.pop();

                    if((character == '{' && bracket != '}')
                            || (character == '(' && bracket != ')')
                            || (character == '[' && bracket != ']')) {
                        answer = 0;
                        break;
                    }
                }
                else {
                    answer = 0;
                    break;
                }

            }
        }

        if(stack.size() != 0) {
            answer = 0;
        }

        return answer;
    }
}
