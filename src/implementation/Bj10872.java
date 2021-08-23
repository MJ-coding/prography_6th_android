package implementation;

import java.util.Scanner;

public class Bj10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 1;
        if( N == 0){
            System.out.println(1);
        }else{
            while(N > 0){
                ans *= N;
                N--;
            }
            System.out.println(ans);
        }

    }
}
