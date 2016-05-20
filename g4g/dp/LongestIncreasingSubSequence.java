public class LongestIncreasingSubSequence{

	int len[];

	public int longest(int arr[]){
		if(arr.length==0)
			return 0;
		len = new int[arr.length];
		func(arr,0);
		int i =0,max=len[arr.length-1];
		for(i=0;i<arr.length;i++)
			if(max<len[i])
				max = len[i];
		return max;
	}

	void func (int arr[], int ind){
		int l = arr.length;
		if(ind==l-1){
			len[ind]=1;
			return ;
		}else{
			int i = ind + 1;
			while(i<l && arr[ind]>arr[i]) i++;
			if(i<l){
				if(len[i]==0){
					func(arr,i);
				}
				len[ind] = len[i]+1;
			}else{
				len[ind] = 1;
			}
			return;
		}
	}

	public static void main(String args[]){
		LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
		int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
		int longest = lis.longest(arr);
		System.out.println(longest);
	}

}
