public class HouseRobber {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]);
        }
        int k=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>dp[k])k=i;
        }
        return dp[k];

    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums)+"");
    }
}
