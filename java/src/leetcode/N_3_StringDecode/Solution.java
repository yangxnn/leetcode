package leetcode.N_3_StringDecode;

import tools.union_find.ListPrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<String, String> dict = new HashMap<String, String>(){{
       put(")", "A");
       put("|)", "B");
       put("|))", "C");
    }};
    public void printAllDecode(String str){
        if (str == null ||str.equals("")){
            return;
        }
        List<List<String>> res = new ArrayList<>();
        dfsHelper(res, new ArrayList<String>(), 0, 1, str);
        for (List<String> r : res){
            ListPrint.print(r);
            System.out.println("---");
        }


    }
    private void dfsHelper(List<List<String>> res, List<String> sub, int startIndex, int endIndex, String str){
        if ((endIndex == str.length()) && (dict.containsKey(str.substring(startIndex, endIndex)))) {
            sub.add(str.substring(startIndex, endIndex));
            res.add(new ArrayList<>(sub));
        } else {
            return ;
        }
        for (int i = endIndex; i < str.length() + 1; i++){
            System.out.println("" + startIndex + "--" + endIndex);
            if (dict.containsKey(str.substring(startIndex, i))){
                sub.add(str.substring(startIndex, i));
                dfsHelper(res, sub, i, i + 1, str);
                sub.remove(sub.size() - 1);
            } else {
                dfsHelper(res, sub, startIndex, i + 1, str);
            }

        }
    }

}
