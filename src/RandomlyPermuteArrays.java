import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

// use a super class
public class RandomlyPermuteArrays{
    int a;
    int p;

    public RandomlyPermuteArrays(int a, int p){
        this.a = a;
        this.p = p;
    }
}


class RandomSorted{
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int n = A.length;
        int[] P = new int[n];
        Random rand = new Random();
        int bound = (int)Math.pow(n,3);
        for (int i = 0; i < n; i++){
        int r = rand.nextInt(bound);
        P[i] = r;
        }

        Integer[] sorted =IntStream.range(0,P.length)
                .mapToObj(i -> new RandomlyPermuteArrays(A[i], P[i]))
                .sorted(Comparator.comparingInt(r -> r.p))
                .map(r -> r.a)
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(P));
        System.out.println(Arrays.toString(sorted));
        }

}

