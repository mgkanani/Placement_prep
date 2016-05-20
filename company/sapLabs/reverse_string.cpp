#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
	string s;
	getline(cin,s);
	vector <string> array;
	string tmp="";
	for(int i=0;i<s.size();i++){
		if(s[i]==' '){
			array.push_back(tmp);
			tmp ="";
		}else{
			tmp+=s[i];
		}
	}
	array.push_back(tmp);
	for(int i=0;i<array.size();i++){
		string t = array[i];
		reverse(t.begin(),t.end());
		for(int j=0;j<t.size();j++){
			if(isalpha(t[j])){
				if(j==0)
					t[j]=toupper(t[j]);
				else
					t[j]=tolower(t[j]);
			}
		}
		if(array.size()-1!=i)
			cout<<t<<" ";
		else
			cout<<t;
	}
	return 0;
}