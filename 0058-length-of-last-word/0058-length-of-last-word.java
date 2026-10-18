class Solution {
    public int lengthOfLastWord(String s) {
        String l = s.trim();
        String arr[] = l.split(" ");
        int len = arr.length;
         return arr[len - 1].length();
    }
}