package work.toutiao;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        help(str.trim());
    }

    private static void help(String str) {
        int res = 0;
        if (str == null || str.equals("")) {
            System.out.println(res);
            return;
        }
        Map<Character, Integer> map = new HashMap<>();
        int ind = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            if (!map.containsKey(str.charAt(i))) {
                if ((i - ind + 1) > res) {
                    res = i - ind + 1;
                }
            } else {
                ind = map.get(str.charAt(i)) + 1;
            }
            map.put(str.charAt(i), i);
        }
        System.out.println(res);
    }
}
