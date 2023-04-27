package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pro42746 {

    public static void main(String[] args) {
        String[] test = new String[] {"3", "30", "31"};
        Arrays.sort(test, Comparator.reverseOrder());
        System.out.println(test[0] + " " + test[1] + " " + test[2]);
        //System.out.println(solution(new int[]{3, 30, 34, 5, 9}) );
    }

    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int size = numbers.length;
        String[] strNumber = new String[size];

        for(int i = 0 ; i < size ; i++){
            strNumber[i] = String.valueOf(numbers[i]);
        }
        //Arrays.sort(strNumber,Collections.reverseOrder());
        //o2+o1 > o1+o2 ? 1 : -1 [1이면 swap]
        Arrays.sort(strNumber, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        //0값이 중복일경우 ex){0,0,0}
        //답이 000이 나오면 안되므로 첫번째값이 0이면 0을 리턴
        if (strNumber[0].equals("0")) return "0";
        for(String str : strNumber){
            sb.append(str);
        }
        return sb.toString();
    }

}
