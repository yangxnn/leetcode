package work.toutiao;

import java.util.Scanner;

public class Main_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        help(array, n);
    }
    private static void help(int[] array, int n){
        int res = 0;
        if (array == null || n == 0){
            res = 1;
            System.out.println(res);
            return;
        }
        int notLook = 0b10000000;
        int look = 0;
//        if (look == -1){
//            res = 0;
//            System.out.println(res);
//            return;
//        }
        for (int i = 0; i < n; i++){
            if (look > 0){
                if ((array[i] & notLook) == notLook){
                    look--;
                } else {
                    res = 0;
                    System.out.println(res);
                    return;
                }
            } else {
                look = count(array[i]);
                if (look < 0){
                    res = 0;
                    System.out.println(res);
                    return;
                }
            }
        }
        if (look == 0){
            res = 1;
        } else {
            res = 0;
        }
        System.out.println(res);

    }
    private static int count(int num){
        int res = 0;
        if ((num & 0b11110000) == 0b11110000){
            return 3;
        }
        else if ((num & 0b11100000) == 0b11100000){
            return 2;
        }
        else if ((num & 0b11000000) == 0b11000000){
            return 1;
        }
        else if ((num & 0b10000000) == 0b10000000){
            return -1;
        }
        return res;
    }
}
