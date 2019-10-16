import java.util.Arrays;

public class HeapSort {

    public static int[] sort(int[] A){
        BuildHeap b = new BuildHeap();
        MaxHeapify m = new MaxHeapify();
        b.build(A);


        for(int i = A.length; i >= 2; i--){
            int temp = A[0];
            A[0] = A[i-1];
            A[i-1] = temp;
            System.out.println(Arrays.toString(A));
            m.Heapify(A,1,i-1);
        }
        System.out.println(Arrays.toString(A));
        return A;
    }
    public static void main(String[] args) {
        int[] test = {16,4,10,14,7,9,3,2,8,1};
        sort(test);
    }
}
