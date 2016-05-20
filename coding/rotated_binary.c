#include<stdio.h>

int find_offset(int a[], int len){
	int low=0,high=len-1,mid;
	int offset=0;
	mid = (high+low)/2;
	if(a[high]>a[low])
		return 0;
	while((low<high) && mid!=0){
		if(a[low]<a[mid]){
			low=mid;
		}else if(a[low]>a[mid]){
			high = mid;
		}else if(low == mid){
			offset = a[low]>a[high]?high:low;
			high=offset;
			low=offset;
		}
		mid = (high+low)/2;
	}
	offset=high;
	return offset;
}

int binary_search(int a[],int len, int elem, int offset){
	int low,mid,high;
	offset=len-offset;
	low=-offset;
	high=len-1-offset;
	mid = (low+high)/2;
	mid = (mid+len)%len;
	while(low<=high){
		if(a[mid]==elem){
			return mid;
		}else if(elem>a[mid]){
			low=mid+1;
		}else{
			high=mid-1;
		}
		mid = (low+high)/2;
		mid = (mid+len)%len;
	}
	return -1;
}

int main(){
	int a[]={2,3,4,5,1};
	int offset = find_offset(a,5);
	printf("%d\n",offset);
	int ret = binary_search(a,5,1,offset);
	printf("%d\n",ret);
	ret = binary_search(a,5,2,offset);
	printf("%d\n",ret);
	ret = binary_search(a,5,3,offset);
	printf("%d\n",ret);
	ret = binary_search(a,5,5,offset);
	printf("%d\n",ret);
return 0;
}
