package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 노말한 다중 정렬조건 문제
 * */

public class BaekJoon10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Member array[] = new Member[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            Member member = new Member();
            member.age = Integer.parseInt(st.nextToken());
            member.name = st.nextToken();
            member.count = i;
            array[i] = member;
        }

        Arrays.sort(array, new Comparator<Member>() {
            public int compare(Member o1, Member o2) {
                if(o1.age == o2.age){
                    return o1.count > o2.count ? 1 : -1;
                }else{
                    return o1.age > o2.age ? 1 : -1;
                }
            }
        });
        
        for(Member member : array ){
            sb.append(member.age + " ");
            sb.append(member.name + "\n");
        }

        System.out.println(sb);
    }

    static class Member{
        int age;
        String name;
        int count;
    }
}
