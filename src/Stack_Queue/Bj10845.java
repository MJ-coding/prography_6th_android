package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Bj10845 {
    public static void main(String[] args) throws IOException {
        //Queue<Integer> q = new LinkedList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-- >0){
            String[] input = br.readLine().split(" ");
            switch (input[0]){
                case "push":
                    //Integer.tostring()
                    dq.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if(dq.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(dq.poll());
                    }
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "front" :
                    if(dq.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(dq.peek());
                    }
                    break;
                case "back":
                    if(dq.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(dq.peekLast());
                    }
                    break;
            }
        }
    }
}
