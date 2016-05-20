public class NcR{
	int table[][];
	public int ncr(int n, int r){
		table = new int[n+1][r+1];
		calc(n,r);
		return table[n][r];
	}
	void calc(int n, int r){
		if(n==r | r==0){
			table[n][r] =1;
			return;
		}
		if(n<r){
			table[n][r]=0;
			return;
		}else{
			if(table[n-1][r-1]==0){
				calc(n-1,r-1);
			}
			if(table[n-1][r]==0){
				calc(n-1,r);
			}
			table[n][r]=table[n-1][r-1]+table[n-1][r];
			return;
		}
	}
	public static void main(String args[]){
		NcR ncr= new NcR();
		int j = ncr.ncr(15,8);
		System.out.println(j);
	}
}
