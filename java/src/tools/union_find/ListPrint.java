package tools.union_find;

import java.util.List;

public class ListPrint {
    public static <T extends Object> void print(List<T> list){
        for (T t: list){
            System.out.println(t.toString());
        }

    }
}
