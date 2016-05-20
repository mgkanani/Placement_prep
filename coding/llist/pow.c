#include<stdio.h>
double myPow(double x, int n) {

    double temp=x,result=1;
	long sn=n;
    sn=(sn<0)?(-sn):sn;
	printf("%d\n",sn);
    while(sn){

        if(sn&1){

            result*=temp;

        }

        temp*=temp;

        sn=sn>>1;

    }
	if(n<0)
		return 1/result;
    return result;

}

int main(){
	double x = myPow(1.00000, -2147483648);
	printf("%lf",x);
}
