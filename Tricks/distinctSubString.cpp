#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int getusubstr(string s) {
	int n = s.length();
	vector<string> arr(n);
	for(int i=0; i<n; i++) arr[i] = s.substr(i, n-i);

	sort(arr.begin(), arr.end());
	int result = arr[0].size();

	for(int i=1; i<n; i++) {
		string s1 = arr[i-1];
		string s2 = arr[i];
		int j = 0;
		while(j<s1.size() && j<s2.size() && s1[j]==s2[j]) {
			j++;
		}
		result += (s2.size()-j);
	}
	return result;
}

int main(){
	int t;
	cin>>t;
	string s;
	while(t-- ) {
		cin >> s;
		cout<<getusubstr(s)<<endl;
	}
		
	return 0;
}

/*
distinct SubString

*/