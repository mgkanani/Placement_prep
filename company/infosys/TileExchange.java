import java.util.*;
public class TileExchange{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str[] = sc.nextLine().split("#");
		int sum = Integer.parseInt(str[0]);
		String _s[] =null;
		int i=0,temp;
		long ans=0;
		if(str.length>1){
			_s = str[1].split(" ");
			int arr[] = new int[_s.length];
			for(i=0;i<_s.length;i++){
				arr[i] = Integer.parseInt(_s[i]);
			}
			int res[] = findSquareSum(sum,_s.length);
			//System.out.println(cnt+"\t"+arr.length);
			if(res!=null && cnt==arr.length){
				Arrays.sort(res);
				Arrays.sort(arr);
				for(i=0;i<cnt;i++){
					int val = Math.abs(arr[i]-res[i]);
					//System.out.println(arr[i]+"\t"+res[i]);
					ans+=val*val;
				}
			}else{
				ans=-1;
			}
		}
		System.out.println(ans);		
	}
	static int cnt=0;
    public static int[] findSquareSum(int n,int k) {
        cnt=0;
        int res[] = new int[k];
        if (proc(res,n,k))
        	return res;
        else
        	return null;
    }
    public static boolean proc(int[] res,int n, int k){
    	//System.out.println(n+"\t"+k);
    	if(k==0 && n==0)
    		return true;
        if(n<=0||k<=0)
            return false;
        for(int i=1;i*i<=n;i++){
            if(proc(res,n-i*i,k-1)){
            	res[cnt++]=i;
            	//System.out.println(cnt);
				return true;
            }
        }
        return false;
    }
}