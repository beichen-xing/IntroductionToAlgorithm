import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// it is better to use ArrayList if searching is more frequent operation than add and remove operation
public class ArrayListTest {

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        // Will insert the element into index
        test.add(2,4);
        // Will change the element in index
        test.set(1,10);

// test with iterator
        Iterator iter = test.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        ListIterator liter = test.listIterator();
        while(liter.hasNext()){
            liter.next();
        }
        while(liter.hasPrevious()){
            System.out.println(liter.previous());
        }

        for (Integer i: test) {
            System.out.println(i);
        }


        System.out.println(test);
        // if not exist, return -1
        System.out.println(test.contains(3));
        // return index as array
        System.out.println(test.indexOf(2));
        System.out.println(test.get(2));
        System.out.println(test.remove(2));
        test.remove((Integer) 10);
        System.out.println(test.size());
        System.out.println(test);
        test.clear();
        System.out.println(test);
    }

}
