/*
-------------------------------------------------------
LeetCode #125 - Valid Palindrome

Pattern: Two Pointers
Difficulty: Easy


Approach:
Use two pointers, one starting from the beginning and one from the end of the string.

Skip all non-alphanumeric characters from both sides.
Compare the remaining characters after converting them
to lowercase.

If any pair of characters does not match, the string is not a palindrome.

If all valid characters match, the string is a palindrome.


Time Complexity: O(n)
Space Complexity: O(1)


Key Learning:
Use the Two Pointers pattern when we need to compare elements from both ends of a string or array.

Instead of creating a new cleaned string, we can simply skip spaces and special characters while moving the
pointers inward.
-------------------------------------------------------
*/

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        boolean result = isPalindrome(s);

        System.out.println("Input: " + s);
        System.out.println("Is Palindrome: " + result);
    }
}