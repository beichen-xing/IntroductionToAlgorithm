import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    //The LinkedList provides constant time for add and remove operations. So it is better to use LinkedList for manipulation.

    public static void main(String[] args) {
        List<Integer> test = new LinkedList<>();
        test.add(3);
        test.add(2);
        test.add(1);

        System.out.println(test);
        System.out.println(Arrays.toString(test.toArray()));

        System.out.println(test.remove(2));
        test.remove((Integer)1);
        System.out.println(test);
        System.out.println(test.indexOf(3));

    }
}
