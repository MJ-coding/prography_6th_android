package disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2606 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[n];
        for(int i = 0 ; i < n; i++){
            parent[i] = -1;
        }
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            merge(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
        }
        System.out.println(-parent[find(0)]-1);
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
