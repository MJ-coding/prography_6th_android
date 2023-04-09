package programmers;

import java.util.HashMap;
import java.util.Map;

public class Pro1845 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,3,3,2,2,4}));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.merge(num,1 , Integer::sum);
        }

        int maxPocket = nums.length/2;
        return maxPocket <= map.size() ? maxPocket : map.size();
    }

}
