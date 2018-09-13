package work.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hel{
    private int count = 0;
    private String str;

    public Hel(String str) {
        this.str = str;
    }

    public int help() {
        help2(0, 0);
//        help2(0, 0, "");
        return this.count;

    }
    private void help2(int curIndex, int num) {
//    private void help2(int curIndex, int num, String sub) {
        if (num == 4){
            if (curIndex == str.length()){
                count++;
            }
            return;
        }
        if (str.length() <= curIndex){
            return;
        }
        char starChar = str.charAt(curIndex);
        for (int i = 1; i < 4 && (curIndex + i <= str.length()); i++){
            if (starChar == '0' && i > 1){
                break;
            }
            String s = str.substring(curIndex, curIndex + i);
            if (i == 3){
                int ss = Integer.valueOf(s);
                if (ss > 255){
                    continue;
                }
            }
//            String ss = "";
//            if (num != 0){
//                ss = sub + "." + s;
//            } else {
//                ss = s;
//            }
//            help2(curIndex + i, num + 1, ss);
            help2(curIndex + i, num + 1);
        }
    }

}

public class Main_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        Hel h = new Hel(str);
        int num = h.help();
        System.out.println(num);
    }
}
