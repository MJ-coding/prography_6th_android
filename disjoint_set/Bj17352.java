package disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj17352 {
    private static int[] parent;
    private static String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        Arrays.fill(parent,-1);

        for(int i = 0 ; i < N-2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            merge(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
        }
        for(int i = 0 ; i < N; i++){
            if(parent[i] >= 0) continue;
            sb.append(i+1).append(SPACE);
        }
        System.out.println(sb);
    }
    private static int find(int x){
        if(parent[x]<0) return x;
        return parent[x] = find(parent[x]);
    }

    private static void merge(int x, int y) {
        x = find(x);
        y = find(y);

        if(x==y) return;
        if(parent[x] < parent[y]){
            parent[x] += parent[y];
            parent[y] = x;
        }else {
            parent[y] += parent[x];
            parent[x] = y;
        }
    }
}
