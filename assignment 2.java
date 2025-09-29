//1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int j=0;
        for(int i=m;i<nums1.length;i++)
        {
            nums1[i]=nums2[j];
            j++;

        }
        Arrays.sort(nums1);

    }
}
//2
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];        
    }
}
//3
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int right = num / 2, left =0;
        while(left <= right){
            int mid = left +(right - left) / 2;
            long pow = (long) mid * mid;
            if(pow == num) return true;
            else if(pow < num) left = mid +1;
            else right = mid -1;
        }
        return false;
    }
}
