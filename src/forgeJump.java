import java.util.Scanner;

public class forgeJump {
    public static int path(int a,int b){
//        int[][] m = new int[b-a+1][b-a+1];
//        for (int i = 0; i<b-a+1; i++){
//            for (int j = i; j<b-a+1; j++){
//                m[i][j] = 1;
//            }
//        }
//        for (int i = 0; i<=b-a; i++){
//            for (int j = i+2; j<b-a; j++){
//                m[i][j] = m[i][i+1] * m[i+1][j] + 1;
//            }
//        }
//
//        return m[0][b-a] + 1;

        int[] path = new int[b-a+1];
        path[0] = 1;
        path[1] = 1;

        for (int i = 2;i<path.length;i++){
            path[i] = path[i-1] + path[i-2];
        }

        return path[path.length - 1];
    }

    public static void main(String[] args){
//        System.out.println(path(1,3)+"");
        Scanner scanner = new Scanner(System.in);
        while(scanner != null){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(path(a,b));
        }
//        System.out.println(path(1,10));

    }
}
