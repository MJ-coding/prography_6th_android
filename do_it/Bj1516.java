package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1516 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N+1];
        int[] time = new int[N+1];
        int[] topology = new int[N+1];
        ArrayList<Integer>[] paths = new ArrayList[N+1];
        for(int i = 0 ; i < N+1 ; i++){
            paths[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while(true){
                int building = Integer.parseInt(st.nextToken());
                if(building == -1)
                    break;
                topology[i]++;
                paths[building].add(i);
            }

        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <=N; i++){
            if(topology[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : paths[current]){
                topology[next]--;
                result[next] = Math.max(result[next], result[current] + time[current]);
                if(topology[next] == 0)
                    q.offer(next);
            }
        }
        for(int i = 1; i < N+1; i++){
            System.out.println(result[i]+time[i]);
        }
    }

}
