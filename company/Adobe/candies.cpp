#include <iostream>
using namespace std;

int main(){
	int t;
	cin>>t;
	while(t--){
		int X,Y,Z;
		cin>>X>>Y>>Z;
		if(X<Y){
			if(X+Z == Y){
				cout<<Y<<endl;
			}else if(X+Z < Y){
				cout<<X+Z<<endl;
			}else{
				int diff = X+Z-Y;
				cout<<Y+(diff/2)<<endl;
			}
		}else if(X>Y){
			if(X-Y >= Z){
				cout<<X<<endl;
			}else{
				int diff = Z-(X-Y);
				cout<<X+(diff/2)<<endl;
			}
		}else{
			cout<<X+(Z/2)<<endl;
		}		
	}
	return 0;
}

/*Test cases
7
3 8 3
=6
3 8 5
=8
3 8 7
=9
10 2 8
=10
10 2 2
=10
10 4 8
=11
10 10 6
=13

*/