package jian_zhi_offer.P_3_MaximumValueOfSlidingWindow;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        /**
         * 维护一个size的堆就行
         */
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || size < 1){
            return res;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a); // 大顶堆
        for (int i = 0; i < size; i++){
            heap.add(num[i]);
        }
        res.add(heap.peek());
        for (int i = 1; i <= num.length - size; i++){
            heap.remove(num[i - 1]);
            heap.add(num[i + size - 1]);
            res.add(heap.peek());
        }
        return res;
    }
}
