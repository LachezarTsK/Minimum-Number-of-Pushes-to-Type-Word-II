
import kotlin.math.ceil

class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
        const val NUMBER_OF_BUTTONS = 8
    }

    fun minimumPushes(word: String): Int {
        val frequency = IntArray(ALPHABET_SIZE)
        for (letter in word) {
            ++frequency[letter - 'a']
        }
        frequency.sort()

        var minimumPushes = 0
        var numberOfUniqueLetters = 0
        for (i in ALPHABET_SIZE - 1 downTo 0) {
            if (frequency[i] > 0) {
                ++numberOfUniqueLetters
                val placeOnButton = ceil(numberOfUniqueLetters.toDouble() / NUMBER_OF_BUTTONS).toInt()
                minimumPushes += frequency[i] * placeOnButton
            }
        }
        return minimumPushes
    }
}
