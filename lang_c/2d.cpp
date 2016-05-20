#include <iostream>
#include <vector>
#include <map>
#include <malloc.h>
using namespace std;

//int n=5;
//map< int, vector<int> > 
void get_adjlist(int p ,int arr[][]){
	/*for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			cout<<array[i][j]<<"\t";
		}
		cout<<"\n";
	}*/
	map < int,vector<int> > value;

	//bool visited[n]={false};



	///return value;
}

int main(){
	int N=2;	
	cin>>N;
	
	int array[N][N];

	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			array[i][j]=0;
		}
	}
	int E;
	cin>>E;
	for(int i=0;i<E;i++){
		int a,b;
		cin>>a>>b;
		array[a][b]=array[b][a]=1;
	}
	
	//map < int,vector<int> > adjlist = 
	get_adjlist(N,array);

	return 0;
}
