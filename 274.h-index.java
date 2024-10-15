/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 *
 * https://leetcode.com/problems/h-index/description/
 *
 * algorithms
 * Medium (39.19%)
 * Likes:    1315
 * Dislikes: 594
 * Total Accepted:    520.7K
 * Total Submissions: 1.3M
 * Testcase Example:  '[3,0,6,1,5]'
 *
 * Given an array of integers citations where citations[i] is the number of
 * citations a researcher received for their i^th paper, return the
 * researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: The h-index is defined
 * as the maximum value of h such that the given researcher has published at
 * least h papers that have each been cited at least h times.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each
 * of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the
 * remaining two with no more than 3 citations each, their h-index is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: citations = [1,3,1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 * 
 * 
 */

// @lc code=start

class Solution {
    public boolean check(int[] citations, int mid) {
        int c = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= mid)
                c++;
            if (c >= mid)
                return true;
        }
        return false;
    }

    public int hIndex(int[] citations) {
        int l = citations.length;
        int st = 0;
        int ed = l;
        int ans = Integer.MIN_VALUE;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (check(citations, mid)) {
                ans = Math.max(mid, ans);
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return ans;
    }
}
// @lc code=end
