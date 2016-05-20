/*
Find Minimum in Rotated Sorted Array II



    Follow up for "Find Minimum in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.


*/

public class SortedRotArr {
    public int findMin(int[] nums) {
        int low,mid,high;
        low = 0;
        high = nums.length-1;
        mid = (high+low)/2;
        if(nums[low]==nums[mid] && nums[mid]==nums[high])
            return min(nums);
        while(low<high){
            if(nums[mid]<=nums[high])
                high = mid;
            else if(nums[mid]>nums[high]){
                if(low==mid)
                    low=mid+1;
                else
                    low = mid;
            }
            mid=(low+high)/2;
        }
        return nums[low];
    }
    public int min(int nums[]){
        int min = nums[0];
        for(int i:nums)
            if(i<min){min = i;}
        return min;
    }
}