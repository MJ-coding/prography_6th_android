package step;
//A+B
import java.util.*;
import java.io.*;
public class Bj10950 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		
		for(int i=0; i<T ;i++){
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		arr[i] = A+B;			
		}
		for(int i=0; i<T ;i++) {
			System.out.println(arr[i]);
		}
		/*
		 * BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(reader.readLine());

        String[] numArr = new String[total];
        for(int index = 0; index < total; index++) {
            numArr[index] = reader.readLine();
        }
        int a, b;
        String[] split;
        for (String s : numArr) {
            split = s.split(" ");
            a = Integer.parseInt(split[0]);
            b = Integer.parseInt(split[1]);
            writer.write((a + b) + "\n");
        }

        reader.close();
        writer.close();
        */
	}

}
