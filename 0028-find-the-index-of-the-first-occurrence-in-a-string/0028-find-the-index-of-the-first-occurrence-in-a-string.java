class Solution {
   public int strStr(String haystack, String needle) {
    if (haystack.equalsIgnoreCase(needle) ) {
            return 0;
        }
        int n = needle.length();
        for(int i = 0; i <= haystack.length()-n; i++) {
            if(haystack.substring(i,i+n).equalsIgnoreCase(needle)) {
                return i;
            }
        }
        return -1;
    }
}