import java.util.Arrays;

public class CountingSort {

    // k is the range of numbers in A
    public static int[] sort(int[] A, int k){
        int[] B = new int[A.length];
        int[] C = new int[k];
        for(int i = 0; i < k; i++){
            C[i] = 0;
        }
        for(int j = 1; j < A.length; j++){
            C[A[j]] = C[A[j]] + 1;
        }

        for(int i = 1; i < k; i++){
            C[i] = C[i] + C[i-1];
        }

        for(int j = A.length-1; j >= 0; j--){
            B[C[A[j]]] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] test = {2,5,3,0,2,3,0,3};
        int[] res = sort(test,6);
        System.out.println(Arrays.toString(res));
    }
}
