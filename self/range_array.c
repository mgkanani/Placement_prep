#include<stdio.h>
int main(){
	int len=0;
	scanf("%d",&len);
	int arr[len+1];
	int i=0;
	for(i=0;i<=len;i++){
		arr[i]=0;
	}
	int T,st,en,val;
	scanf("%d",&T);
	for(i=0;i<T;i++){
		scanf("%d %d %d\n",&st,&en,&val);
		arr[st]+=val;
		arr[en+1]-=val;
	}
	for(i=1;i<=len;i++){
		arr[i]=arr[i-1]+arr[i];
	}
	for(i=0;i<=len;i++){
		printf("%d\n",arr[i]);
	}
}
