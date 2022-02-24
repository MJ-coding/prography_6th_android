package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj20917 {
    private static int n,s;
    private static int[] location;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            location = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n; i++){
                location[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(location);

            System.out.println(binarySearchLength(0,location[n-1]-location[0]));
        }
    }

    private static int binarySearchLength(int start, int end) {
        int mid = 0;
        int max = 0;
        int seats = 0;

        while(start <= end){
            mid = (start+end)/2;
            seats = countingSeat(mid);

            if(seats < s){
                end = mid-1;
            }else{
                start = mid+1;
                max = Math.max(mid,max);
            }

        }

        return max;
    }

    private static int countingSeat(int length){
        int current = 0;
        int next = 1;
        int seats = 1;

        while(next < n){
            int diff = location[next] - location[current];

            if( diff < length){
                next++;
            }else{
                seats++;
                current = next;
                next++;
            }
        }

        return seats;
    }
}
