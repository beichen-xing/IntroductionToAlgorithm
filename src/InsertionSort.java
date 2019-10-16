import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int key = A[i];

            for(int j = i-1;j >= 0; j--){
                if(A[j] > key){
                    A[j+1] = A[j];
                    A[j] = key;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] test = {1,4,7,9,3,2,2,45,5,89,6};
        System.out.println(Arrays.toString(insertionSort(test)));
    }
}
