import java.util.Arrays;

public class MergeSort {
    public static int[] mergesort(int[] input){

        if (input.length > 1){
            int len = input.length / 2;
            int[] left = Arrays.copyOfRange(input,0,len);
            int[] right = Arrays.copyOfRange(input,len,input.length);
            left = mergesort(left);
            right = mergesort(right);
            return merge(left,right);
        }
        return input;
    }


    public static int[] merge(int[] A,int[] B){
        int p = A.length;
        int q = B.length;
        int[] res = new int[p+q];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < p && j < q){
            if(A[i] <= B[j]){
                res[k] = A[i];
                i += 1;
                k += 1;
            }else{
                res[k] = B[j];
                j += 1;
                k += 1;
            }
        }

        while(i == p && k < p+q){
            res[k] = B[j];
            j += 1;
            k += 1;
        }

        while(j == p && k < p+q) {
            res[k] = A[i];
            i += 1;
            k += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,4,7,9,3,2,2,45,5,89,6};
        System.out.println(Arrays.toString(mergesort(test)));
    }
}
