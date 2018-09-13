package jian_zhi_offer.P_9_ErJinZhiZhongYiDeGeShu;

import org.junit.Test;

public class Solution {
    public int NumberOf1(int n) {
        // 不停将n左移一位，与1与
        int res = 0;
        while (n != 0){
            if ((n & 1) == 1){
                res++;
            }
            n = n >> 1;
            System.out.println(res);
        }
        return res;
    }

    @Test
    public void t(){
        NumberOf1(3);
    }
}
