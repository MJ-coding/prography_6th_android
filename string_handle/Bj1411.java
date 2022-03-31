package string_handle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Bj1411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] word = new String[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            String first = word[i];
            for (int j = i + 1; j < N; j++) {
                String second = word[j];
                answer += countingPair(first, second);
            }
        }
        System.out.println(answer);
    }

    private static int countingPair(String first, String second) {
        HashMap<Character, Character> map = new HashMap<>();

        for (int k = 0; k < second.length(); k++) {
            char firstAlpha = first.charAt(k);
            char secondAlpha = second.charAt(k);

            if (map.containsKey(firstAlpha)) {

                if (map.get(firstAlpha) == secondAlpha) {
                    continue;
                } else {
                    return 0;
                }

            } else {
                if(map.containsValue(secondAlpha)) return 0;
                map.put(firstAlpha, secondAlpha);
            }

        }

        return 1;
    }
}
