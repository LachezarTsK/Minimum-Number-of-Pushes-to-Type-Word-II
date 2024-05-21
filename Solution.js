
/**
 * @param {string} word
 * @return {number}
 */
var minimumPushes = function (word) {
    const ALPHABET_SIZE = 26;
    const NUMBER_OF_BUTTONS = 8;

    const frequency = new Array(ALPHABET_SIZE).fill(0);
    for (let letter of word) {
        ++frequency[getASCII(letter) - getASCII('a')];
    }
    frequency.sort((x, y) => x - y);

    let minimumPushes = 0;
    let numberOfUniqueLetters = 0;
    for (let i = ALPHABET_SIZE - 1; i >= 0; --i) {
        if (frequency[i] > 0) {
            ++numberOfUniqueLetters;
            let placeOnButton = Math.ceil(numberOfUniqueLetters / NUMBER_OF_BUTTONS);
            minimumPushes += frequency[i] * placeOnButton;
        }
    }
    return minimumPushes;
};

/**
 * @param {string} letter
 * @return {number}
 */
function getASCII(letter) {
    return letter.codePointAt(0);
}
