#include <bits/stdc++.h>

using namespace std;

int main(){
	string s,p;
	cin>>s;
	cin>>p;
	int alpha[26];
	for(int i=0;i<26;i++)
		alpha[i]=0;
	for(int i=0;i<s.length();i++){
		alpha[s[i]-'a']++;
	}
	s="";
	for(int i=0;i<p.length();i++) {
		for(int j=0;j<(alpha[p[i]-'a']);j++) {
			s +=p[i];
		}
	}
	cout<<s<<endl;
}