package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj5598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char caesar;

        for(int i =0 ; i< input.length(); i++){
            caesar = input.charAt(i);
            if(caesar == 'A'){
                System.out.print('X');
            }else if(caesar == 'B'){
                System.out.print('Y');
            }else if(caesar== 'C'){
                System.out.print('Z');
            }else{
                System.out.print((char)(caesar-3));
            }
    }

    }
}
