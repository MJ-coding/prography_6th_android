package programmers;

import java.util.*;

public class Pro42728 {

    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        List<int[]> intList = Arrays.asList(answer);
        System.out.println(Arrays.toString(intList.get(0)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0 ; i < commands.length; i++){
            int[] sub = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
            Arrays.sort(sub);
            answer[i] = sub[commands[i][2]-1];
        }

        return answer;
    }

}
