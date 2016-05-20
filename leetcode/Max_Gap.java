public class Max_Gap {
    /*
    http://cgm.cs.mcgill.ca/~godfried/teaching/dm-reading-assignments/Maximum-Gap-Problem.pdf

    finding maximum gap :-
    Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
    Try to solve it in linear time/space.

    [1,7,8,8,7,8,8,8,1,8]  ----> will not work. check out corrected_maximumGap method.
    */
    
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if(len<=1)
            return 0;
        int min=nums[0];
        int max = nums[0];
        int i,j=0;
        for(i=1;i<len;i++){
            if(min>nums[i])
                min = nums[i];
            if(max<nums[i])
                max = nums[i];
        }
        
        if(max-min==0)//all values in the array are same.
            return 0;
        int min_max[] = new int[2*len];
        HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        List<Integer> list= null;
        int bkt_size = (max-min)/(len-1);//total n-1 buckets. if max-min < len-1 then bucket
        for(i=0;i<len;i++){
            if(bkt_size==0)
                j = ((nums[i]-min)/(len-1));
            else
                j = (nums[i]-min)/bkt_size;
            if(map.containsKey(j)){
                list = map.get(j);
            }else{
                list = new ArrayList<Integer>(1);
                map.put(j,list);
            }
            list.add(nums[i]);
        }
        int cnt = 0;
        j = 0;
        for(i=0;i<len;i++){
            if(map.containsKey(i)){
                list = map.get(i);
                int temp[] = find_minmax(list);
                //System.out.println(temp[0]+"\t"+temp[1]);
                min_max[cnt] = temp[0];
                min_max[cnt+1] = temp[1];
                cnt+=2;
            }
        }
        int max_dist = 0;
        for(i=0;i<cnt-1;i++){
            if((min_max[i+1]-min_max[i])>max_dist){
                max_dist = min_max[i+1]-min_max[i];
            }
        }
        return max_dist;
    }
    
    public int[] find_minmax(List<Integer> list){
        int arr[] = new int[2];
        arr[0] = list.get(0);//min
        arr[1] = arr[0];//max
        for(Integer i:list){
            if(arr[0]>i)
                arr[0] = i;
            if(arr[1]<i)
                arr[1] = i;
        }
        
        return arr;
    }


    public int corrected_maximumGap(int[] nums) {
        // find unique numbers.
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i:nums)
            set.add(i);
        Iterator<Integer> iter = set.iterator();
        int i=0,j=0;
        while(iter.hasNext()){nums[i++]=iter.next();}
        int len = i;
        if(len<=1)
            return 0;
        int min=nums[0];
        int max = nums[0];
        for(i=1;i<len;i++){
            if(min>nums[i])
                min = nums[i];
            if(max<nums[i])
                max = nums[i];
        }
        int min_max[] = new int[2*len];
        HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        List<Integer> list= null;
        int bkt_size = (max-min)/(len-1);//total n-1 buckets. This will be >0 as max-min >= len
        for(i=0;i<len;i++){
            j = (nums[i]-min)/bkt_size;
            if(map.containsKey(j)){
                list = map.get(j);
            }else{
                list = new ArrayList<Integer>(1);
                map.put(j,list);
            }
            list.add(nums[i]);
        }
        int cnt = 0;
        j = 0;
        for(i=0;i<len;i++){
            if(map.containsKey(i)){
                list = map.get(i);
                int temp[] = find_minmax(list);
                //System.out.println(temp[0]+"\t"+temp[1]);
                min_max[cnt] = temp[0];
                min_max[cnt+1] = temp[1];
                cnt+=2;
            }
        }
        int max_dist = 0;
        for(i=0;i<cnt-1;i++){
            if((min_max[i+1]-min_max[i])>max_dist){
                max_dist = min_max[i+1]-min_max[i];
            }
        }
        return max_dist;
    }
*/

}