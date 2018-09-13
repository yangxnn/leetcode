package work.jd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solve(String S, String T) {
        int res = 0;
        if (S == null || T == null ||T.length() > S.length()){
            return res;
        }
        int lt = T.length();
        int ls = S.length();
        char aa = ' ';
        Map<Character, Character> m;
        for (int i = 0; i < ls - lt; i++){
            m = new HashMap<>();
            int dd = 1;
            for (int j = 0; j < lt; j++){
                if (m.containsKey(S.charAt(i + j))){
                    aa = m.get(S.charAt(i + j));
                    if (aa != T.charAt(j)){
                        dd = 0;
                        break;
                    }
                } else {
                    m.put(S.charAt(i + j), T.charAt(j));
                }

            }
            res = res + dd;
        }
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _S;
        try {
            _S = in.nextLine();
        } catch (Exception e) {
            _S = null;
        }

        String _T;
        try {
            _T = in.nextLine();
        } catch (Exception e) {
            _T = null;
        }

        res = solve(_S, _T);
        System.out.println(String.valueOf(res));

    }
}
