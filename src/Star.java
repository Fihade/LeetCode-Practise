import java.util.Scanner;

public class Star {
    private int n,left,right;
    void getPoint(int n){
        this.n = n;
    }

    int getLeft(){
        if (n < 4){
            left = n + 5;
        }
        if (n > 3){
            left = n - 3;
        }
        return left;
    }

    int getRight(){
        if (n < 6) right = n + 3;
        if (n > 5) right = n - 5;
        return right;
    }

    public static void main(String[] args){
        Star star = new Star();
        int n,left,right;
        System.out.println("请输入从那个点开始");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0;i<7;i++){
            star.getPoint(n);
            left = star.getLeft();
            right = star.getRight();
            System.out.println(n+" -> "+right);
            n = left;
        }
    }
}
