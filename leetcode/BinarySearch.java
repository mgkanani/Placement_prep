public class BinarySearch{
    public int searchInsert(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums,target);
        return pos<0?-(pos+1):pos;
    }
}