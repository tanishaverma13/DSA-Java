/*
-------------------------------------------------------
LeetCode #49 - Group Anagrams

Pattern: HashMap + String Processing
Difficulty: Medium

Approach:
Sort each string to generate a common key.
Store all words with the same sorted key in a HashMap.
Return all grouped values from the HashMap.

Time Complexity: O(n × k log k)
Space Complexity: O(n × k)

Key Learning:
Anagrams produce the same sorted string, making it an ideal
HashMap key for grouping efficiently.
-------------------------------------------------------
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
