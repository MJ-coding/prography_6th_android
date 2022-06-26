package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1920 {

    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M; i++){
            System.out.println(binarySearch(Integer.parseInt(st.nextToken())));
        }
    }

    private static int binarySearch(int target) {
        int front = 0;
        int end = N-1;

        while(front <= end){
            int mid = (front+end)/2;

            if(arr[mid] == target){
                return 1;
            }else if(arr[mid] < target){
                front = mid+1;
            }else{
                end = mid-1;
            }
        }
        return 0;
    }

}
