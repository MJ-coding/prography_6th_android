package do_it;

import java.util.Scanner;

public class Bj2018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int front = 1;
        int rear = 1;
        int sum = 1;
        int count = 1; //front,rear -> N

        while(rear != N){
            if(sum ==  N){
                count++;
                rear++;
                sum += rear;
            }else if(sum > N){
                sum -= front;
                front++;
            }else{
                rear++;
                sum += rear;
            }
        }

        System.out.println(count);

    }

}
