package first;
import java.io.*;

public class Bj14681 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		System.out.print((x < 0 && y >0)? '2': (x >0 && y >0)? '1': (x < 0 && y<0)? '3':'4');
		
	}

}
