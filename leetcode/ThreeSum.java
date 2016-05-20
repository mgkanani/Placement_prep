import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        nums = process(nums);
        int len = nums.length;
        int i,j,k;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> ll = null;
        for(i=0;i<len;i++){
            for(j=i;j<len;j++){
                if(nums[i]+nums[j]>0)
                    break;
                k=search(j+1,len-1,-(nums[i]+nums[j]),nums);
                if(k>-1){
                    ll = new ArrayList<Integer>();
                    ll.add(nums[i]);
                    ll.add(nums[j]);
                    ll.add(nums[k]);
                    list.add(ll);
                }
		if(j<len-1 && nums[j]==nums[j+1])
			j++;
            }
        }
        return list;
    }

    public int[] process(int[] nums){
	int len = nums.length;
	if(len<=5)
	   return nums;
	int i,cnt=0,ind=0;
	//count distinct
	int key[] = new int[len];
	int val[] = new int[len];
	int total=0;
	for(i=0;i<len;){
		ind=1;
		while((i+ind)<len && nums[i]==nums[i+ind]){
			ind++;
		}
		key[cnt] = nums[i];
		val[cnt] = (ind>2)?2:ind;
		total+= val[cnt];
		i+=ind;
		cnt++;
	}
	int new_arr[] = new int[total];
	ind=0;
	int j=0;
	for(i=0;i<cnt;i++){
		ind=0;
		while(ind<val[i]){
			new_arr[j]=key[i];
			j++;
			ind++;
		}
	}
	return new_arr;
    }

    public int search(int low, int high, int val, int[]nums){
        int mid= (low + high)/2;
        while(low<=high){
            if(nums[mid]==val){
                return mid;
            }else if(nums[mid]<val){
                low=mid+1;
            }else{
                high=mid-1;
            }
            mid= (low + high)/2;
        }
        return -1;
    }

	public static void main(String args[]){
		//int nums[] = {-15,13,6,-11,-4,5,-13,5,3,2,6,-1,4,12,-10,-13,-7,-4,-5,6,9,-14,1,-6,13,7,-8,10,-4,11,-8,-3,1,5,-7,4,-13,-13,-5,-3,4,-14,11,-14,5,-13,-12,13,-10,-10,-4,-15,13,13,-14,11,-3,-15,6,1,3,5,13,-11,-5,-9,1,-2,-14,11,10,5,4,-1,6,-6,-7,9,-15,-2,7,-12,-10,5,-14,13,-6,-9,6,7,7,-6,-2,-3,-9,0,-5,7,5,-4,-5,-7,-13,14,7,8,-15,7,-5,-15,-10,9};
		int nums[] = {-1,0,1};
		ThreeSum sum = new ThreeSum();
		System.out.println(sum.threeSum(nums));
	}
}
