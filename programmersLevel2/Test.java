import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        List<Integer> test = new ArrayList<>();

        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);

        Collections.reverse(test);

        System.out.println(test.toString().replace(" ",""));
    }
}
