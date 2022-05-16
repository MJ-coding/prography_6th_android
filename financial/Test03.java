package financial;

import java.util.HashMap;

public class Test03 {

    public static void main(String[] args) {
        HashMap<Info,Integer> map = new HashMap<>();
        map.put(new Info("0001", "5"), 95);
        map.put(new Info("0001", "4"), 80);
        //map.get(new Info)
        //if(co)
    }

}
class Info{
    private String testNumber;
    private String num;

    public Info(String testNumber, String num) {
        this.testNumber = testNumber;
        this.num = num;
    }

    public String getTestNumber() {
        return testNumber;
    }

    public String getNum() {
        return num;
    }
}
