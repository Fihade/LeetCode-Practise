import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class dictSolution {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int sIndex = 0, tIndex = 0; tIndex < tt.length; tIndex++, sIndex++) {
            if (!map.containsKey(ss[sIndex])) {
                if (!map.containsValue(tt[tIndex])) {
                    map.put(ss[sIndex], tt[tIndex]);
                } else {
                    return false;
                }
            }
            if (!map.get(ss[sIndex]).equals(tt[tIndex])) {
                return false;
            }
            continue;
        }
        return true;
    }
    public static String frequencySort(String s) {
        String result = new String("");
        StringBuilder stringBuilder = new StringBuilder();

        char[] ss = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i<ss.length;i++){
            if (!map.isEmpty()&&map.containsKey(ss[i])){
                map.put(ss[i],map.get(ss[i])+1);
            }else{
                map.put(ss[i],1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>(){

            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if(o1.getValue()>o2.getValue()) return -1;
                else if(o1.getValue()<o2.getValue()) return 1;
                else
                    return 0;
            }

        });
        int i=0;
        for(Map.Entry<Character, Integer> entry:list) {
            for(i=0;i<entry.getValue();i++) {
                stringBuilder.append(entry.getKey());
            }
        }
        result = stringBuilder.toString();
        System.out.println(result);
        return result;
    }
//    给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
//    你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
    //递归
    public static int rect_op(int[] a,int i){
        if(i == 0) return a[0];
        else if (i == 1) return Math.max(a[0],a[1]);
        else return Math.max(rect_op(a,i-1),rect_op(a,i-2)+a[i]);
    }
    //dp
    public static int[] dp_opt(int[] array){
        int[] opt = new int[1000];
        opt[0] = array[0];
        opt[1] = Math.max(array[0],array[1]);
        for (int i = 2;i<array.length;i++){
            int a = opt[i-1];
            int b = opt[i-2] + array[i];
            opt[i] = Math.max(a,b);
        }
        return opt;
    }
    //dp_fibonacci
    public static int dp_fibonacci(int a){
        int[] opt = new int[10000];
        opt[0] = 0;
        opt[1] = 1;
        opt[2] = 1;
        for (int i = 3;i<=100;i++){
            opt[i] = opt[i-1] + opt[i-2];
        }
        return opt[a];
    }
    //两数之和为target
    //递归
    public static boolean rect_subset(int[] a,int i,int s){
        if (s == 0){
            return true;
        }
        else if ( i == 0){
            return a[i] == s;
        }
        else {
            boolean aa = rect_subset(a,i-1,s-a[i]);
            boolean bb = rect_subset(a,i-1,s);
            return aa || bb;
        }
    }
    //dp
    public static boolean subset(int[] a,int s){
        boolean[][] opt = new boolean[a.length][s+1];
        for (int i = 0;i<s;i++){
            if (a[0] == i){
                opt[0][i] = true;
            }else {
                opt[0][i] = false;
            }
        }
        for (int i = 0;i<a.length;i++){
            opt[i][0] = true;
        }
        for (int i = 1;i<a.length;i++){
            for (int j = 1;j<s+1;j++){
                if (a[i] > s){
                    opt[i][s] = opt[i-1][s];
                }else {
                    boolean aa = opt[i-1][s];
                    boolean b = opt[i-1][s-a[i]];
                    opt[i][s] = aa || b;
                }
            }
        }
        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<s;j++) {
                log(opt[i][j] + "");

            }
            log("-------------------------");
        }
        return opt[a.length-1][s];
    }
    //数组最大数之和
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        // 最后这一步，是求一个全局的最优值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    //跳跃游戏
    public static boolean canJump(int[] nums){
        int n = nums.length;
        boolean[] canreach = new boolean[n];
        canreach[n-1] = true;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] >= (n - 1 - i)){
                canreach[i] = true;
                continue;
            }
            for(int j = i; j < n-1; j++){
                if(canreach[j] && (j - i) <= nums[i] ){
                    canreach[i] = true;
                    continue;
                }

            }
        }
        return canreach[0];
    }
    //买卖股票最大利润
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1;i<prices.length;i++){
            int cha = prices[i] - prices[i-1];
            if (cha >= 0 ) maxprofit += cha;
        }
        return maxprofit;
    }
    public static void log(String v){
        System.out.println(v);
    }
    public static void main(String[] args){
//        frequencySort("tree");
//        int[] a = {1,2,4,1,7,8,3};
//        System.out.println(rect_op(a,6));
//        int[] b = dp_opt(a);
//        for (int i = 0;i<a.length;i++) {
////            System.out.println(b[i]);
//        }
//        System.out.println(dp_fibonacci(10));
        int[] a = {3,34,4,12,5,2};
//        System.out.println(rect_subset(a,a.length-1,10));
//        System.out.println(subset(a,9));
        int[] num = {-2,1,-3,4,-1,2,1,-5,4};
//        log(maxSubArray(num)+"");
        int[] nums = {2,3,1,1,4};
        log(canJump(nums) + "");
    }
}
