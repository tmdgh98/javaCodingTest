
import java.io.*;
import java.util.*;

public class Main {

    /*
    1644 문제집
    소수찾기, 두 포인터 합계
    */
    public static void main(String[] args) throws IOException {

        int[][] param = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        solution(param);

        long a = (long) Math.pow(4,15);
        System.out.println(a);
    }

    public static String solution(int[][] ability) {
        String answer = "";
        List<String> list = Arrays.asList(new String[] {"a","b","c"});

        //String input_string
        // java.util.*
        //input_string = input_string.toLowerCase();
        //input_string.toUpperCase();
        //input_string.charAt(1);
        //input_string.equals("");

//        우선순위큐
//        Queue<int[]> waitHeap = new PriorityQueue<>((o1, o2) -> {
//            if (o1[0] == o2[0]) {
//                return o1[1] - o2[1];
//            }
//            return o1[0] - o2[0];
//        });
//        Queue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
//                    @Override
//                    public int compare(int[] o1, int[] o2) {
//                        if (o1[1] == o2[1]) {
//                            return o1[0] > o2[0] ? 1 : -1;
//                        }
//                        return o1[1] > o2[1] ? 1 : -1;
//                    }
//                });
//
//        que.isEmpty();
//        que.size();
//
//        Queue<String> que2 = new LinkedList<>();
//        que2.add("1");
//
//        List<String> list = new ArrayList<>();
//        list.add("1");
//
//        Stack<String> stack = new Stack<>();
//        stack.isEmpty();
//        stack.pop();
//        stack.push();
//        stack.peek();

        //Math.pow(4,15)
        //Math.sqrt(4);
        //Math.abs(-4);

        //Collections.sort();
        //Arrays.fill();

        //Integer.MAX_VALUE;
        //Integer.MIN_VALUE;

        //List<String> list = Arrays.asList(arr);
        //List<String> list = new ArrayList<>(Arrays.asList(arr));
        //Collections.sort(list,Comparator.reverseOrder());



        return answer;
    }

}
