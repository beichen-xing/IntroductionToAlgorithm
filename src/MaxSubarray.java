import java.util.Arrays;

// This code may just suit for even length(due to my method in brute-force)

public class MaxSubarray {

    public static int[] bruteforce(int[] A){
        int[] res = new int[3];
        int max = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length;j++){
                if(A[j]-A[i] > max) {
                    max = A[j] - A[i];
                    res[0] = i;
                    res[1] = j;
                    res[2] = max;
                }
            }
        }
        return res;
    }

    public static int[] maxCrossSubarray(int[] A){
        int[] res = new int[3];
        int mid = A.length/2;
        int[] resLeft = new int[3];
        resLeft[0] = resLeft[1] = mid;
        int sumLeft = 0;
        for(int m = mid; m >= 0; m--){
            if(A[mid] - A[m] > sumLeft){
                sumLeft = A[mid] - A[m];
                resLeft[0] = m;
                resLeft[2] = sumLeft;
            }
        }
        int[] resRight = new int[3];
        resRight[0] = resRight[1] = mid;
        int sumRight = 0;
        for(int n = mid; n < A.length; n++){
            if(A[n] - A[mid] > sumRight){
                sumRight = A[n] - A[mid];
                resRight[1] = n;
                resRight[2] = sumRight;
            }
        }
        res[0] = resLeft[0];
        res[1] = resRight[1];
        res[2] = sumLeft + sumRight;
        return res;
    }

    public static int[] maxSubarray(int[] A, int low, int high){
        if(low + 1 == high){
            return new int[]{low, high, A[high]-A[low]};
        } else{
             int mid = (low + high) / 2;
            int[] resLeft = maxSubarray(A,low,mid);
            int[] resRight = maxSubarray(A,mid+1,high);
            int[] crossSet = Arrays.copyOfRange(A, low, high+1);
            int resCross = maxCrossSubarray(crossSet)[2];

            if(resLeft[2] >= resRight[2] && resLeft[2] >= resCross){
                return resLeft;
            }else if(resRight[2] >= resLeft[2] && resRight[2] >= resCross) {
                return resRight;
            }else{
                return maxCrossSubarray(crossSet);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90};
        //System.out.println(Arrays.toString(bruteforce(test)));
        //System.out.println(Arrays.toString(maxCrossSubarray(test)));
        //int[] test = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90};
        //int[] test = {1,2,3,4,5,6,7,14};
        System.out.println(Arrays.toString(maxSubarray(test,0,test.length-1)));
    }
}
