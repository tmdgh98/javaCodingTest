package baekjoon.ezen;

import java.util.Stack;

public class programmers짝지어제거하기 {

    /*
    * 스택문제 삽질함...
    * */
    public int solution(String s)
        {
    //         int answer = 0;

    //         List<Character> list = new LinkedList<>();
    //         for(int i=0; i<s.length(); i++){
    //             list.add(s.charAt(i));
    //         }

    //         int i=0;
    //         while(i < list.size() - 1){
    //             if(list.get(i) == list.get(i+1)){
    //                 list.remove(i);
    //                 list.remove(i);
    //                 i = i == 0 ? 0 : i-1;
    //             }else {
    //                 i++;
    //             }
    //         }

    //         return list.size() > 0 ? 0 : 1;


            Stack<Character> stack = new Stack<>();

            for(int i=0; i<s.length(); i++){
                if(stack.isEmpty()){
                    stack.push(s.charAt(i));
                }else{
                    if(stack.peek() == s.charAt(i)){
                        stack.pop();
                    }else {
                        stack.push(s.charAt(i));
                    }
                }
            }

            return stack.size() > 0 ? 0 : 1;
        }

}
