import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();

        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test);

    // More recent, more less
        int index = test.search(3);
        System.out.println(index);

        int top = test.peek();
        System.out.println(top);

        test.pop();
        System.out.println(test);
    }
}
