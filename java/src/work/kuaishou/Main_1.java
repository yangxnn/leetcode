package work.kuaishou;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        help(str);
    }

    private static void help(String str) {
        int[] num = new int[26];
        StringBuilder sb = new StringBuilder();
        int cI = 0;
        for (int i = 0; i < str.length(); i++) {
            cI = str.charAt(i) - 'a';
            num[cI] = num[cI] + 1;
        }
        char ch = ' ';
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1) {
                ch = (char) (i + 'a');
                sb.append(ch);
            } else if (num[i] > 1) {
                ch = (char) (i + 'a');
                String record = "" + ch + num[i];
                sb.append(record);
            }
        }
        String res = sb.toString();
        System.out.println(res);
    }
}
