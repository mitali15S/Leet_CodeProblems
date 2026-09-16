class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0;
        int pIdx = 0;
        int matchIdx = 0;
        int starIdx = -1;
        while (sIdx < s.length()) {
            if(pIdx < p.length() && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))) {
                sIdx++;
                pIdx++;
            }
            else if(pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                matchIdx = sIdx;
                pIdx++;
            } else if (starIdx !=-1) {
                pIdx = starIdx + 1;
                matchIdx++;
                sIdx = matchIdx;
            }
            else {
                return false;
            }
        }
        while (pIdx < p.length() &&  p.charAt(pIdx) == '*') {
            pIdx++;
        }
        return pIdx == p.length();
    }
}