package implementation;

import java.util.Scanner;

//별짓기1
public class Bj2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String star = "*";
        for(int i=1; i <= N; i++){
            System.out.println(star.repeat(i));
        }
    }
}
