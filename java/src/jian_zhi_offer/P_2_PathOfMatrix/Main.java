package jian_zhi_offer.P_2_PathOfMatrix;

public class Main {
    public static void main(String[] args){
        Solution s = new Solution();
        String str = "ABCESFCSADEE";
        boolean b = s.hasPath(str.toCharArray(), 3, 4, "ABCB".toCharArray());
        System.out.println(b);
    }
}
