/*
Permutations

 Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
*/
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums.length==0)
            return list;
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> clone = null;
        l1.add(nums[0]);
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        list.add(l1);
        int len=nums.length , i,j;
        for(i=1;i<len;i++){
            temp = new ArrayList<List<Integer>>();
            for(List<Integer> cur_list : list){
                for(j=cur_list.size();j>=0;j--){
                    clone = new ArrayList<Integer>(cur_list.size());
                    for(Integer cur_elem: cur_list) clone.add(cur_elem);
                    clone.add(j,nums[i]);
                    temp.add(clone);
                    //System.out.println(clone);
                }
            }
            list=temp;
        }
        return list;
    }
}