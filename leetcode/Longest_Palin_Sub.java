public class Longest_Palin_Sub {
//Longest Palindromic Substring
    public String longestPalindrome(String s) {

        if(s==null||s.length()<=1)

            return s;

        int i,j,k;

        int l=0,r=0,max=0,len=s.length();

        for(i=0;i<len;i++){

            k=0;

            while((i-k)>=0 && (i+k<len) && s.charAt(i-k)==s.charAt(i+k)){//odd length

                k++;

            }

            if(max<(2*k-1)){

                l=i-k+1;

                r=i+k;

                max=2*k-1;

            }

            k=0;

            while((i-k)>=0 && (i+k+1<len) && s.charAt(i-k)==s.charAt(i+k+1)){//even length

                k++;

            }

            if(max<(2*k)){

                max=2*k;

                l=i-k+1;

                r=i+k+1;

            }

        }

        return s.substring(l,r);

   }

}
