import java.util.Scanner;

public class jiecheng {
    static int[] m = new int[10000];
    public static void jie(int n){
        for (int i = 2;i<m.length;i++){
            m[i] = 0;
        }
        m[0] = 1;
        m[1] = 1;
        for (int j = 2;j<n;j++){
            int i = 1;
            int c = 0;
            for (;i<m[0];i++){
                m[i] = m[i] * j + c;//将来自低位的计算结果和本位的结果相加
                c = m[i] / 10;
                m[i] = m[i] % 10;
            }
            for (;c!=0;i++){
                m[i] = c % 10;
                c = c / 10;
            }
            m[0] = i - 1;
        }
    }
//    public static int fac(int a){
//        for (int i = 1;i<a;i++){
//
//        }
//    }
    public static void main(String[] args){
//        int a;
//        Scanner scanner = new Scanner(System.in);
//        a = scanner.nextInt();
//        System.out.println(fac(a));
        jie(1000);
        int count = 0;
        for (int i = m[0];i>0;i--){
            count ++;
            System.out.print(m[i]);
        }
        System.out.println(count);

        for (int num:m){
            System.out.print(num);
        }
    }
}
