import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        wordPattern("abba", "dog cat cat fish");
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<String, Character> mapCharacterByString = new HashMap<>();
        StringBuilder splittedWord = new StringBuilder();
        int wordIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isSpaceChar(s.charAt(i)) || i == s.length() - 1) {
                if (i == s.length() - 1) {
                    splittedWord.append(s.charAt(i));
                }
                Character patternChar = mapCharacterByString.get(splittedWord.toString());
                if (patternChar != null && !patternChar.equals(pattern.charAt(wordIndex))) {
                    return false;
                }
                mapCharacterByString.put(splittedWord.toString(), pattern.charAt(wordIndex));
                wordIndex++;
                splittedWord.delete(0, splittedWord.length());
            } else {
                splittedWord.append(s.charAt(i));
            }
        }

        return true;
    }
}
