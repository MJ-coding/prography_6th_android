package programmers;

import java.util.ArrayDeque;

public class Pro12909 {

    public static void main(String[] args) {
        System.out.println(solution(")()("));
    }
    //  (())()
    public static boolean solution(String s) {
        ArrayDeque<Character> dq = new ArrayDeque<>();
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(0) == ')')
                return false;
            if(s.charAt(i) == '('){
                dq.add('(');
            }else if(!dq.isEmpty() && s.charAt(i) == ')'){
                char top = dq.pop();
                if(top == ')'){
                    return false;
                }
            }
        }
        if(!dq.isEmpty()){
            return false;
        }
        return true;
    }

}
