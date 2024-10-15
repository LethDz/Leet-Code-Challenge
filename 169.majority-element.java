/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mapMajorityByNumber = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            Integer majority = mapMajorityByNumber.get(nums[index]);
            mapMajorityByNumber.put(Integer.valueOf(nums[index]), majority == null ? 0 : majority.intValue() + 1);
        }

        return mapMajorityByNumber.entrySet().stream().parallel()
                .max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).get().getKey();
    }
}
// @lc code=end
