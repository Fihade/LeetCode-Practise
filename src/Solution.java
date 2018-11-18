import java.util.*;

public class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
//        int[] a = {1,2,3,4,5};
        int zeronum = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                zeronum++;
            } else if (zeronum != 0) {
                nums[i - zeronum] = nums[i];
                nums[i] = 0;
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

//    public int removeElement(int[] nums, int val) {
//        int isVal = 0;
//        for (int i=0;i<nums.length;i++){
//            if (nums[i]==val){
//                isVal++;
//                System.out.println(isVal);
//            }else if (val != 0){
//                nums[i-isVal] = nums[i];
//                nums[i] = val;
//            }
//        }
//        System.out.println("-----------------------");
//        for (int i = 0;i<nums.length;i++){
//            System.out.println(nums[i]);
//        }
//        return 0;
//    }

    //    public int removeElement(int[]nums,int val){
//        if (nums.length == 0)
//            return 0;
//        int i = 0, j = 0;
//        for (i = 0; i < nums.length; i++) {
//            if (nums[i] == val) {
//                for (j = i + 1; j < nums.length; j++) {
//                    if (nums[i] != nums[j]) {
//                        nums[i] = nums[j];
//                        nums[j] = val;
//                        break;
//                    }
//                }
//                if (j == nums.length) {
//                    return i;
//                }
//            }
//        }
//        return nums.length;
//    }
    public int removeElement(int[] nums, int val) {
//        if (nums.length == 0) return 0;
//        int countVal = 0;
//        int length = nums.length;
//        for (int i = 0;i<nums.length;i++){
//            if(nums[i] == val){
//                countVal++;
//                length--;
//            }else if(countVal != val){
//                nums[i-countVal] = nums[i];
//                nums[i] = val;
//            }
//        }
//        return length;
        if (nums.length == 0) return 0;
        int i = 0;
        int j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i]== val) {
                for (j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        nums[j] = val;
                        break;
                    }
                }
                if (j == nums.length) {
                    return i;
                }
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
        return nums.length;
    }
    //删除重复元素
    public int[] removeDuplicates(int []nums){
        int k = 0;
        for (int i = 1;i<nums.length;i++){
            if (nums[i] != nums[k]){
                k+=1;
                nums[k] = nums[i];
            }
        }
        return nums;
    }
    //区分颜色
    public int[] sortColors(int[] nums) {
        int k = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] == 0) {
                nums[i] = nums[k];
                nums[k] = 0;
                k += 1;
            }
        }
        for (int j = k;j<nums.length;j++){
            if (nums[j] == 1) {
                nums[j] = nums[k];
                nums[k] = 1;
                k += 1;
            }
        }
        for (int m = k;m<nums.length;m++){
            if (nums[m] == 2) {
                nums[m] = nums[k];
                nums[k] = 2;
                k += 1;
            }
        }

        return nums;
    }
    //给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    //方法一
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n )
            if (nums1[i] <= nums2[j])
                nums[index++] = nums1[i++];
            else
                nums[index++] = nums2[j++];

        if ( i < m)
            while (i<m)
                nums[index++] = nums1[i++];

        if (j < n)
            while (j<n)
                nums[index++] = nums2[j++];
    }
    //方法二
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        int i=m-1;
        int j=n-1;
        int p;
        for(p=m +n-1;i>=0 && j>=0 ;p--){
            if( nums1[i]>nums2[j] ){
                nums1[p]=nums1[i--];
            } else{
                nums1[p]=nums2[j--];
            }
        }
        if(i>=0){
            while(p>=0){
                nums1[p--]=nums1[i--];
            }
        } else if(j>=0){
            while(p>=0){
                nums1[p--]=nums2[j--];
            }
        }

    }
