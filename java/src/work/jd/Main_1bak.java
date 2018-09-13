package work.jd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_1bak {


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
        char[] ts = T.toCharArray();
        char[] tmp = new char[lt];
        for (int i = 0; i < ls - lt; i++){
            if (isSame(S, i, lt, ts, tmp)){
                res++;
            }
        }
        return res;
    }
    private static boolean isSame(String s, int start, int d, char[] b, char[] tmp){
        boolean res = false;
        if (d != b.length){
            return res;
        }
        char aa = ' ';
        Map<Character, Character> m = new HashMap<>();
        for (int i = 0; i < d; i++){
            if (m.containsKey(s.charAt(start + i))){
                aa = m.get(s.charAt(start + i));
                if (aa != b[i]){
                    break;
                }
                tmp[i] = aa;
            } else {
                tmp[i] = b[i];
                m.put(s.charAt(start + i), b[i]);
            }
        }
        return true;
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
