package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*  트리 순회문제
*
*
* 공식이라도 있는건지
* preOrder(0, N, 0, N);
*     public static void preOrder(int in_begin, int in_end, int post_begin, int post_end) {
        if(in_begin > in_end || post_begin > post_end || post_end == 0)
            return;

        int root = post[post_end];
        System.out.print(root+" ");

        int left = idx[root] - in_begin;

        //Left
        preOrder(in_begin, idx[root] - 1, post_begin, post_begin + left -1);
        //right
        preOrder(idx[root] + 1, in_end, post_begin + left, post_end - 1);
    }
    * 다들 이렇게 풀더라...
* */

public class BeakJoon2263 {
    static int root;
    static int[][] tree;
    static int n;
    static int[] in;
    static int[] post;
    static int postIndex;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        in = new int[n];
        post = new int[n];

        tree = new int[n+1][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        root = post[n-1];

        postIndex = 0;
        fnMakeTree(0,n);

        fnPreOrder(root);

        System.out.println(sb);

    }

    static StringBuilder sb = new StringBuilder();
    private static void fnPreOrder(int node) {

        //String res="";

        //res += node;
        sb.append(node + " ");
        if(tree[node][0] != 0){
            //res += " "+fnPreOrder(tree[node][0]);
            //sb.append(" ").append(fnPreOrder(tree[node][0]));
            fnPreOrder(tree[node][0]);
        }
        if(tree[node][1] != 0){
            //res += " "+fnPreOrder(tree[node][1]);
            //sb.append(" ").append(fnPreOrder(tree[node][1]));
            fnPreOrder(tree[node][1]);
        }

        //return res;
    }

    private static int fnMakeTree(int s, int e) {
        postIndex++;
        int target = post[n-postIndex];
        //int inIndex = Arrays.binarySearch(in,s,e,target);
        int inIndex = -1;
        for (int i = s; i < e; i++) {
            if(target == in[i]){
                inIndex = i;
            }
        }
        if(inIndex == -1){
            postIndex--;
            return 0;
        }

        if(e>inIndex+1){
            tree[target][1] = fnMakeTree(inIndex+1,e);//오른쪽
        }

        if(inIndex>s) {
            tree[target][0] = fnMakeTree(s, inIndex); //왼쪽
        }

        return target;

    }
}
