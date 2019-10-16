import java.util.Arrays;

public class PriorityQueue {

    public int maxItem(int[] A){
        BuildHeap b = new BuildHeap();
        int[] res = b.build(A);
        return res[0];
    }

    public int extractMax(int[] A) {
        BuildHeap b = new BuildHeap();
        MaxHeapify m = new MaxHeapify();
        int[] res = b.build(A);
        int max = res[0];
        res[0] = res[A.length - 1];
        m.Heapify(res, 1, A.length - 1);
        System.out.println(Arrays.toString(A));
        return max;
    }

    public int[] increaseKey(int[] A, int i, int k){
        BuildHeap b = new BuildHeap();
        MaxHeapify m = new MaxHeapify();
        int[] res = b.build(A);

        res[i-1] = k;
        while (i > 1 && res[(i-1)/2] < res[i-1]){
            int temp = res[i-1];
            res[i-1] = res[(i-1)/2];
            res[(i-1)/2] = temp;
            i = 1 + (i-1)/2;
        }
        return res;
    }

    // Since I don't inplement heapsize in Heap, this operation will become O(n) But it should be O(log(n))
    public int[] heapInsert(int[] A, int k){
        int[] res = new int[A.length+1];
        System.arraycopy(A,0,res,0,A.length);
        res[A.length] = Integer.MIN_VALUE;
        increaseKey(res,A.length+1,k);
        return res;
    }

    public static void main(String[] args) {
        int[] test = {16,4,10,14,7,9,3,2,8,1};
        PriorityQueue pq = new PriorityQueue();
        System.out.println(pq.maxItem(test));
        System.out.println(pq.extractMax(test));
        System.out.println(Arrays.toString(pq.increaseKey(test, 10,12)));
        System.out.println(Arrays.toString(pq.heapInsert(test,11)));
    }


}
