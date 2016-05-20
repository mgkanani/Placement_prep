public class StringInterleaving {
    String s1,s2,s3;
    int [][] dp;
    public boolean isInterleave(String st1, String st2, String st3) {
        s1 = st1 ;
        s2 = st2;
        s3 = st3 ;
        if(st1==null || st1.equals(""))
            return st3==st2 || st3.equals(st2);
        if(st2==null || st2.equals(""))
            return st1.equals(st3);
        if(st1.length()+st2.length()!=st3.length())
            return false;
        dp = new int[s1.length()][s2.length()];
        for(int i=0;i<s1.length();i++)
            for(int j=0; j<s2.length();j++)
                dp[i][j]=-1;
        return check(s1.length()-1,s2.length()-1,s3.length()-1);
    }
    boolean check(int i1, int i2, int i3){
        if(i1<0){
            if(i2!=i3)
                return false;
            int i=0;
            //System.out.println(i2+"\t"+i3);
            for(i=i2;i>=0 && s2.charAt(i)==s3.charAt(i);i--);
            return i<0;
        }else if(i2<0){
            if(i1!=i3)
                return false;
            int i=0;
            for(i=i1;i>=0 && s1.charAt(i)==s3.charAt(i);i--);
            return i<0;
        }
        if(dp[i1][i2]==-1){
            boolean t1 = s1.charAt(i1)==s3.charAt(i3);
            boolean t2 = s2.charAt(i2)==s3.charAt(i3);
            if(t1 && t2){
                if(check(i1-1,i2,i3-1) || check(i1,i2-1,i3-1))
                    dp[i1][i2]=1;
                else
                    dp[i1][i2]=0;
            }else if(t1){
                if(check(i1-1,i2,i3-1))
                    dp[i1][i2]=1;
                else
                    dp[i1][i2]=0;
            }else if(t2){
                if(check(i1,i2-1,i3-1))
                    dp[i1][i2]=1;
                else
                    dp[i1][i2]=0;
            }else{
                dp[i1][i2]=0;
            }
        }
        return dp[i1][i2]==1;
    }
}