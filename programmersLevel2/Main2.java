import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int res = fnFindFourSquares(1,n);

        System.out.println(res);

    }

    private static int fnFindFourSquares(int i, int n) {
        if(i*i > n){
            return 300;
        }

        double length = Math.sqrt(n) ;
        //System.out.println(length);

        int res = 1;
        for (int j = 1; j <= length; j++) {
            int temp = 1;
            int cut = n - j*j;

            if(cut == 0){
                return 1;
            }else if(cut > 0){
                temp += fnFindFourSquares(i+1,cut);
            }

            res = j==1 ? temp : Math.min(res, temp);
        }

        return res;
    }

}
