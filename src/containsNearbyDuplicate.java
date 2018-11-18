import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class containsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                int sub = i - hm.get(nums[i]);
                if(sub <= k)
                    return true;
                else
                    hm.put(nums[i],i);
            }
            else
                hm.put(nums[i],i);
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i =0;i<nums.length;i++){
            if (hashMap.containsKey(nums[i] - k) && (Math.abs(hashMap.get(nums[i] - k) - i) == t || Math.abs(hashMap.get(nums[i] + k) - i) == t)) {
                return true;
            }else hashMap.put(nums[i],i);
        }
        return false;
    }


    public class ContainsNearbyAlmostDuplicate_2 {
        public Boolean containsNearbyAlmostDuplicate(int[] nums,int k,int t) {
            if(k<1||t<0||nums.length<=1) return false;

            SortedSet<Long> set=new TreeSet<Long>();
            for(int i=0;i<nums.length;i++) {
                Set<Long> subSet=set.subSet((long) nums[i]-t,(long) nums[i]+t+1);
                if(!subSet.isEmpty()) return true;
                if(i>=k) set.remove((long) nums[i-k]);
                set.add((long) nums[i]);
            }

            return false;
        }

    }

    public static boolean ContainsNearbyAlmostDuplicate_3(int[] nums,int k,int t){
        int i = 0;
        int j = k;
        if(k<1||t<0||nums.length<=1) return false;

        for (int m = 0;m<nums.length-k;m++){
            if (Math.abs(nums[i] - nums[j]) <= t){
                return true;
            }
            else k++;
        }

        return false;
    }


    public static void main(String[] args){
        int[] num  = {1,2,3,1};
        int[] nums = {1,0,1,1};
        int k = 1, t = 2;
//        System.out.println(containsNearbyDuplicate(num,3) +"");
        System.out.println(ContainsNearbyAlmostDuplicate_3(nums,k,t) +"");
    }
}
