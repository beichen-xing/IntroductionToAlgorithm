import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyActivitySelector {
// Recursive
    static int[] res = new int[12];
    public static int[] RactivitySelector(int[] s, int[] f, int k, int n){
        int m = k+1;
        while(m <= n && s[m] < f[k]){
            m = m+1;
        }
        if(m <= n){
            res[m] = 1;
            RactivitySelector(s,f,m,n);
            return res;
        }
        return null;
    }

// Iterator rewrite
    public static int[] IactivitySelector(int[] s, int[] f){
        int N = s.length;
        int k = 0;
        for(int m = 1; m < N; m++){
            if(s[m] >= f[k]){
                res[m] = 1;
                k = m;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = {0,1,3,0,5,3,5,6,8,8,2,12};
        int[] test2 = {0,4,5,6,7,9,9,10,11,12,14,16};
        System.out.println(Arrays.toString(RactivitySelector(test1,test2,0,11)));
        System.out.println(Arrays.toString(IactivitySelector(test1,test2)));
    }
}
