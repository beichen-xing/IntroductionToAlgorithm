public class MatrixChainOrder {

// O(n^3) to find the best split point

    public static int[][] calAmountsMatrx(int[] p){
        int N = p.length - 1;
        int[][] m = new int[N+1][N+1];
        int[][] s = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            m[i][i] = 0;
        }

        int q;

        for(int l = 2; l < N+1; l++){
            for(int i = 1; i < N-l+2; i++){
                int j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if(q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        return m;
    }

    public static int[][] splitMatrx(int[] p){
        int N = p.length - 1;
        int[][] m = new int[N+1][N+1];
        int[][] s = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            m[i][i] = 0;
        }

        int q;

        for(int l = 2; l < N+1; l++){
            for(int i = 1; i < N-l+2; i++){
                int j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if(q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        return s;
    }

// Recursive method with memo

    public static int lookup(int[][] m, int[] p, int i, int j){
        if (m[i][j] < Integer.MAX_VALUE){
            return m[i][j];
        }

        int q;
        if(i == j){
            m[i][j] = 0;
        }else{
            for(int k = i; k <= j-1; k++){
                q = lookup(m,p,i,k) + lookup(m,p,k+1,j) + p[i-1]*p[k]*p[j];
                if(q < m[i][j]){
                    m[i][j] = q;
                }
            }
        }
        return m[i][j];
    }

    public static int memoMatrixChain(int[] p){
        int N = p.length;
        int[][] m = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                m[i][j] = Integer.MAX_VALUE;
            }
        }
        return lookup(m,p,1,N-1);
    }

    public static void main(String[] args) {
        int[] test = {30,35,15,5,10,20,25};

        // m[i][j] here means the least amount of calculation about A1...A6
        System.out.println(calAmountsMatrx(test)[1][6]);

        // s[i][j] gives the best split point of Ai...Aj
        System.out.println(splitMatrx(test)[1][6]);

        System.out.println(memoMatrixChain(test));
    }
}
