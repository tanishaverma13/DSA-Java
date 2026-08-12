/*
-------------------------------------------------------
LeetCode #11 - Container With Most Water

Pattern: Two Pointer
Difficulty: Medium

Approach:
Use two pointers, one at the beginning and one at the end
of the array.

Area = min(height[left], height[right]) * (right - left)

Time Complexity: O(n)
Space Complexity: O(1)

Key Learning:
The amount of water depends on two things:
1. The shorter wall determines the height.
2. The distance between the two walls determines the width.

Always move the pointer at the shorter wall because moving
the taller wall only decreases the width while the shorter
wall still limits the height.
-------------------------------------------------------
*/

public class ContainerWithMostWater {

    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;

        while (left < right) {

            int h = Math.min(heights[left], heights[right]);
            int w = right - left;
            int area = h * w;

            maxWater = Math.max(maxWater, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {

        int[] heights = {1, 7, 2, 5, 4, 7, 3, 6};
        int result = maxArea(heights);
        System.out.println("Maximum Water: " + result);
    }
}