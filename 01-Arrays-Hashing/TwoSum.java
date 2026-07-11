/*
-------------------------------------------------------
LeetCode #1 - Two Sum

Pattern: Arrays + HashMap
Difficulty: Easy

Approach:
Store previously seen numbers in a HashMap.
For each element, compute the complement (target - current).
If the complement exists, return both indices.
Otherwise, store the current number with its index.

Time Complexity: O(n)
Space Complexity: O(n)

Key Learning:
Use HashMap for O(1) lookup to avoid checking every pair.
-------------------------------------------------------
*/

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,7};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}

    
