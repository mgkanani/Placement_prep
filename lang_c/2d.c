#include <stdio.h>

int print (int n,int arr[n][n]){
   /* an array with 5 rows and 2 columns*/
   //int a[5][2] = { {0,0}, {1,2}, {2,4}, {3,6},{4,8}};
   int i, j;
 
   /* output each array element's value */
   for ( i = 0; i < n; i++ ){
      for ( j = 0; j < n; j++ ){
         printf("a[%d][%d] = %d\n", i,j, arr[i][j] );
      }
   }
   return 0;
}

int main(){
	int n=5;
	scanf("%d",&n);
	int arr[n][n];
	int i,j;
	for(i=0;i<n;i++){
		for(j=0;j<n;j++)
			arr[i][j]=i*j + j;
	}
	print(n,arr);
	return 0;
}
 
