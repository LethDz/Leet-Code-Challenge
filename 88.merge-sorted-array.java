/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] bufferArray = nums1.clone();
        int secondIndex = 0;
        int firstIndex = 0;
        for (int index = 0; index < (m + n); index++) {
            int nums1Element = bufferArray[firstIndex];

            if (nums2.length <= secondIndex) {
                nums1[index] = nums1Element;
                firstIndex++;
                continue;
            }

            int nums2Element = nums2[secondIndex];
            if (firstIndex >= m || nums1Element > nums2Element) {
                nums1[index] = nums2Element;
                secondIndex++;
            } else {
                nums1[index] = nums1Element;
                firstIndex++;
            }
        }
    }
}
// @lc code=end

