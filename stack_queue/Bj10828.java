package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj10828 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            String[] input = br.readLine().split(" ");
            switch (input[0]){
                case "push":
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "top" :
                    if(stack.empty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(stack.peek());
                    }
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    if(stack.empty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "pop" :
                    if(stack.empty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(stack.peek());
                        stack.pop();
                    }
                    break;
            }
        }
    }
}
