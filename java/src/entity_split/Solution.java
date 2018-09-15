package entity_split;

import org.junit.Test;
import tools.print.ListP;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public List<String> segment(String str){
        int[] type = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            type[i] = getType(str.charAt(i));
        }
        List<String> res = new ArrayList<>();
        int start = 0;
        int pre = type[start];
        for (int i = 0; i < type.length; i++){
            if (type[i] == pre){
                continue;
            }

            res.add(str.substring(start, i));
            start = i;
            pre = type[i];
        }
        if (start < type.length){
            res.add(str.substring(start, type.length));
        }
        return res;

    }
    private int getType(char b){
        String c = String.valueOf(b);
        int res = 1; // 1为特殊字符 2 汉字， 4数字，8字母
        String regHan = "[\u4e00-\u9fa5]";
        String regNum = "[0-9]";
        String regZi = "[a-zA-Z]";
        if (c.matches(regHan)){
            res = 2;
        } else if (c.matches(regNum)){
            res = 4;
        } else if (c.matches(regZi)){
            res = 8;
        }
        return res;
    }

    public List<List<String>> combine(List<String> strs){
        List<List<String>> res = new ArrayList<>();
        if (strs == null){
            return res;
        }
        search(strs, res, new ArrayList<String>(), 0);
        return res;
    }
    private void search(List<String> str, List<List<String>> res, List<String> sub, int index){
        if (index > str.size() - 1){
            res.add(new ArrayList<>(sub));
        }
        for (int i = index; i < str.size(); i++){
            String tmp = join(str, index, i + 1);
            sub.add(tmp);
            search(str, res, sub, i + 1);
            sub.remove(sub.size() -1);
        }
    }
    private String join(List<String> str, int start, int end){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.size(); i++){
            if (i >= start && i < end){
                sb.append(str.get(i));
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String str = "正则，表123达a式";
        List<String> res = segment(str);
        List<List<String>> r = combine(res);
        for (List<String> ls : r){
            ListP.print(ls);
            System.out.println("=================");

        }
    }

}
