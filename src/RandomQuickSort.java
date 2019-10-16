import java.util.Arrays;

public class RandomQuickSort {

    public static int Randompartition(int[] A, int p, int r){
        int rand = (int)(Math.random()*(r-p+1)) + p;
        int tempRand = A[rand];
        A[rand] = A[r];
        A[r] = tempRand;
        int x = A[r];
        int i = p-1;
        for(int j = p; j < r; j++){
            if(A[j] <= x){
                i = i+1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        return i+1;
    }

    public static int[] sort(int[] A, int p, int r){
        if(p < r){
            int q = Randompartition(A, p, r);
            sort(A, p, q-1);
            sort(A, q, r);
        }

        return A;
    }

    public static void main(String[] args) {
        int[] test = {2,8,7,1,3,5,6,4};
        //System.out.println(partition(test,0,7));
        System.out.println(Arrays.toString(sort(test,0,7)));
    }
}
