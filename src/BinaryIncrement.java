import java.util.Arrays;
import java.util.Stack;

public class BinaryIncrement {

//Amortized analysis: A[i] turn for n/2^i numbers. Average will be O(n)/n = O(1)
    public static int[] increment(int[] A){
        int i = A.length-1;
        while(i >= 0 && A[i] == 1){
            A[i] = 0;
            i = i-1;
        }
        if(i >= 0){
            A[i] = 1;
        }
        return A;
    }

// Multipop for Stack: Cost will be O(n)/n = O(1) on average
    public static void multipop(Stack s, int k){
        while (!s.isEmpty() && k > 0){
            s.pop();
            k = k-1;
        }
    }

    public static void main(String[] args) {
        int[] test = {0,0,0,0,0,1,1};
        System.out.println(Arrays.toString(increment(test)));

        Stack<Integer> test1 = new Stack<>();
        test1.push(1);
        test1.push(2);
        test1.push(3);
        System.out.println(test1);
        multipop(test1,2);
        System.out.println(test1);
    }
}
