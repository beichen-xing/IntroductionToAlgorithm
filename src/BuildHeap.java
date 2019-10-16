import java.util.Arrays;

// check from bottom-up to build a tree
public class BuildHeap {
    static MaxHeapify m = new MaxHeapify();
    public static int[] build(int[] A){

        for(int i = A.length/2; i >= 1; i--){
            m.Heapify(A,i,A.length);
        }
        System.out.println(Arrays.toString(A));
        return A;
    }

    public static void main(String[] args) {
        int[] test = {16,4,10,14,7,9,3,2,8,1};
        build(test);
    }
}
