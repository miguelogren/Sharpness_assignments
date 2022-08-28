package try_Anagram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Try_AnagramTest {

    Try_Anagram anagram = new Try_Anagram();

    @Test
    void isAnagram() {

        String correctWord1_1 = "ABBA";
        String correctWord1_2 = "baab";
        String incorrectWord1_1 = "katta";
        String incorrectWord1_2 = "matta";

        assertTrue(anagram.isAnagram(correctWord1_1,correctWord1_2));
        assertFalse(anagram.isAnagram(incorrectWord1_1, incorrectWord1_2));

    }
}