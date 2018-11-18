import java.util.Arrays;

public class test {
    public static boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        int i = 0;
        int j = 0;
        if (ss.length != tt.length)
            return false;
        while(i<ss.length&&j<tt.length){
            if(ss[i] != tt[j]){
                return false;
            }
            break;

        }
        return true;
    }

    //最长递增子序列
    public static void dizeng(){
        char[] a = {'a','b','k','l','m','n','c','d','e','f','g'};
        int length = a.length;
        int ans = 1;
        int b;
        int[] sum = new int[a.length];
        for (int i=0;i<length;i++){
            sum[i] = 1;
        }
        for (int i = 1;i<length;i++){
            b = 0;
            ans = 0;
            for (int j = 0;j<i;j++){
                if (a[j]<a[i]){
                    ans = Math.max(ans,sum[j]);
                    b = 1;
                }
            }

            if (b!=0){
                sum[i] = ans + 1;
            }
        }

        for (int i = 0;i<length;i++){
            ans = Math.max(1,sum[i]);
        }

        System.out.println(ans+"");
    }

    public static int buttom_up_cut(int[] p){
        int[] r = new int[p.length+1];
        for(int i = 1;i<p.length;i++){
            int q = -1;
            for(int j = 1;j<=i;j++){
                q = Math.max(q, p[j-1]+r[i-j]);
            r[i] = q;
            }
            return r[p.length];
        }
        return 0;
    }

    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        System.out.print(minprice);
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args){
        // System.out.println(isAnagram("a","ab"));
        int[] p = {1,5,8,9,10,17,17,20,24,30};
        int[] price = {7, 1, 5, 3, 6, 4};
        dizeng();
//        System.out.print(maxProfit(price));
        // System.out.print(buttom_up_cut(p));
    }
}
