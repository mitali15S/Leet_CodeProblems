class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];
        for(int  i =0; i < strs.length; i++){
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0,pre.length() - 1);
            }
            if(pre.length() == 0) return "";
        }
        return pre;
    }
}