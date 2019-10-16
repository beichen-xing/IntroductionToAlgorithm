public class DpMaxCommonString {

    public static int lcs(char[] A, char[] B){
        int m = A.length;
        int n = B.length;

        int[][] b = new int[m+1][n+1];
        int[][] c = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            c[i][0] = 0;
        }
        for(int j = 0; j <= n; j++){
            c[0][j] = 0;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(A[i-1] == B[j-1]){
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 1;
                }else if(c[i-1][j-1] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3;
                }
            }
        }
        return c[m][n];
    }

    public static int[][] lcsReconstruct(char[] A, char[] B){
        int m = A.length;
        int n = B.length;

        int[][] b = new int[m+1][n+1];
        int[][] c = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            c[i][0] = 0;
        }
        for(int j = 0; j <= n; j++){
            c[0][j] = 0;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(A[i-1] == B[j-1]){
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 1;
                }else if(c[i-1][j-1] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3;
                }
            }
        }
        return b;
    }
    public static void printLcs(int[][] b, char[] X, int i, int j){
        if(i == 0 || j == 0){
            return;
        }
        if(b[i][j] == 1){
            printLcs(b,X,i-1,j-1);
            System.out.println(X[i-1]);
        }else if(b[i][j] == 2){
            printLcs(b, X, i-1, j);
        }else{
            printLcs(b, X, i, j-1);
        }
    }

    public static void main(String[] args) {
        char[] test1 = {'A','B','C','B','D','A','B'};
        char[] test2 = {'B','D','C','A','B','A'};
        System.out.println(lcs(test1,test2));

        int[][] b = lcsReconstruct(test1,test2);
        printLcs(b,test1,test1.length,test2.length);

    }


}
