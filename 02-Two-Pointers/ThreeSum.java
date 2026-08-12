/*
-------------------------------------------------------
LeetCode #15 - 3Sum

Pattern: Sorting + Two Pointers
Difficulty: Medium

Problem:
Find all unique triplets in the array whose sum is 0.
The same triplet should not appear more than once.

Approach:
1. Sort the array.
2. Fix one element using index i.
3. Use two pointers:
   left = i + 1
   right = nums.length - 1
4. Calculate the sum of the three elements.
5. If sum == 0:
   - Add the triplet to the result.
   - Move both pointers.
   - Skip duplicate values using while loops.
6. If sum < 0:
   - Move left forward to increase the sum.
7. If sum > 0:
   - Move right backward to decrease the sum.
8. Skip duplicate values for i using an if condition.

Key Learning:
3Sum = Fix one element + Solve the remaining 2Sum
using Two Pointers.

Why Sorting?
- Allows Two Pointer technique.
- Makes it easy to skip duplicates.
- Allows us to decide which pointer to move.

Duplicate Handling:
- For i → use if because we skip the duplicate starting
  value once before starting a new search.
- For left/right → use while because there can be multiple
  consecutive duplicate values that all need to be skipped.

Time Complexity: O(n²)
Space Complexity: O(1) excluding the output list.

-------------------------------------------------------
*/

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = threeSum(nums);

        System.out.println("Triplets: " + result);
    }
}