import java.util.Arrays;

public class rotate {
    public static void rotate(int[] nums, int k) {
        int i = 0;
        while (i<k){
            int index = i + k;
            while (index < nums.length - 1){
                int temp = nums[i];
                int temp1 = nums[index];
                nums[index] = temp;
                index += k;
            }
            i++;
        }
        //solution 2
        k = k % nums.length;
        int[] temp = Arrays.copyOf(nums, nums.length-k);
        for(int j = 0; j < k; j++){
            nums[j] = nums[nums.length - k + j];
        }
        for(int j = k; j < nums.length; j++){
            nums[j] = temp[j - k];
        }


        for (int num : nums){
            System.out.println(num);
        }

    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
    }
}
