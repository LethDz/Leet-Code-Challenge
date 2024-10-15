/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (45.50%)
 * Likes:    9079
 * Dislikes: 2109
 * Total Accepted:    1.4M
 * Total Submissions: 3.2M
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mappedIndexInSByChar = new HashMap<>();
        Map<Character, Character> mappedIndexInTByChar = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character mappedChar = mappedIndexInSByChar.get(s.charAt(i));
            if (mappedChar == null) {
                Character sameCharExist = mappedIndexInTByChar.get(t.charAt(i));
                if (sameCharExist != null && !Character.valueOf(s.charAt(i)).equals(sameCharExist)) {
                    return false;
                }
                mappedIndexInSByChar.put(s.charAt(i), t.charAt(i));
                mappedIndexInTByChar.put(t.charAt(i), s.charAt(i));
            } else if (!mappedChar.equals(Character.valueOf(t.charAt(i)))) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
