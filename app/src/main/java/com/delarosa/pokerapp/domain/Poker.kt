package com.delarosa.pokerapp.domain

class Poker {

    fun isStraight(hand: List<Int>): Boolean {
        val completeList = completeList(hand)
        val sortedList = takeTheAs(completeList).sorted()
        return isPokerHand(sortedList)
    }

    fun completeList(hand: List<Int>): List<Int> {
        val list = hand.toMutableList()
        if (list.size < MAX_HAND_SIZE) {
            val difference = MAX_HAND_SIZE - list.size
            for (i in MIN_INDEX_VALUE..difference) {
                list.add(NOT_VALID_NUMBER)
            }
        }
        return list.toList()
    }

    private fun takeTheAs(hand: List<Int>): List<Int> {
        if (!hand.contains(AS)) {
            return hand
        }
        val index: Int = hand.indexOf(AS)
        val listAs = hand.toMutableList()
        listAs[index] = AS_VALUE
        return listAs.toList()
    }

    private fun isPokerHand(hand: List<Int>): Boolean {
        val visited = BooleanArray(VISITED_SIZE)
        for (i in MIN_INDEX_VALUE until MAX_HAND_SIZE) {
            val prevPosition = i - 1
            visited[prevPosition] = (hand[i] == hand[prevPosition] + 1)
        }

        val checkMaxConsecutive = BooleanArray(MAX_CONSECUTIVE_SIZE)
        for (i in MIN_INDEX_VALUE_CONSECUTIVE until MAX_CONSECUTIVE_SIZE) {
            checkMaxConsecutive[i] = (visited[i] and visited[i + 1] and visited[i + 2] and visited[i + 3])
        }
        return (checkMaxConsecutive.contains(true))
    }
}