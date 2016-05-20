import java.util.*;
public class Contains_Duplicates {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int i,j,last,cur;
        TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
        for(i=0;i<k-1&&i<nums.length;i++){
            tree.put(nums[i],nums[i]);
        }
        Set set;
        Iterator iter;
        Map.Entry entry;
        for(j=i;j<nums.length;j++){
    	    if(tree.containsKey(nums[j]) && t>=0)
        		return true;
            tree.put(nums[j],nums[j]);
            set = tree.entrySet();
            iter = set.iterator();
            entry = (Map.Entry)iter.next();
            last = (Integer)entry.getKey();
            while(iter.hasNext()){
                entry = (Map.Entry)iter.next();
                cur=(Integer)entry.getKey();
                if(Math.abs(last-cur)<=t){
                    return true;
                }
                System.out.println(last+"\t"+cur);
                last = cur;
            }
            tree.remove(nums[j-k+1]);
        }
        return false;
    }

    public static void main(String args[]){
	Contains_Duplicates cd = new Contains_Duplicates();
	int arr[]={5,4,6,77,-1,0,4};
	System.out.println(cd.containsNearbyAlmostDuplicate(arr,6,0));
    }
}
