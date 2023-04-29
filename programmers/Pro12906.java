package programmers;

import java.util.LinkedHashSet;
import java.util.Stack;

public class Pro12906 {

    public static void main(String[] args) {
        int[] answer = solution(new int[] {1,1,3,3,0,1,1});
        for(int ans : answer){
            System.out.print(ans + " ");
        }
    }

    public static int[] solution(int []arr) {
        int[] answer = {};
        //[1,1,3,3,0,1,1]	[1,3,0,1]
        Stack<Integer> stack = new Stack<>();
        int top = -1;

        for(int num : arr){
            if(!stack.isEmpty()){
                top = stack.pop();
            }
            if(top != -1){
                stack.push(top);
            }
            if(top != num ) {
                stack.push(num);
            }
        }
        answer = new int[stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()){
            answer[index--] = stack.pop();
        }
        return answer;
    }

}
