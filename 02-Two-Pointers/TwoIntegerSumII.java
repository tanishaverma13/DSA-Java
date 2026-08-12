/*
-------------------------------------------------------
LeetCode #167 - Two Sum II - Input Array Is Sorted

Pattern: Two Pointers
Difficulty: Medium


Approach:
Use two pointers:
- left starts from the beginning of the array.
- right starts from the end of the array.

Since the array is sorted:
- If the sum is smaller than target, move left forward
  to get a larger value.
- If the sum is greater than target, move right backward
  to get a smaller value.
- If the sum equals target, return the 1-indexed positions.


Time Complexity: O(n)
Space Complexity: O(1)


Key Learning:
A sorted array allows us to use the Two Pointer technique.
Instead of checking every possible pair, we eliminate
impossible pairs by moving either the left or right pointer.

Java arrays are 0-indexed, but this problem requires
1-indexed output, so we return left + 1 and right + 1.
-------------------------------------------------------
*/

import java.util.Arrays;

public class TwoIntegerSumII {

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4};
        int target = 3;

        int[] result = twoSum(numbers, target);

        System.out.println("Result: " + Arrays.toString(result));
    }
}