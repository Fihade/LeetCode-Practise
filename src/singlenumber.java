import java.util.Arrays;

public class singlenumber {
    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0;i<nums.length;i++){
            //异或
            num ^= nums[i];
        }
        return num;
    }
    public static void main(String[] args){
        int[] num = {4,1,2,1,2};
        System.out.println(singleNumber(num)+"");
    }
}
