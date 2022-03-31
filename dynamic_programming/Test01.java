package dynamic_programming;

import java.io.IOException;

public class Test01 {
    private static int sum = 0;
    private static int arrLen = 0;

    public static void main(String[] args) throws IOException {

        int[] arr = {5,4,3,6,1};
        arrLen = arr.length;

        findMax(arr,0);
        System.out.println(sum);

    }

    private static void findMax(int[] arr, int index) {
        int prev = arr[index];
        int prevIndex = index;
        int start = 0;
        int startIndex = 0;
        int max = Integer.MIN_VALUE;

        for(int i = index+1 ; i < arrLen; i++){
            if(prev < arr[i]){
                start = prev;
                startIndex = prevIndex;
                break;
            }else{
                prev = arr[i];
                prevIndex = i;
            }
        }
        if(start == 0){
            return;
        }
        for(int i = startIndex+1; i < arrLen ; i++){
            if(arr[i] > start){
                max = Math.max(max,arr[i]-start);
                if(i == arrLen-1) {
                    sum += max;
                }
            }else{
                sum += max;
                if(i == arrLen-1) return;
                findMax(arr,i+1);
                return;
            }
        }
    }
}
