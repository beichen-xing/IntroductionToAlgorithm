import java.util.Arrays;

public class MaxSubarrayNew {
    public static int[] crossingSubarray(int[] A, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int sum0 = 0;
        int maxLeft = mid;
        for(int i = mid; i >= low; i--){
            sum0 += A[i];
            if(sum0 > leftSum){
                leftSum = sum0;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        int sum1 = 0;
        int maxRight = mid+1;
        for(int j = mid+1; j <= high; j++){
            sum1 += A[j];
            if(sum1 > rightSum){
                rightSum = sum1;
                maxRight = j;
            }
        }
        return new int[]{maxLeft,maxRight,leftSum+rightSum};
    }

    public static int[] maxSubarray(int[] A, int low, int high){
        if(high == low){
            return new int[]{low, high, A[low]};
        } else {
            int mid = (low + high) / 2;
            int[] resLeft;
            int[] resRight;
            int[] resCross;

            resLeft = maxSubarray(A, low, mid);
            resRight = maxSubarray(A, mid + 1, high);
            resCross = crossingSubarray(A, low, mid, high);

            if (resLeft[2] >= resRight[2] && resLeft[2] >= resCross[2])
                return resLeft;
            else if (resRight[2] >= resLeft[2] && resRight[2] >= resCross[2])
                return resRight;
            else
                return resCross;
        }
    }

    public static void main(String[] args) {
        int[] raw = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
        int[] test = new int[raw.length];
        for(int i = 1; i < raw.length; i++){
            test[0] = 0;
            test[i] = raw[i] - raw[i-1];
        }
        //System.out.println(Arrays.toString(bruteforce(test)));
        //System.out.println(Arrays.toString(maxCrossSubarray(test)));
        //int[] test = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90};
        //int[] test = {1,2,3,4,5,6,7,14};
        System.out.println(Arrays.toString(maxSubarray(test,0,test.length-1)));
    }

}
