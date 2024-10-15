/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (42.27%)
 * Likes:    7286
 * Dislikes: 1037
 * Total Accepted:    770.8K
 * Total Submissions: 1.8M
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapStringByChar = new HashMap<>();
        Map<String, Character> mapPatternByString = new HashMap<>();
        StringBuilder splittedWord = new StringBuilder();
        int wordIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean lastIndex = i == s.length() - 1;
            if (Character.isSpaceChar(s.charAt(i)) || lastIndex) {
                if (lastIndex) {
                    splittedWord.append(s.charAt(i));
                }

                Character patternChar;
                if (wordIndex >= pattern.length()) {
                    return false;
                } else {
                    patternChar = pattern.charAt(wordIndex);
                }
                String mappedWord = mapStringByChar.get(patternChar);
                Character mappedChar = mapPatternByString.get(splittedWord.toString());
                if (mappedWord != null && !mappedWord.equals(splittedWord.toString())) {
                    return false;
                }

                if (mappedChar != null && !mappedChar.equals(patternChar)) {
                    return false;
                }

                mapStringByChar.put(patternChar, splittedWord.toString());
                mapPatternByString.put(splittedWord.toString(), patternChar);
                wordIndex++;
                splittedWord.delete(0, splittedWord.length());

                if (lastIndex && wordIndex != pattern.length()) {
                    return false;
                }
            } else {
                splittedWord.append(s.charAt(i));
            }
        }

        return true;
    }
}
// @lc code=end
