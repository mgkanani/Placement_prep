public class Dup_Numb {
/*
Find the Duplicate Number

 Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.

Linked_list find the start of cycle.
*/
    public int findDuplicate(int[] nums) {
        int single = nums[0];
        int dbl = nums[nums[0]];
        while (single != dbl){
            single = nums[single];
            dbl = nums[nums[dbl]];
        }
        dbl=0;
        while(single!=dbl){
            single = nums[single];
            dbl = nums[dbl];
        }
        return dbl;
    }
}