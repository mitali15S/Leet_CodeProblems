class Solution {
    public int lengthOfLongestSubstring(String s) {
        String currentWindow = "";
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            String currentChar = String.valueOf(s.charAt(i));

            if (currentWindow.contains(currentChar)) {
                int duplicateIndex = currentWindow.indexOf(currentChar);
                currentWindow = currentWindow.substring(duplicateIndex + 1);
            }

            currentWindow += currentChar;

            if (currentWindow.length() > maxLength) {
                maxLength = currentWindow.length();
            }
        }

        return maxLength;
    }
}

    
