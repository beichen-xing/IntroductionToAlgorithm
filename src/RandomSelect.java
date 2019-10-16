public class RandomSelect {
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

    public static int select(int[] A, int p, int r, int i){
        if(p == r){
            return A[p];
        }
        int q = Randompartition(A,p,r);
        int k = q-p+1;
        if(i == k){
            return A[q];
        }
        else if(i < k){
            return select(A,p,q-1,i);
        }
        else{
            return select(A,q+1,r,i-k);
        }
    }

    public static void main(String[] args) {
        int[] test = {2,3,4,1,6,7,5};
        System.out.println(select(test,0,6,4));
    }
}
