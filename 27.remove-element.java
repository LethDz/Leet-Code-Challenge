/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {

    public int removeElement(int[] nums, int val) {
        int removedElements = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean needRemoved = false;
            if (nums[i] == val) {
                needRemoved = true;
            }
            if (needRemoved) {
                int opposeIndex = nums.length - 1;

                while (opposeIndex >= i) {
                    if (nums[opposeIndex] == val) {
                        nums[opposeIndex] = -1;
                        removedElements++;
                    } else if (nums[opposeIndex] != -1) {
                        nums[i] = nums[opposeIndex];
                        nums[opposeIndex] = -1;
                        removedElements++;
                        break;
                    }
                    opposeIndex--;
                }
            }
        }
        return nums.length - removedElements;
    }
}
// @lc code=end
