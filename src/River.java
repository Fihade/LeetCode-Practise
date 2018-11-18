import java.util.Arrays;

public class River {
    public static void main(String [] args){
        int[] a = {1,2,5,9,10};
        int[] b = {1,4,6,7};
        System.out.println("{1,2,5,9,10}的最小时间为:");
        System.out.println(sumMin(a));
        System.out.println("{1,4,6,7}的最小时间为:");
        System.out.println(sumMin(b));

    }
    public static int sumMin(int[] num){
        Arrays.sort(num);
        int Min = num[0];
        int result = 0;
        for (int i = 1;i<num.length;i++){
            if (i==num.length-1) 
                result += num[i];
            else 
                result += Min + num[i];
        }

        int maxFlag = num.length - 1;
        int result1 = 0;
        int length = num.length;
        while (length >= 4){
            int min = num[0];
            int secmin = num[1];
            int max = num[maxFlag];
            result1 += secmin + min + max + secmin;
            maxFlag -= 2;
            length -= 2;
        }

        if (length == 2) result1 += num[1];
        if (length == 3) result1 += num[maxFlag] + num[0] + num[1];
        return Math.min(result,result1);
    }

}