//    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
    public int[] twoSum(int[] numbers, int target) {
        int[] result={0,numbers.length-1};
        while(result[0]<result[1]){
            if(numbers[result[0]]+numbers[result[1]]==target){
                break;
            }else if(numbers[result[0]]+numbers[result[1]]>target){
                result[1]--;
            }else{
                result[0]++;
            }
        }
        result[0]++;
        result[1]++;
        return result;
    }

    public int[] twoSum1(int[] numbers,int target){
        int [] tuple = {0,numbers.length-1};
        while (tuple[0]<tuple[1]){
            if (numbers[tuple[0]] + numbers[tuple[1]] == target) break;
            else if (numbers[tuple[0]]+numbers[tuple[1]] > target) tuple[1] --;
            else tuple[0]++;
        }
        tuple[0]++;
        tuple[1]++;
        return tuple;
    }
    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int front = 0;
        int end = s.length()-1;
        while (front < end && front < s.length()-1){
            char pre = s.charAt(front);
            char aft = s.charAt(end);
            if (!((pre>='a' && pre <= 'z')||(pre >='0' && pre <= '9'))){
                front++;
                continue;
            }

            if (!((aft >= 'a' && aft <= 'z')||(aft >= '0' && aft <= '9'))){
                end--;
                continue;
            }
            if (pre != aft){
                return false;
            }
            front++;
            end--;
        }
        return true;
    }
    //编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
    public String reverseVowels(String s) {
//        s = s.toLowerCase();
        char[] str = s.toCharArray();
        int j = str.length-1;
//        System.out.println(j);
        for (int i=0;i<str.length/2;i++){
            if (isYuanyin(str[i]) && isYuanyin(str[j])){
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                j--;
            }else j--;
        }
        return new String(str);
    }
    public boolean isYuanyin(char s){
        if (s == 'a' || s =='e' || s == 'i' || s == 'o' || s == 'u'
        ||  s == 'A' || s =='E' || s == 'I' || s == 'O' || s == 'U'){
            return true;
        }else {
            return false;
        }
    }

    //给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
    // 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    // 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    public int maxArea(int[] height){
        int max_area = 0;
        int max_temp = 0;
        int min_height = 0;
        int start=0, end = height.length-1;
        for(; start<end;){
            min_height = height[start] < height[end]?height[start]:height[end];
            max_temp = (end-start)*min_height;
            if(max_temp > max_area){
                max_area = max_temp;
            }
            if(height[start]>height[end]){
                end--;
            }else{
                start++;
            }
        }
        return max_area;
    }
    //给定一个含有 n 个正整数的数组和一个正整数 s ，
    // 找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < len; i++)
        {
            sum += nums[i]; //累加
            while (sum >= s)
            {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++]; // 筛选元素
            }
        }
        return (ans != Integer.MAX_VALUE)? ans : 0;
    }

    //寻找两个集合的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        Set set = new HashSet();
        for (int i = 0;i<length1;i++){
            for (int j = 0;j<length2;j++){
                if (nums1[i] == nums2[j]){
                    set.add(nums1[i]);
                    break;
                }
            }
        }
        int[] num = new int[set.size()];
        Iterator it = set.iterator();
        for (int i = 0;i<set.size();i++){
            num[i] = (int) it.next();
        }
        return num;
    }

    public int[] intersection1(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0;
        int index = 0;
        int[] temp = new int[nums2.length];
        while(i1<nums1.length && i2 < nums2.length){
            if (nums1[i1] == nums2[i2]){
                temp[index++] = nums1[i1];
                while(i2<nums2.length && nums2[i2] == nums1[i1]){
                    i2++;
                }
            }else if (nums1[i1] < nums2[i2]){
                i1++;
            }else {
                i2++;
            }
        }
        return Arrays.copyOf(temp,index);
    }
    //快乐数
    public boolean isHappy(int n) {
        if (n==1) return true;
        int sum = 0;
        while (n != 0){
            sum += Math.pow(n%10,2);
            n/=10;
        }
        return isHappy(sum);
    }
    //输出一个整数表示所有队伍的水平值总和最大值
    public int findMax(int teamNum,int[] ai_total,int k){
        int length = ai_total.length;
        Arrays.sort(ai_total);
        int numPerTeam = length / teamNum;
        int count = 0;
        int i = length;
        while (numPerTeam > 0){
            i = i - k;
            count += ai_total[i];
            numPerTeam--;
        }
        return count;
    }
    //散布谣言,假设有n个人
    public void lier(int n){
        int[] people = new int[n];
        for (int j = 0;j<n;j++){
            people[j]++;
        }
        int start = 0;
        int count = 0;
        for (int i = 0;i<n;i++){
            if ((start + 1)<=n-1) {
                people[start + 1] = people[start + 1] + people[start];
                start = start + 1;
                count++;
//                log(i+"->"+(i+1));
             }
            log(i+"->"+(i+1));

        }
        if (people[n-1] == n){
            for (int j = 0;j<n-1;j++){
                people[j] = people[n-1];
                log(n+"->"+j);
                count++;
            }
        }

        log("共传递"+count+"次");
    }
    //给定一个有n个正整数的数组A和一个整数sum，求选择数组A中部分数字和为sum的方案数
    public void countSolution(int n){
        int[][] dp=new int[1001][1001];
        int[] a = {5,5,10,2,3};
        Arrays.sort(a);
        System.out.println("请输入需要的和为：");
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        for(int i=1;i<=sum;i++)
            dp[0][i]=0;
        dp[0][0]=1;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<=sum;j++){
                if(j>=a[i])
                    dp[i][j]=dp[i-1][j-a[i]]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        log(dp[n][sum]+"");

    }
    //判断数组中是否有重复元素
    public boolean containsDuplicate(int[] nums){
        for (int i = 1;i<nums.length;i++){
            for (int j = i - 1;j>=0;j--){
                if (nums[i] > nums[j]){
                    break;
                }else if (nums[j] == nums[i]){
                    return true;
                }
            }
        }
        return false;
    }
    //求两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]){
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOf(result, k);
    }
    //判断是不是异位词
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        if (ss == tt){
            return true;
        }
        return false;
    }


    public static void main(String []args){
        Solution solution = new Solution();
        int[] a = {2,0,2,1,1,0};
//        solution.moveZeroes(a);
//        System.out.print(solution.removeElement(a,0));
//        int[] b = solution.removeDuplicates(a);
//        for (int num:b){
//            System.out.print(num);
//        }
//        int[] b = solution.sortColors(a);
//        for (int num:b){
//            System.out.print(num);
//        }
//        System.out.println(solution.isPalindrome("0p"));
        int[] height ={1,8,6,2,5,4,8,3,7};
        int max = solution.maxArea(height);
        int[] nums ={2,3,1,2,4,3};
//        System.out.println(solution.minSubArrayLen(7,nums));
//        System.out.println(solution.isHappy(19));
//        System.out.println();
        int[] num = {1,2,3,5,6,18,19,20,21,22};
        int[] aa ={1,2,3,2,4,5,2};
        int[] out = solution.intersection(num,aa);
        for (int n:out){
            log(n+"");
        }
//        int res = solution.findMax(5,num,3);
//
//        solution.Pointed8Star(1);
//        solution.countSolution(5);
        log(solution.containsDuplicate(aa)+"");
    }

    public static void log(String a){
        System.out.println(a);
    }
}
