import java.util.Arrays;

// Before heapify, I believe that we should check all subtrees if or not it is already a heap
// Since situation like: level1: need; level2: don't need; level3: need; this method will break in level2
class Heap{

    public int getParent(int i){
        return i/2;
    }

    public int getLeft(int i){
        return 2*i;
    }

    public int getRight(int i){
        return 2*i+1;
    }

}

public class MaxHeapify {
    static Heap h = new Heap();
    static int largest;

    public static int[] Heapify(int[] A, int i, int size){
        int l = h.getLeft(i);
        int r = h.getRight(i);

        // compare
        if(l <= size && A[l-1] > A[i-1]){
            largest = l;
        }else{
            largest = i;
        }
        if(r <= size && A[r-1] > A[largest-1]){
            largest = r;
        }
        //exchange
        if(largest != i){
            int temp = A[i-1];
            A[i-1] = A[largest-1];
            A[largest-1] = temp;
            //System.out.println(Arrays.toString(A));
            Heapify(A,largest,size);
        }
        return A;
    }



    public static void main(String[] args) {
        int[] test = {4,14,7,2,8,1};
        Heapify(test,1,test.length);
        //System.out.println(Arrays.toString(test));
    }
}
