import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class BucketSort {

    // suitable for uniform distribution of input
    public static List<Double> sort(double[] A){
        int n = A.length;
        Hashtable<Integer,ArrayList<Double>> B = new Hashtable<>();
        ArrayList<Double> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            B.put(i,new ArrayList<Double>());
        }
        for(int i = 0; i < n; i++){
            ArrayList<Double> newList = B.get((int) Math.floor(n*A[i]));
            newList.add(A[i]);
            B.put((int) Math.floor(n*A[i]),newList);
        }

        for(int i = 0; i < n; i++){
            ArrayList<Double> newList = B.get(i);
            Collections.sort(newList);
            res.addAll(newList);
        }
        return res;
    }

    public static void main(String[] args) {
        double[] test = {0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
        System.out.println(sort(test));
    }
}
