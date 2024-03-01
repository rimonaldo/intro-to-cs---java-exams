package T2017.A86;

public class Question1 {
    public static int edit(String str1, String str2) {
        return edit(str1, str2, 0, 0, 0);
    }

    public static int edit(String str1, String str2, int i, int j, int count) {
        if (str1.equals(str2)) {
            return 0;
        }
        String temp = "";

        if (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                return edit(str1, str2, i + 1, j + 1, count);
            }
        }

        // is str1 < str2
        if (str1.length() <= str2.length()) {

            // if i is in bounds of str1
            if (i < str1.length()) {
                // split str up to char i,
                // add char j from str2,
                // add rest of str1 (from i to end)
                temp = str1.substring(0, i) + str2.charAt(j) + str1.substring(i);
            } else {
                // only add char j
                temp = str1 + str2.charAt(j);
            }
            // iterate it to the next i and j
            return 1 + edit(temp, str2, i + 1, j + 1, count + 1);
        } else {
            // else , str1 > str2
            // and we need to remove char i
            temp = str1.substring(0, i) + str1.substring(i+1);
            return 1 + edit(temp, str2, i + 1, j, count + 1);
        }

    }
}
