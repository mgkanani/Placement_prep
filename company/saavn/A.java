import java.util.*;
public class A{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1="nothing",s2="dyno",s3="ingde";
		System.out.println(calculateScore(s1,s2,s3));
	}
	static int[] mergeArrays(int[] a, int[] b) {
        int n=a.length,m=b.length;
        if(n==0)
        	return b;
        if(m==0)
        	return a;
        int[] arr= new int[m+n];
        int i=0,j=0;
        int cnt=0;
        while(i<n && j<m){
        	if(a[i]>b[j]){
        		arr[cnt]=b[j];
        		cnt++;
        		j++;
        	}else{
        		arr[cnt]=a[i];
        		cnt++;
        		i++;
        	}
        }
        while(i<n){
        	arr[cnt++]=a[i++];
        }
        while(j<m){
        	arr[cnt++]=b[j++];
        }
        return arr;
    }

    static int NumberOfPairs(int[] arr, long k) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i:arr){
        	set.add(i);
        }
        int cnt=0;
        for(int i:arr){
        	if(set.contains(i) && set.contains(k-i)){
        		set.remove(i);
        		set.remove(k-i);
        		cnt++;
        	}
        }
        return cnt;
    }

    static String calculateScore(String text, String prefix, String suffix) {
    	int l=text.length();
    	int pr = prefix.length();
    	int su = suffix.length();
    	System.out.println(l+"\t"+pr+"\t"+su);
    	int max=0;
    	int i=0;
    		for(int j=0;j<pr;j++){
    			int k=j;
    			//i=j;
    			i=0;
    			while(k<pr && i<l && prefix.charAt(k)==text.charAt(i)){k++;i++;}
    			if(k==pr && max<i){
    				max=i;
    				//break;
    			}
    		}
    	i=0;
    	String s1 = text.substring(0,max);
    	int max1=0;

    	for(i=0;i<l;i++){
    		int k=0;
    		int j=i;
    		while(k<su && j<l && suffix.charAt(k)==text.charAt(j)){k++;j++;}
    		if(j==l && max1<k)
    			max1=k;
    	}
    	String s2 = suffix.substring(0,max1);
    	if(max1==max){
    		return s1.compareTo(s2)>0?s2:s1;
    	}else
    		return text;
    }
}