public class Rotated_Array {
    /*
        Find Minimum in Rotated Sorted Array
        Suppose a sorted array is rotated at some pivot unknown to you beforehand.
        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
        Find the minimum element.
        You may assume no duplicate exists in the array.
    */
    public int findMin(int[] nums) {
        int low,mid,high;
        low = 0;
        high = nums.length-1;
        mid = (high+low)/2;
        while(low<high){
            if(nums[low]<=nums[mid] && nums[mid]<nums[high])
                return nums[low];
            else if(nums[low]>=nums[mid] && nums[mid]>nums[high])
                return nums[high];
            else if(nums[low]>=nums[mid] && nums[high]>nums[mid]){
                high=mid;
            }else{
                low=mid;
            }
            mid=(low+high)/2;
        }
        return nums[low];
    }
}