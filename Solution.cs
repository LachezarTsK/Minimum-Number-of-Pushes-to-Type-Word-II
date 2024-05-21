
using System;

public class Solution
{
    private static readonly int ALPHABET_SIZE = 26;
    private static readonly int NUMBER_OF_BUTTONS = 8;

    public int MinimumPushes(string word)
    {
        int[] frequency = new int[ALPHABET_SIZE];
        foreach (char letter in word)
        {
            ++frequency[letter - 'a'];
        }
        Array.Sort(frequency);

        int minimumPushes = 0;
        int numberOfUniqueLetters = 0;
        for (int i = ALPHABET_SIZE - 1; i >= 0; --i)
        {
            if (frequency[i] > 0)
            {
                ++numberOfUniqueLetters;
                int placeOnButton = (int)Math.Ceiling((double)numberOfUniqueLetters / NUMBER_OF_BUTTONS);
                minimumPushes += frequency[i] * placeOnButton;
            }
        }
        return minimumPushes;
    }
}
