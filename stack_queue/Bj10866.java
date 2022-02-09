package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Bj10866 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> dq = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-- >0){
            String[] input = br.readLine().split(" ");
            switch(input[0]){
                case "push_front":
                    dq.offerFirst(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    dq.offerLast(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    if(dq.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(dq.removeFirst());
                    }
                    break;
                case "pop_back":
                    if(dq.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(dq.removeLast());
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
                case "front":
                    if(dq.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(dq.peekFirst());
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
