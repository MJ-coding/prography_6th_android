package test;

import java.util.ArrayList;

public class Test01 {

    public static void main(String[] args) {
        System.out.println();
    }
    private static int[] parent;

    public int[] solution(int n, int[][] edges) {
        int[] answer = {};
        int[] size = new int[3];
        int firstEdge = 0;
        int firstSize = 0;
        int secondSize = 0;
        int thirdSize = 0;

        for(firstEdge = 0 ; firstEdge < n; firstEdge++){
            answer = new int[2];
            for(int j = firstEdge; j<n; j++){
                answer[0] = firstEdge;
                answer[1] = j;
                firstSize =  firstEdge - (-1);
                secondSize = j - firstEdge;
                thirdSize = (n-1) - j;
            }
        }

        for(int i = 0 ; i < 3; i++){
            parent = new int[firstSize];

            //size[0] =
        }
//        parent = new int[n];
//        for(int i = 0 ; i < n; i++){
//            parent[i] = -1;
//        }


        return answer;
    }
    public static int find(int x){
        if(parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }
    public static void merge(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return;
        if(parent[x] < parent[y]){
            parent[x] += parent[y];
            parent[y] = x;
        }else{
            parent[y] += parent[x];
            parent[x] = y;
        }
    }

}

