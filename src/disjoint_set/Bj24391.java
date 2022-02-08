package disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj24391 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        parent = new int[N];
        for(int i = 0 ; i < N ;i++){
            parent[i] = -1;
        }
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            merge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        }
        st = new StringTokenizer(br.readLine());
        int prev = find(Integer.parseInt(st.nextToken())-1);

        for(int i = 1 ; i < N ; i++){
            int root = find(Integer.parseInt(st.nextToken())-1);
            if( prev != root){
                answer++;
            }
            prev = root;
        }
        System.out.println(answer);

    }
    private static int find(int x){
        if(parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    private static void merge(int x, int y) {
        x = find(x);
        y = find(y);

        if( x == y) return;
        if(parent[x] < parent[y]){
            parent[x] += parent[y];
            parent[y] = x;
        }else {
            parent[y] += parent[x];
            parent[x] = y;
        }
    }
}
