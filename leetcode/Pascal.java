import java.util.*;

public class Pascal {
    int table[][];
    public List<List<Integer>> generate(int rows) {
        if(rows==0)
            return new ArrayList<List<Integer>>();
        table = new int[rows][rows];
        int i,j;
	for(i=0;i<rows;i++)
	        construct(rows-1,i);
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	List<Integer> l;
        for(i=0;i<rows;i++){
	    l= new ArrayList<Integer>();
            for(j=0;j<=i;j++)
		l.add(table[i][j]);
                //System.out.print(table[i][j]+"\t");
	    list.add(l);
            //System.out.println();
        }
            return list;
        
    }
    
	void construct(int n, int r){
	    if(n<0)
	        return;
	    if(r==0){
		table[n][0]=1;
		return;
	    }
	    if(n==r){
			table[n][r] =1;
			//return;
	    }
	    if(n<r){
		table[n][r]=0;
		return;
            }else{
			if(table[n-1][r-1]==0){
				construct(n-1,r-1);
			}
			if(table[n-1][r]==0){
				construct(n-1,r);
			}
			table[n][r]=table[n-1][r-1]+table[n-1][r];
			return;
	   }
			
	}
	public static void main(String args[]){
		Pascal pas = new Pascal();
		System.out.println(pas.generate(5));
	}
}
