import java.util.*;

class My  implements Comparator<Integer>{
      static CharSequence S;
      public void set(CharSequence S){
        this.S=S;
      }
      public int compare(Integer a, Integer b){
        return S.charAt(a) - S.charAt(b);
      }
}

public class NthSubString {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        int[] sa1 = suffixArray(str);
        System.out.println(str.substring(sa1[k-1]));
    }
    
    public static int[] suffixArray(CharSequence S) {

        int n = S.length();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++)
          order[i] = n - 1 - i;

        // stable sort of characters
        My comp = new My();
        comp.set(S);
        Arrays.sort(order, comp);

        int[] sa = new int[n];
        int[] classes = new int[n];
        for (int i = 0; i < n; i++) {
          sa[i] = order[i];
          classes[i] = S.charAt(i);
        }
        // sa[i] - suffix on i'th position after sorting by first len characters
        // classes[i] - equivalence class of the i'th suffix after sorting by first len characters

        for (int len = 1; len < n; len *= 2) {
          int[] c = classes.clone();
          for (int i = 0; i < n; i++) {
            // condition sa[i - 1] + len < n simulates 0-symbol at the end of the string
            // a separate class is created for each suffix followed by simulated 0-symbol
            classes[sa[i]] = i > 0 && c[sa[i - 1]] == c[sa[i]] && sa[i - 1] + len < n && c[sa[i - 1] + len / 2] == c[sa[i] + len / 2] ? classes[sa[i - 1]] : i;
          }
          // Suffixes are already sorted by first len characters
          // Now sort suffixes by first len * 2 characters
          int[] cnt = new int[n];
          for (int i = 0; i < n; i++)
            cnt[i] = i;
          int[] s = sa.clone();
          for (int i = 0; i < n; i++) {
            // s[i] - order of suffixes sorted by first len characters
            // (s[i] - len) - order of suffixes sorted only by second len characters
            int s1 = s[i] - len;
            // sort only suffixes of length > len, others are already sorted
            if (s1 >= 0)
              sa[cnt[classes[s1]]++] = s1;
          }
        }
        return sa;
  }
}
