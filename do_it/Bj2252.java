package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degree = new int[N+1];
        ArrayList<Integer>[] topology = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i ++){
            topology[i] = new ArrayList<>();
        }
        while(M-- >0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            topology[from].add(to);
            degree[to]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1 ; i < N+1; i++){
            if(degree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()){
            int current = q.poll();
            System.out.print(current + " ");

            for(int next : topology[current]){
                degree[next]--;
                if(degree[next] == 0)
                    q.offer(next);
            }
        }


    }

}
