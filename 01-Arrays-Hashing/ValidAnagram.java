/*
-------------------------------------------------------
LeetCode 242 - Valid Anagram

Pattern: Frequency Counting
Difficulty: Easy

Approach:
Frequency Array

Time Complexity: O(n)
Space Complexity: O(1)

Key Learning:
Compare character frequencies instead of character order.
-------------------------------------------------------
*/

class Solution {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {

            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {

            if (count != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
    System.out.println(isAnagram("anagram", "nagaram"));
    }
}