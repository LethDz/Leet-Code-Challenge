/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 *
 * https://leetcode.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (62.17%)
 * Likes:    5023
 * Dislikes: 502
 * Total Accepted:    1.3M
 * Total Submissions: 2M
 * Testcase Example:  '"a"\n"b"'
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Arrays.sort(ransomNoteChar);
        // Arrays.sort(magazineChar);

        // for (int i = 0; i < ransomNoteChar.length; i++) {
        // int foundedIndex = Arrays.binarySearch(magazineChar, ransomNoteChar[i]);
        // if (foundedIndex < 0) {
        // return false;
        // } else {
        // magazineChar[foundedIndex] = Character.MIN_VALUE;
        // Arrays.sort(magazineChar);
        // }
        // }

        // return true;

        HashMap<Character, Integer> charSet = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Integer existCount = charSet.get(magazine.charAt(i));
            if (existCount == null) {
                charSet.put(magazine.charAt(i), 1);
            } else {
                charSet.put(magazine.charAt(i), existCount + 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            Integer existCount = charSet.get(ransomNote.charAt(i));
            if (existCount == null || existCount <= 0) {
                return false;
            } else {
                charSet.put(ransomNote.charAt(i), existCount - 1);
            }
        }

        return true;
    }
}
// @lc code=end
