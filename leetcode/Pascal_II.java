import java.util.*;
public class Pascal_II {
    int table[][];
    public List<Integer> getRow(int rows) {
        rows++;
        if(rows==0)
            return new ArrayList<Integer>();
        table = new int[rows][rows];
        int i,j;
        for(i=0;i<rows;i++)
                construct(rows-1,i);
        List<Integer> l = new ArrayList<Integer>();
        for(j=0;j<rows;j++)
            l.add(table[rows-1][j]);
        return l;
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
		Pascal_II pas = new Pascal_II();
		System.out.println(pas.getRow(5));
	}
}
