package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for(int k = 0 ; k < N; k++)
        {
            long find = arr[k];
            int i = 0;
            int j = N-1;

            while(i < j){
                if(arr[i] + arr[j] == find){
                    if( i != k && j != k){
                        ans++;
                        break;
                    }else if(i == k){
                        i++;
                    }else if(j == k){
                        j--;
                    }

                }else if(arr[i] + arr[j] < find){
                    i++;
                }else{
                    j--;
                }
            }
        }

        System.out.println(ans);

    }

}
