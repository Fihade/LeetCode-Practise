import static java.lang.Math.max;

public class ZerOneBag {
    public static void bag(){
        final int N = 15;
        int[] v={0,8,10,6,3,7,2};
        int[] w={0,4,6,2,2,5,1};
        int[][] m = new int[N][N];
        int c = 12;
        int n = 6;
        for (int i = 1;i<=n;i++){
            for (int j = 0;j <= c;j++){
                if (j > w[i]){
                    m[i][j] = max(m[i-1][j-w[i]]+v[i],m[i-1][j]);
                }else {
                    m[i][j] = m[i-1][j];
                }
            }
        }
        System.out.println(m[n][c]);

    }
    public static void bagg(int[] dp){

        int[] p={0,8,10,6,3,7,2};
        int[] w={0,4,6,2,2,5,1};
        for(int i=1;i<=w.length-1;i++)
            for(int j=12;j>0;j--)
            {
                dp[j]=w[i]<=j?max(dp[j-w[i]]+p[i],dp[j]):dp[j];
            }

    }
//    public static void bag1(){
//        int[] v={0,8,10,6,3,7,2};
//        int[] w={0,4,6,2,2,5,1};
//        int[] f=new int[v.length+1];
//        for ()
//    }
    public static void sum(){
        int m = 15;
        int n = 5;
        int[] num = {5,5,10,2,3};
        int[][] dp = new int[1000][1000];
        for (int i = 1;i<n;i++){
            for (int j = 1;j<=m;j++){
                if (j == num[i]) {
                    dp[i][j] = dp[i-1][j] + 1;
                }
                if (j > num[i]){
                    dp[i][j] = dp[i-1][j-num[i]] + dp[i-1][j];
                }else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][m]);
    }
    public static void main(String[] args){
        int[] dp = new int[1000];
//        bagg(dp);
//        System.out.println(dp[12]);
        sum();
    }
}
