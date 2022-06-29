package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1976 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        int root = -1;

        for(int i = 1 ; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N ; j++){
                int connected = Integer.parseInt(st.nextToken());
                if(connected == 1){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        root = find(Integer.parseInt(st.nextToken()));
        for(int i = 1 ; i < M; i++){
            if(root != find(Integer.parseInt(st.nextToken()))){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b)
            return;
        parent[a] = b;
    }

    private static int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

}
