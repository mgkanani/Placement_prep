public class CompVerNum {
    public int compareVersion(String v1, String v2) {
        String s1[] = v1.split("\\.");
        String s2[] = v2.split("\\.");
        //System.out.println(s1[0]+"\t"+s2[0]);
        int i=0;
        String t1,t2;
        int ret=0;
        while(i<Math.max(s1.length,s2.length)){
            if(s1.length<=i)
                t1="0";
            else
                t1 = s1[i];
            if(s2.length<=i)
                t2="0";
            else
                t2=s2[i];
            ret = compL(t1,t2);
            if(ret!=0){
                return ret/Math.abs(ret);
            }
            i++;
        }
        return ret;
    }
    public int compL(String s1, String s2){
        //int ret=0;
        if(s1.length()==s2.length())
            return s1.compareTo(s2);
        int len = Math.max(s1.length(),s2.length());
        StringBuilder br1 = new StringBuilder(len);
        StringBuilder br2 = new StringBuilder(len);
        //int i=0;
        while(br1.length()<len-s1.length()){
            br1.append(0);
        }
        br1.append(s1);
        //i=0;
        while(br2.length()<len-s2.length()){
            br2.append(0);
        }
        br2.append(s2);
        return br1.toString().compareTo(br2.toString());
    }
}

/*
Compare Version Numbers
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/