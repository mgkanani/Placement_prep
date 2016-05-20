import java.util.*;
public class Combinations{
	public List<List<Integer>> combine(int n, int k) {
		int i,j;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> temp;
		for(i=1;i<=k;i++)
			list.add(i);
		res.add(list);
		for(i=k-2;i>=0;i--){
			for(j=list.get(i+1)+1;j<=n;j++){
				temp = new ArrayList<Integer>();
				for(k=0;k<=i;k++){
					temp.add(list.get(k));
				}
				temp.add(j);
				res.add(temp);
			}
		}
		return res;
	}
	public static void main(String args[]){
		System.out.println((new Combinations()).combine(5,3));
	}
}
/*
public class Solution {
    int n,k;
    List<List<Integer>> list;
    int ar[];
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        list = new ArrayList<List<Integer>>();
        generate(0);
        return list;
    }
    
    void generate(int pos){
        if(pos==k){
            list
        }
    }
    
}
*/
