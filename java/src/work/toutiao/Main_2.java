package work.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class He{
    private int count = 0;
    private String str;

    public He(String str) {
        this.str = str;
    }

    public int help() {
        help2(0, 0, "");
        return this.count;

    }
    private void help2(int curIndex, int num, String sub) {
        if (num == 4){
            if (curIndex == str.length()){
                count++;
            }
            return;
        }
        if (str.length() < curIndex){
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
            String ss = "";
            if (num != 0){
                ss = sub + "." + s;
            } else {
                ss = s;
            }
            help2(curIndex + i, num + 1, ss);
        }
    }

}

public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        He h = new He(str);
        int num = h.help();
        System.out.println(num);
    }

    public List<String> restoreIpAddresses(String s)
    {
        List<String> ret = new ArrayList<String>();
        restoreIpAddresses1(s, 0, 0, "", ret);
        return ret;
    }

    public void restoreIpAddresses1(String s, int start, int n, String t,
                                    List<String> ret)
    {

        if (n == 4)
        {
            if (start == s.length())
            {
                ret.add(t);
            }
            return;
        }
        if(start>=s.length()){
            return;
        }
        char c=s.charAt(start);
        for (int i = 1; i < 4 && start+i<=s.length(); i++)
        {

            if(c=='0' && i>1){
                break;
            }
            String st = s.substring(start, start + i);
            if (i == 3)
            {
                int sn = Integer.valueOf(st).intValue();
                if (sn > 255)
                {
                    continue;
                }
            }
            String t1="";
            if(n==0){
                t1=st;
            }else{
                t1=t + "." + st;
            }

            restoreIpAddresses1(s, start + i, n + 1,t1 , ret);

        }
    }
}

