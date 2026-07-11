/*
-------------------------------------------------------
LeetCode 217 - Contains Duplicate

Pattern: Arrays + HashSet
Difficulty: Easy

Approach:
Traverse the array while storing each element in a HashSet.
If an element already exists in the HashSet, a duplicate is found.
Otherwise, add the element to the HashSet and continue.

Time Complexity: O(n)
Space Complexity: O(n)

Key Learning:
HashSet provides O(1) average lookup, making duplicate detection
much more efficient than comparing every pair of elements.
-------------------------------------------------------
*/

import java.util.HashSet;

public class ContainsDuplicate{
    public static boolean hasDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,8,2};
        System.out.println(hasDuplicate(nums));
    }
}