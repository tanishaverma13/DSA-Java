/*
-------------------------------------------------------
LeetCode #128 - Longest Consecutive Sequence

Pattern: HashSet
Difficulty: Medium

Approach:
Store all numbers in a HashSet for O(1) average lookup.

For every number, check if num - 1 exists.
If it does not exist, num is the beginning of a
consecutive sequence.

Then keep checking num + 1, num + 2, etc. using
the HashSet and count the length of the sequence.

Update the maximum sequence length found.

Why it works:
We only start counting from the beginning of a sequence.
This prevents repeatedly checking the same sequence.

Time Complexity: O(n)
Space Complexity: O(n)

Key Learning:
Use a HashSet when fast existence checking is required.
For consecutive sequence problems, identify the start
of a sequence using (num - 1) before expanding forward.
-------------------------------------------------------
*/

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {2, 20, 4, 10, 3, 4, 5};

        int result = longestConsecutive(nums);

        System.out.println("Longest consecutive sequence length: " + result);
    }
}