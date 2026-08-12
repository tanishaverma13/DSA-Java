/*
-------------------------------------------------------
LeetCode #238 - Product of Array Except Self


Pattern: Prefix Product + Suffix Product
Difficulty: Medium


Approach:
First, store the product of all elements to the left of
each index in the output array.

Then traverse from right to left while maintaining a
running product of all elements to the right.
Multiply this right product with the left product already
stored in the output array.


Time Complexity: O(n)
Space Complexity: O(1) extra space


Key Learning:
For every index, the answer is the product of everything
on its left multiplied by the product of everything on
its right.

We can store the left products directly in the output
array and calculate the right products on the fly,
avoiding an extra array.
-------------------------------------------------------
*/

import java.util.Arrays;


public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] output = new int[n];

        output[0] = 1;
        for(int i = 1; i<n; i++){
            output[i] = output[i-1] * nums[i-1];
        }

        int right = 1;
        for(int i = n-1; i>=0; i--){
            output[i] = output[i] * right;
            right = right * nums[i];
        }

        return output;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 6};

        System.out.println(
            Arrays.toString(productExceptSelf(nums))
        );
    }
}