/*
-------------------------------------------------------
LeetCode #16 - 3Sum Closest

Pattern: Sorting + Two Pointers
Difficulty: Medium

Problem:
Find three integers in the array whose sum is closest
to the given target and return the sum of those three
integers.

Approach:
1. Sort the array.
2. Fix one element using index i.
3. Use two pointers (left and right) to find the
   remaining two elements.
4. Calculate the current sum.
5. Keep track of the sum that is closest to target.
6. If current sum is smaller than target, move left.
7. If current sum is larger than target, move right.
8. If sum equals target exactly, return immediately.

Key Learning:
3Sum Closest uses the same core pattern as 3Sum:
Fix one element + Two Pointers.

Difference from 3Sum:
3Sum looks for sum == 0 and returns all valid triplets.
3Sum Closest looks for the sum closest to target and
returns only that sum.

Time Complexity: O(n²)
Space Complexity: O(1) excluding the sorting implementation.

-------------------------------------------------------
*/

import java.util.*;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        int result = threeSumClosest(nums, target);

        System.out.println("Closest Sum: " + result);
    }
}