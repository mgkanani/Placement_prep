import java.util.*;
/*

Stable Marriage Problem

Given N men and N women, where each person has ranked all members of the opposite sex in order of preference, marry the men and women together such that there are no two people of opposite sex who would both rather have each other than their current partners. If there are no such people, all the marriages are “stable” (Source Wiki).

Consider the following example.
*/
public class StableMarriage{
	public static void main(String[] args) {
		int men[][] = {
			{1 ,0},
			{0, 1}
		};
/*		{
			{3, 1, 2, 0},
	        {1, 0, 2, 3},
			{0, 1, 2, 3},
        	{0, 1, 2, 3},	        
		};
*/		int women[][] = {
		{0,1},
		{0,1},
	};
/*		{
			{0, 1, 2, 3},
        	{0, 1, 2, 3},
        	{0, 1, 2, 3},
        	{0, 1, 2, 3},
		};
*/		int n = men.length;
		HashMap<Integer,Integer> mset = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> wset = new HashMap<Integer,Integer>();
		//int f_men = new boolean[n];
		//int f_men = new boolean[n];
		int free_m=-1,free_w=-1,other_m=-1;
		while(mset.size()!=n){
			free_m = find(mset,n);
			if(free_m!=-1){
				free_w = -1;
				for(int j=0;j<n;j++){
					//find the women to whom current man has not proposed yet.
					if(men[free_m][j]!=-1){
						free_w = men[free_m][j];
						men[free_m][j] = -1;
						break;
					}
				}

				if(wset.containsKey(free_w)){
					// Woman is engaged to other man.
					other_m = wset.get(free_w);
					if(higher_pref(women,free_w,free_m,other_m)){
						mset.remove(other_m);
						wset.put(free_w,free_m); //overwrite.
					}
				}else if(free_w!=-1){
					// Woman is free.
					wset.put(free_w,free_m);
					mset.put(free_m,free_w);
				}else{
					System.out.println("Woman not found, Impossible!!");
					break;
				}
			}else{
				System.out.println("Impossible!!");
				break;
			}
		}
		Set set = wset.entrySet();
		Iterator iter = set.iterator();
		Map.Entry<Integer,Integer> entry = null;
		while(iter.hasNext()){
			entry = (Map.Entry<Integer,Integer>)iter.next();
			System.out.println((entry.getKey()+4)+" "+entry.getValue());
		}

	}

	public static int find(HashMap<Integer,Integer> set,int n){
		for(int i=0;i<n;i++)
			if(!set.containsKey(i))
				return i;
		return -1;
	}

	public static boolean higher_pref(int[][] women, int free_w, int free_m, int other_m){
		int n = women.length,i1=-1,i2=-1;
		for(int i=0;i<n;i++){
			if(women[free_w][i]==free_m){
				i1 = i;
			}else if(women[free_w][i]==other_m){
				i2 = i;
			}
		}
		return i1<i2;
	}
}