package jian_zhi_offer.P_5_ShuJuLiuZhongDeZhongWeiShu;

import java.util.PriorityQueue;

public class Solution {
    // 大顶堆，存数值小的一半
    private PriorityQueue<Integer> down = new PriorityQueue<>((a, b) -> b - a);
    // 小顶堆，存数值大的一半
    private PriorityQueue<Integer> up = new PriorityQueue<>((a, b) -> a - b);
    private int n = 0;


    public void Insert(Integer num) {
        // 确保大顶堆数目比小顶堆数目多0或1
        if (n % 2 == 0){
           // 插到小顶堆--出小顶堆--插到大顶堆
            up.add(num);
            down.add(up.poll());
        } else {
            // 插到大顶堆--出大顶堆--插到小顶堆
            down.add(num);
            up.add(down.poll());
        }
        n++;

    }

    public Double GetMedian() {
        if (n % 2 == 0){
            return (up.peek() + down.peek()) / 2.0;
        } else {
            return new Double(down.peek());
        }
    }
}
