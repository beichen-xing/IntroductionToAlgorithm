import java.util.Arrays;


public class RandomizeInPlace {

    public static void main(String[] args) {
        int[] A = new int[]{1,2,9,6,3};
        for(int i = 0; i < A.length; i++){
            int r = (int)(Math.random()*((A.length-i)+1));
            int temp;
            temp = A[i];
            A[i] = A[r];
            A[r] = temp;
        }
        System.out.println(Arrays.toString(A));
    }
}
