package src.backjun.unClassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 트리순회문제
 * 
 * 그냥 재귀순서만 바꾸며 되는문제였다
 * */
public class BeakJoon1991 {
    static StringBuilder sb = new StringBuilder();
    static Map<String, String[]> tree;
    static int n;
    static String non = ".";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        tree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a,b,c;
            a = st.nextToken();
            b = st.nextToken();
            c = st.nextToken();

            tree.put(a,new String[]{b,c});
        }

        sb.append(fnTree("A")).append("\n");
        sb.append(fnTree2("A")).append("\n");
        sb.append(fnTree3("A"));

        System.out.println(sb);

    }

    private static String fnTree(String a) {

        String[] temp = tree.get(a);
        String b = temp[0];
        String c = temp[1];

        String res = "";
        res = a;
        if(b.equals(non) == false){
            res = res + fnTree(b);
        }
        if(c.equals(non) == false){
            res = res + fnTree(c);
        }

        return res;
    }
    private static String fnTree2(String a) {

        String[] temp = tree.get(a);
        String b = temp[0];
        String c = temp[1];

        String res = "";
        if(b.equals(non) == false){
            res = fnTree2(b)+res;
        }
        res += a;
        if(c.equals(non) == false){
            res = res + fnTree2(c);
        }

        return res;
    }
    private static String fnTree3(String a) {

        String[] temp = tree.get(a);
        String b = temp[0];
        String c = temp[1];

        String res = "";

        if(c.equals(non) == false){
            res = fnTree3(c)+res;
        }
        if(b.equals(non) == false){
            res = fnTree3(b)+res;
        }
        res += a;

        return res;
    }
}
