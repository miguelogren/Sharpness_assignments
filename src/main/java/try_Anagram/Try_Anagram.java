package try_Anagram;

import java.util.Arrays;

public class Try_Anagram {
    public boolean isAnagram(String word1, String word2) {
        if (word1.length() == word2.length()) {

            char[] wordArray1 = word1.toLowerCase().toCharArray();
            char[] wordArray2 = word2.toLowerCase().toCharArray();

            Arrays.sort(wordArray1);
            Arrays.sort(wordArray2);

            if (Arrays.equals(wordArray1,wordArray2)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
