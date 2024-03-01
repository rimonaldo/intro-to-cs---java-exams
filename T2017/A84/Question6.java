package T2017.A84;

public class Question6 {
    public static String what(String s) {
        // int array of size 26 
        int[] c = new int[26];
        
        // string result
        String res = "";

        // for loop i = 0 --> s.length
        for (int i = 0; i < s.length(); i++) {
            // int p is the i char of s - 'a'
            int p = s.charAt(i) - 'a';
            // increments c[p] 
            c[p]++;
        }

        // for i = 0 --> 26
        for (int i = 0; i < c.length; i++) {
            // if c[i] is not 0
            if (c[i] != 0) {
                // well add to the result string 'a' + i
                char ch = (char) ('a' + i);
                res += ch;
            }
        }
        return res;
        // aacbab
        // a2a1a1
    }

    // st2 = aaaaaacaaabb 
    public static boolean secret(String s1, String s2) {
        return what(s1).equals(what(s2));
    }
}
