import java.util.*;
public class TSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if(nums.length<3)

            return list;

        Arrays.sort(nums);

        int i,j,k,pos=0,len = nums.length;

        for(i=0;i<len;i++)

            if(nums[i]>0){

                pos = i;

                break;

            }

        List<Integer> l1,last;// = new ArrayList<Integer>();

        for(i=0;i<len;i++){

            for(j=i+1;j<len;j++){

                k=pos>j?pos:j+1;

                last=null;

                while(k<len && nums[i]+nums[j]+nums[k]<=0){

                    if(nums[i]+nums[j]+nums[k]==0 && (last==null || !last.contains(nums[k]))){

                        l1 =  new ArrayList<Integer>();

                        l1.add(nums[i]);

                        l1.add(nums[j]);

                        l1.add(nums[k]);

                        last=l1;

                        list.add(l1);

                    }

                    k++;

                }

            }

        }
	return list;
    }

}
