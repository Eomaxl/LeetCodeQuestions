package com.company.graph.medium;
import java.util.*;

class Pair{
    int x, y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class MinimumStepsByKnight {

    public static void main(String[] args){
        int N = 6;
        int[] knightPos = {4,5};
        int[] targetPos = {1,1};
        int result = minStepToReachTarget(N, knightPos, targetPos);
        System.out.println("THe minimum step it took was :"+result);
    }

    public static int minStepToReachTarget(int N, int[] knightPos, int[]targetPos){
        int knight_x = knightPos[0] -1;
        int knight_y = knightPos[1] -1;
        int target_x = targetPos[0] -1;
        int target_y = targetPos[1] -1;

        int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};//{2,-2,2,-2,1,1,-1,-1};
        int[] dy = {1, -1, 2, -2, 2, -2, 1, -1}; //{1,1,-1,-1,2,-2,2,-2};

        boolean[][] visited = new boolean[N][N];
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(knight_x,knight_y));
        visited[knight_x][knight_y] = true;
        int step =0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i<size; i++){
                Pair current = queue.poll();

                if(current.x == target_x && current.y == target_y)
                    return step;

                for(int j =0; j< 8; j++){
                    int next_x = current.x + dx[j];
                    int next_y = current.y + dy[j];

                    if(next_x >=0 && next_x < N && next_y >= 0 && next_y< N && !visited[next_x][next_y]){
                        queue.offer(new Pair(next_x,next_y));
                        visited[next_x][next_y] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }


}
