
package main

import (
	"fmt"
	"math"
	"slices"
)

const ALPHABET_SIZE = 26
const NUMBER_OF_BUTTONS = 8

func minimumPushes(word string) int {
	var frequency = make([]int, ALPHABET_SIZE)
	for _, letter := range word {
		frequency[letter-'a']++
	}

	slices.Sort(frequency)
	var minimumPushes = 0
	var numberOfUniqueLetters = 0
	for i := ALPHABET_SIZE - 1; i >= 0; i-- {
		if frequency[i] > 0 {
			numberOfUniqueLetters++
			var placeOnButton = int(math.Ceil(float64(numberOfUniqueLetters) / NUMBER_OF_BUTTONS))
			minimumPushes += frequency[i] * placeOnButton
		}
	}
	return minimumPushes
}
