import java.util.*;

import java.net.*;
/*

*/

public class IPValidation{
	public static void main(String[] args) {
		//System.out.println(Integer.parseInt("0000000000000000001"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int itr = 0;
		String s=null,v4,v6;
		String a="(([0]*[0-9]?[0-9])|[1][0-9][0-9]|([2][0-5][0-5])|([2][0-4][0-9]))";
		v4 = a+"\\."+a+"\\."+a+"\\."+a;
		int x=0,mx=0xffff;
		while(itr<n){
			s = sc.nextLine();
			//System.out.println(s);
			if(s.trim().matches(v4)){
				System.out.println("IPv4");
			}else{
				Inet6Address addr = new Inet6Address(s);
				String str[] = s.split(":");
				if(str.length!=8){
					System.out.println("Neither");
				}else{
					boolean f=true;
					for(int i=0;i<8;i++){
						try{
							x = Integer.parseInt(str[i].trim(),16);
							if(x<0||x>mx)
								throw new Exception("");

						}catch(Exception e){
							System.out.println("Neither");
							f=false;
						}
					}
					if(f)
						System.out.println("IPv6");
				}
			}
			itr++;
		}
	}
}

/*
//working cpp code
    #include <arpa/inet.h>
    #include <iostream>
    #include <string>
    #include <sstream>
     
    using namespace std;
     
    bool is_ipv4_address(const string& str)
    {
        struct sockaddr_in sa;
        return inet_pton(AF_INET, str.c_str(), &(sa.sin_addr))!=0;
    }
     
    bool is_ipv6_address(const string& str)
    {
        struct sockaddr_in6 sa;
        return inet_pton(AF_INET6, str.c_str(), &(sa.sin6_addr))!=0;
    }
     
    void solve(const string& ipstr){
    	if(is_ipv4_address(ipstr))
    		cout<<"IPv4\n";
    	else if(is_ipv6_address(ipstr))
    		cout<<"IPv6\n";
    	else
    		cout<<"Neither\n";
     
    }
    int main(){
        int t=0;
        string teststr;
        getline(cin,teststr);
        for(int i=0;i<teststr.length();i++){
            t = t*10+(teststr[i]-'0');
        }
     
        while(t--){
            string ipstr;
            getline(cin,ipstr);
            solve(ipstr);
        }
        return 0;
    }
*/