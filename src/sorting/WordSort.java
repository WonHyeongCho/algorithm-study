package sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 제공자: 백준
 * 제목: 단어 정렬
 * URL: https://www.acmicpc.net/problem/1181
 * 설명: 
 */

public class WordSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<String> words = new LinkedList<>();

        int length = sc.nextInt();

        for(int i = 0; i <= length; i++) {
            String str = sc.nextLine();
            words.add(str);
        }

        Collections.sort(words, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) {
                    return 1;
                }
                else if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                else {
                    return -1;
                }
            }

        });

        words.stream().distinct().forEach(word -> System.out.println(word));
    }
}