import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

       int test = 986;

       int length = 1;
       while(test / 10 != 0){
           length++;
           test = test/10;
       }

        System.out.println(test + " "  + length);
    }
}
