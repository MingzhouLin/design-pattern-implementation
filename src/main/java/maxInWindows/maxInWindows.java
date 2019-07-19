package maxInWindows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class maxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if (num == null || size < 0){
            return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int maxIndex = -1;
        if (size >= num.length){
            for (int i = 0; i < num.length; i++) {
                queue.add(num[i]);
            }
            maxIndex = findMax(queue);
            result.add(num[maxIndex]);
            return result;
        }
        for (int i = 0; i < size; i++) {
            queue.add(num[i]);
        }
        maxIndex = findMax(queue);
        result.add(num[maxIndex]);
        for (int i = size; i < num.length; i++) {
            if (i-maxIndex >= size){
                queue.poll();
                queue.add(num[i]);
                maxIndex = i - size + findMax(queue)+ 1;
            }else {
                if (num[i] >= num[maxIndex]){
                    maxIndex = i;
                }
            }
            result.add(num[maxIndex]);
        }
        return result;
    }

    public int findMax(Queue<Integer> queue){
        int pos = 0;
        int max = -1;
        int maxPos = -1;
        for (int i :
                queue) {
            if (i > max){
                max = i;
                maxPos = pos;
            }
            pos++;
        }
        return maxPos;
    }
}
