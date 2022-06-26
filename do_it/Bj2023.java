package do_it;

import java.util.Scanner;

public class Bj2023 {

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        //2 3 5 7
        DFS(2,1);//소수,자릿수
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);

    }

    private static void DFS(int num, int digit) {
        if(digit == N){
            System.out.println(num);
        }
        for(int i = 1 ; i < 10 ; i = i+2){
            if(isPrime(10*num+i)){
                DFS(10*num+i, digit+1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i < num/2 ; i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }

}

