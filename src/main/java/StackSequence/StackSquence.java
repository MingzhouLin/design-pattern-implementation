package StackSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class StackSquence {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        List<Integer> pushList = Arrays.stream(pushA).boxed().collect(Collectors.toList());
        List<Integer> popedList = new ArrayList<>();
        int maxIndex = 0;
        for (int n :
                popA) {
            int index = pushList.indexOf(n);
            if (index ==-1){
                return false;
            }
            if(popedList.isEmpty()){
                popedList.add(index);
                maxIndex = index;
            }else {
                if (index>maxIndex){
                    maxIndex = index;
                    popedList.add(index);
                }else {
                    if (popedList.contains(index+1)){
                        popedList.add(index);
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
