/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int checkPointIndex = 0;
        int checkPointValue = nums[0];
        int duplicateCounter = 1;

        for (int index = 1; index < nums.length; index++) {
            if (checkPointValue != nums[index]) {
                checkPointValue = nums[index];
                checkPointIndex += 1;
                duplicateCounter = 1;
                nums[checkPointIndex] = checkPointValue;
                continue;
            }

            if (checkPointValue == nums[index] && duplicateCounter < 2) {
                checkPointValue = nums[index];
                checkPointIndex += 1;
                duplicateCounter += 1;
                nums[checkPointIndex] = checkPointValue;
            }
        }

        return checkPointIndex + 1;
    }
}
// @lc code=end
