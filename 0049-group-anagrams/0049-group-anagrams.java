import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to hold sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to char array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // sorted string as key
            
            // Add the original string to the corresponding group
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}
