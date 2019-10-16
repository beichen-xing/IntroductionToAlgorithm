import java.util.Arrays;

public class DynamicProgrammingCutRod {

// Time Complexity O(2^n)
    public static int recur(int[] price, int n){
        if(n == 0){
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            q = Math.max(q,price[i-1] + recur(price,n-i));
        }
        return q;
    }

// top-down with memoization
    public static int memdp(int[] price, int n){
        int[] r = new int[price.length+1];
        for(int i = 0; i < r.length; i++){
            r[i] = Integer.MIN_VALUE;
        }
        return memdpaux(price,n,r);
    }

    public static int memdpaux(int[] price, int n, int[] r) {
        int q;
        if(r[n] >= 0){
            return r[n];
        }
        if(n == 0){
            q = 0;
        }else{
            q = Integer.MIN_VALUE;
            for(int i = 1; i <=n; i++){
                q = Math.max(q,price[i-1]+memdpaux(price,n-i,r));
            }
        }
        r[n] = q;
        return q;
    }

// bottom-up
    public static int botup(int[] price, int n){
        int[] r = new int[price.length+1];
        r[0] = 0;
        int q;
        for(int j = 1; j <= n; j++){
            q = Integer.MIN_VALUE;
            for(int i = 1; i <= j; i++){
                q = Math.max(q,price[i-1]+r[j-i]);
            }
            r[j] = q;
        }
        return r[n];
    }

// bottom-up saving result of the first cut length
    public static int[] botupnew(int[] price, int n){
        int[] r = new int[price.length+1];
        int[] s = new int[price.length+1];
        int q;
        r[0] = 0;
        for(int j = 1; j <= n; j++){
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++){
                if(q < price[i-1] + r[j-i]){
                    q = price[i-1] + r[j-i];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
        return s;
    }

    public static void main(String[] args) {
        int[] test = {1,5,8,9,10,17,17,20,24,30};
        System.out.println(recur(test,9));
        System.out.println(memdp(test,4));
        System.out.println(botup(test,4));
        System.out.println(Arrays.toString(botupnew(test,9)));
    }
}
