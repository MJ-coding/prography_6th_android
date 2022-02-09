package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<N; i++){
            q.add(i+1);
        }
        System.out.print("<");
        while(N-- >0){
            for(int i=0; i<k-1; i++){
                q.add(q.poll());
            }
            if(N >0){
                System.out.print(q.poll()+", ");
            }else{
                System.out.print(q.poll());
            }

        }
        System.out.print(">");

    }
}
