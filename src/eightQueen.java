import java.util.Date;
import java.util.Scanner;

public class eightQueen {
    private static short N = 0;
    private static int count=0;
    private eightQueen(short N){
        eightQueen.N = N;
    }
    private static void putRow(short[][] chess, int row){
        if(row == N){
            count++;
            System.out.println("No "+count);
            for(int i = 0;i<N;i++){
                for(int j = 0;j<N;j++){
                    System.out.print(chess[i][j] + " ");
                }
                System.out.println();
            }
        return;
        }
        short[][] chessTemp = chess.clone();
        //摆放这一行后删除之前的存放值
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                chessTemp[row][j]=0;
            chessTemp[row][i]=1;

            if( isSafety( chessTemp,row,i ) ){
                putRow(chessTemp,row+1);
            }
        }
    }
    private static boolean isSafety(short[][] chess, int row, int col){
        int step = 1;
        while(row - step >= 0){
            if(chess[row-step][col]==1)                //中上
                return false;
            if(col-step>=0 && chess[row-step][col-step]==1)        //左上
                return false;
            if(col+step<N && chess[row-step][col+step]==1)        //右上
                return false;
            step++;
        }
        return true;
    }

    public static void main(String[] args){
        Date begin = new Date();
        Scanner scanner = new Scanner(System.in);
        short N = scanner.nextShort();
        short chess[][] = new short[N][N];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                chess[i][j] = 0;
            }
        }
        eightQueen eightQueen = new eightQueen(N);
        eightQueen.putRow(chess,0);
        Date end = new Date();
        System.out.println("耗时："+ String.valueOf(end.getTime() - begin.getTime()) + " ms");
    }
}
