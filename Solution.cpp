
#include <cmath>
#include <array>
#include <string>
using namespace std;

class Solution {

    static const int ALPHABET_SIZE = 26;
    static const int NUMBER_OF_BUTTONS = 8;

public:
    int minimumPushes(const string& word) const {
        array<int, ALPHABET_SIZE> frequency{};
        for (const auto& letter : word) {
            ++frequency[letter - 'a'];
        }
        ranges::sort(frequency);

        int minimumPushes = 0;
        int numberOfUniqueLetters = 0;
        for (size_t i = ALPHABET_SIZE - 1; i != variant_npos; --i) {
            if (frequency[i] > 0) {
                ++numberOfUniqueLetters;
                int placeOnButton = ceil(static_cast<double>(numberOfUniqueLetters) / NUMBER_OF_BUTTONS);
                minimumPushes += frequency[i] * placeOnButton;
            }
        }
        return minimumPushes;
    }
};
