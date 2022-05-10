package inflearn;

import java.util.Scanner;

/**
 * 제공자: 인프런 - 자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비
 * 제목: 문자 찾기
 * URL: https://cote.inflearn.com/contest/10/problem/01-01
 * 난이도: 초급
 * 풀이완료시간:
 * 성공여부:
 * 설명:
 *
 */
public class FindingCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String target = scanner.nextLine();

        String[] characters = str.toLowerCase().split("");
        target = target.toLowerCase();

        int count = 0;

        for(String s : characters) {
            if(target.equals(s)) count++;
        }

        System.out.print(count);
    }
}
