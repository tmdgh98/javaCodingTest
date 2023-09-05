package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* 최소힙 최대힙 문제
 * 절대값최소힙 이긴한데
 * 방법이 다른진 모르겠음
 *
 * 직접구현해서 풀었으나 우선순위큐 PriorityQueue 라는 라이브러리를 사용하면됨.....
 * 다음에 힙문제보면 이걸로 풀어볼것...
* */

public class BeakJoon11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] heap = new int[n + 1];
        int heapSize = 0;

        int[] plusHeap = new int[n + 1];
        int[] minusHeap = new int[n + 1];
        int plusSize = 0;
        int minusSize = 0;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            int res;
            if (value == 0) {
                if(heapSize == 0){
                    sb.append(0 + "\n");
                    continue;
                }
                //sb.append(Arrays.toString(heap) + heapSize +"\n");

                res = heap[1];
                heap[1] = heap[heapSize];
                heapSize--;
                int index = 1;
                while (index * 2 <= heapSize) {

                    int a = heap[index] > 0 ? heap[index] : heap[index] * -1;
                    int targetIndex = index * 2;
                    int b = heap[targetIndex] > 0 ? heap[targetIndex] : heap[targetIndex] * -1;
                    if (targetIndex + 1 <= heapSize) {
                        int c = heap[targetIndex + 1] > 0 ? heap[targetIndex + 1] : heap[targetIndex + 1] * -1;

                        if (b > c || (b == c && heap[targetIndex] > 0 && heap[targetIndex + 1] < 0)) {
                            b = c;
                            targetIndex = targetIndex + 1;
                        }
                    }

                    if (a > b || (a == b && heap[index] > 0 && heap[targetIndex] < 0)) {
                        int temp = heap[targetIndex];
                        heap[targetIndex] = heap[index];
                        heap[index] = temp;

                        index = targetIndex;
                    } else {
                        break;
                    }
                }

                //sb.append(Arrays.toString(heap) +heapSize +"\n");
                sb.append(res + "\n");
                continue;
            } else {
                heapSize++;
                heap[heapSize] = value;
                int index = heapSize;
                while (index != 1) {
                    int a = heap[index / 2] > 0 ? heap[index / 2] : heap[index / 2] * -1;
                    int b = heap[index] > 0 ? heap[index] : heap[index] * -1;

                    if (a > b || (a == b && heap[index / 2] > 0 && heap[index] < 0)) {
                        int temp = heap[index / 2];
                        heap[index / 2] = heap[index];
                        heap[index] = temp;

                        index = index/2;
                    } else {
                        break;
                    }
                }
                //fnHeapAdd(value, heapSize);
            }


        }
        System.out.println(sb);
    }
}
