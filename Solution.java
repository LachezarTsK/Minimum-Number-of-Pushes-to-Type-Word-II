
import java.util.Arrays;

public class Solution {

    private static final int ALPHABET_SIZE = 26;
    private static final int NUMBER_OF_BUTTONS = 8;

    public int minimumPushes(String word) {
        int[] frequency = new int[ALPHABET_SIZE];
        for (char letter : word.toCharArray()) {
            ++frequency[letter - 'a'];
        }
        Arrays.sort(frequency);

        int minimumPushes = 0;
        int numberOfUniqueLetters = 0;
        for (int i = ALPHABET_SIZE - 1; i >= 0; --i) {
            if (frequency[i] > 0) {
                ++numberOfUniqueLetters;
                int placeOnButton = (int) Math.ceil((double) numberOfUniqueLetters / NUMBER_OF_BUTTONS);
                minimumPushes += frequency[i] * placeOnButton;
            }
        }
        return minimumPushes;
    }
}
