package tools.print;

import java.util.List;

public class ListP {
    public static <T extends Object> void print(List<T> l){
        for (T t : l){
            System.out.println(t.toString());
        }
    }

    public static void charP(char[] c){
        for(char cc : c){
            System.out.println(cc);
        }
    }
    public static void intp(int[] i){
        for(int ii : i){
            System.out.println(ii);
        }
    }
}
