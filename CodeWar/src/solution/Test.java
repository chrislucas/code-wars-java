package solution;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public static void removeDuplicates(ArrayList<? extends Comparable> set) {
        Collections.sort(set);
        for(int i=0; i<set.size() - 1; i++) {
            if(set.get(i).compareTo(set.get(i+1)) == 0) {
                set.remove(i);
                i--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(5);
        set.add(2);
        set.add(10);
        set.add(9);
        set.add(30);
        set.add(9);
        set.add(2);
        set.add(2);
        set.add(2);
        set.add(2);
        set.add(2);
        set.add(2);

        removeDuplicates(set);
        for(int x : set) {
            System.out.printf("%d ", x);
        }


    }
}
