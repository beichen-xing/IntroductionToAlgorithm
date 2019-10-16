import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> test = new LinkedList<>();

        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test);

        int top = test.peek();
        System.out.println(top);
        System.out.println(test);

        int newtop = test.poll();
        System.out.println(newtop);
        System.out.println(test);

    // Test Deque
        Deque<Integer> dqtest = new LinkedList<>();

        dqtest.add(1);
        dqtest.add(2);
        dqtest.add(3);
        dqtest.addAll(test);
        System.out.println(dqtest);
        System.out.println(dqtest.getFirst());
        System.out.println(dqtest.getLast());
    }
}
