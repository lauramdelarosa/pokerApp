package com.delarosa.pokerapp.domain


class GetHand {

    operator fun invoke(): List<Int> {
        val handSize = (MIN_HAND_SIZE..MAX_HAND_SIZE).random()
        val list = arrayListOf<Int>()
        for (i in MIN_INDEX_VALUE..handSize)
            list.add((MIN_HAND_VALUE..MAX_HAND_VALUE).random())
        return list.toList()
    }

}