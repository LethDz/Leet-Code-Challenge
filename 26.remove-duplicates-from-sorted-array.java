/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start

class Solution {
    public int removeDuplicates(int[] nums) {
        int checkPointIndex = 0;
        int checkPointValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (checkPointValue != nums[i]) {
                checkPointValue = nums[i];
                checkPointIndex += 1;
                nums[checkPointIndex] = checkPointValue;
            }
        }

        return checkPointIndex + 1;
    }
}
// @lc code=end

