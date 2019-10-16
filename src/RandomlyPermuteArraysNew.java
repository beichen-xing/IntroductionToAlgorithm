import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

// use comparator and lambda
public class RandomlyPermuteArraysNew {

    public static void main(String[] args) {
        Integer[] A = new Integer[]{1, 2, 3, 4};
        int n = A.length;
        int[] P = new int[n];
        Random rand = new Random();
        int bound = (int) Math.pow(n, 3);
        for (int i = 0; i < n; i++) {
            int r = rand.nextInt(bound);
            P[i] = r;
        }

        // from stackoverflow (firstly convert to list)
            //List<Integer> newA = Arrays.asList(A);
            //List<Integer> sorted = new ArrayList<>(newA);
            //Collections.sort(sorted, Comparator.comparingInt(x -> P[newA.indexOf(x)]));
            //String[] newSorted = sorted.toArray(new String[0]);

        //Arrays.sort(A, (x,y) -> P[Arrays.asList(A).indexOf(x)] - P[Arrays.asList(A).indexOf(y)] );
        Arrays.sort(A, Comparator.comparingInt(x -> P[Arrays.asList(A).indexOf(x)]));

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(P));
        System.out.println(Arrays.toString(A));

    }
}
