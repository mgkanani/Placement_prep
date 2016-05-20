public class SumOfDigits{
	public static void main(String[] args) {
		int n = 328;
		System.out.println(sum(n));
	}

	static int sum(int n){
		if(n<10)
			return n*(n+1)/2;
		int d = (int)Math.log10(n);
		int a[] = new int[d+1];
		a[0]=0;
		a[1]=45;
		for(int j=2;j<=d;j++)
			a[j]=a[j-1]*10+45*((int)Math.pow(10,j-1));
		int p = (int)Math.pow(10,d);
		int msd = n/p;
		int v1 = msd*a[d]+(msd*(msd-1)/2)*p;
		int v2 = msd*(1+n%p)+sum(n%p);
		return v1+v2;
	}

	int findMissingUtil(int arr[], int low, int high, int diff){
	    if (high <= low)
	        return INT_MAX;
	    int mid = low + (high - low)/2;
	 
	    if (arr[mid+1] - arr[mid] != diff)
	        return (arr[mid] + diff);
	 
	    if (mid > 0 && arr[mid] - arr[mid-1] != diff)
	        return (arr[mid-1] + diff);
	 
	    if (arr[mid] == arr[0] + mid*diff)
	        return findMissingUtil(arr, mid+1, high, diff);
	 
	    return findMissingUtil(arr, low, mid-1, diff);
	}
 
	int findMissing(int arr[], int n){
	    int diff = (arr[n-1] - arr[0])/n;
	    return findMissingUtil(arr, 0, n-1, diff);
	}
	/*
	missing number in arithmatic progression.
	sum of all digits from 1 to n.
	m to n n-m+1
	*/
}