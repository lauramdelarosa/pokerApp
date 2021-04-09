package com.delarosa.pokerapp.domain

import org.junit.Assert
import org.junit.Test

class PokerTest {

    @Test
    fun `when Poker is called then should validate hands`() {
        val poker = Poker()

        val hand1 = listOf(2, 3, 4, 5, 6)
        Assert.assertTrue(poker.isStraight(hand1))

        val hand2 = listOf(14, 5, 4, 2, 3)
        Assert.assertTrue(poker.isStraight(hand2))

        val hand3 = listOf(7, 5, 3, 4, 6, 8, 4)
        Assert.assertTrue(poker.isStraight(hand3))

        val hand4 = listOf(2, 2, 2, 2, 2)
        Assert.assertFalse(poker.isStraight(hand4))

        val hand5 = listOf(3, 4, 5, 6, 8)
        Assert.assertFalse(poker.isStraight(hand5))

        val hand6 = listOf(1, 3, 2)
        Assert.assertFalse(poker.isStraight(hand6))

        val hand7 = listOf(1, 3, 2, 9, 8, 6, 6, 7, 8, 9, 9)
        Assert.assertFalse(poker.isStraight(hand7))
    }
}