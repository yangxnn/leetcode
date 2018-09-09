package work.wangyi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        help(str);
    }
    private static void help(String str){
        int res = 0;
        int bn = 0;
        int wn = 0;
        for (char c : str.toCharArray()){
            if (c == 'b'){
                bn++;
            } else {
                wn++;
            }
        }
        int min = Math.min(bn, wn);
        int maxD = Math.max(bn -min, wn - min);
        if (maxD == 0){
            res = min * 2;

        } else if (maxD == 1){
            res = min * 2 + 1;
        } else {
            res = min * 2 + 1;
        }
        System.out.println(res);

    }
}
