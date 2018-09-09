package work.alibaba;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String pat = sc.nextLine();
        String query = sc.nextLine();
        help(pat, query);
    }
    private static void help(String pat, String query){
        ArrayList<String> pats = segment(pat);
        int start = 0;
        int end = 0;
        int res = 0;
        for (String s : pats){
            if (end >= query.length()){
                break;
            }
            if (start >= end){
                end = start + 1;
            }
            if (match(s, query.substring(start, end))){
                res = 1;
                start = end;
            } else {
                res = 0;
                end ++;
            }
        }
        System.out.println(res);
    }
    private static boolean match(String p, String sub){
        if (p.equals("@{singer}") && sub.equals("@{singer}")){
            return true;
        } else if (p.equals("@{singer}") ){
            return false;
        }
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(sub);
        return matcher.matches();
    }
    private static ArrayList<String> segment(String str){
        ArrayList<String> res = new ArrayList<>();
        String[] t = str.split(">");
        for (String s: t){
            String[] tt = s.split("<");
            for (String ss : tt){
                res.add(ss);
            }
        }
        return res;
    }
}
