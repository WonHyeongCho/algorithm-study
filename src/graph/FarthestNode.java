package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 제공자: Programers
 * 제목: 가장 먼 노드
 * URL: https://programmers.co.kr/learn/courses/30/lessons/49189
 * 난이도: Level 3
 * 풀이완료시간: 45분/45분
 * 성공여부: 실패
 * 설명: 
 * 
 */
public class FarthestNode {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edge));
    }

    static public int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[][] map = new boolean[n+1][n+1];
        int[] distance = new int[n+1];

        for(int i = 0; i < edge.length; i++) { // 맵에 이어졌는지 체크
            int x = edge[i][0];
            int y = edge[i][1];
            map[x][y] = map[y][x] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int farthestDistance = 0;

        while(!queue.isEmpty()) {
            int number = queue.poll();

            for(int i = 2; i <= n; i++) {
                if(distance[i] == 0 && map[number][i] == true) {
                    distance[i] = distance[number] + 1;
                    farthestDistance = Math.max(farthestDistance, distance[number] + 1);
                    queue.add(i);
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            if(distance[i] == farthestDistance) answer++;
        }

        return answer;
    }

    // 실패한 풀이...
    // static public int solution(int n, int[][] edge) {
    //     int answer = 0;

    //     int[][] map = new int[n+1][n+1];
    //     int[] distance = new int[n+1];
        
    //     for(int i = 0; i < edge.length; i++) { // 맵에 이어졌는지 체크
    //         int x = edge[i][0];
    //         int y = edge[i][1];
    //         map[x][y] = 1;
    //         map[y][x] = 1;
    //     }

    //     // System.out.println(Arrays.deepToString(map));

    //     findPath(1, n, map, distance);

    //     int largestDistance = 0;

    //     for(int i = 2; i <= n ; i++) {
    //         if(distance[i] > largestDistance) {
    //             largestDistance = distance[i];
    //         }
    //     }

    //     for(int i = 2; i <= n; i++) {
    //         if(distance[i] == largestDistance) answer++;
    //         // System.out.print(distance[i] + " ");
    //     }

    //     return answer;
    // }

    // static void findPath(int start, int end, int[][] map, int[] distance) {
    //     Queue<Node> queue = new LinkedList<>();

    //     for(int i = 2; i <= end; i++) { // 처음 1에 근접한 노드 모두 넣기
    //         if(map[1][i] == 1 && distance[i] == 0) {
    //             distance[i] = 1;
    //             queue.add(new Node(i, 1));
    //         }
    //     }

    //     while(!queue.isEmpty()) {
    //         Node nextNode = queue.poll();
    //         System.out.println("Node number: " + nextNode.number + ", distance: " + nextNode.distance);
    //         int nextDistance = nextNode.distance + 1;
    //         for(int i = nextNode.number+1; i <= end; i++) {
    //             if(map[nextNode.number][i] == 1) {
    //                 if(distance[i] > nextDistance || distance[i] == 0) {
    //                     distance[i] = distance[nextNode.number] + 1;
    //                     queue.add(new Node(i, nextDistance));
    //                 }
    //             } 
    //         }
    //     }
    // }

    // static class Node {
    //     int number;
    //     int distance;

    //     Node(int number, int distance) {
    //         this.number = number;
    //         this.distance = distance;
    //     }
    // }
}
