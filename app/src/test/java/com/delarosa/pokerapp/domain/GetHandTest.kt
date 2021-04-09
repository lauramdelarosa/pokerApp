package com.delarosa.pokerapp.domain

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetHandTest {

    lateinit var getHand: GetHand

    @Before
    fun before() {
        getHand = GetHand()
    }

    @Test
    fun `given number up to 14 when getHand is called then should return empty list`() {

        val result = getHand.invoke().filter { it > 14 }

        Assert.assertTrue(result.isEmpty())
    }

    @Test
    fun `when getHand is called then should always return list size less tha MAX_HAND_SIZE  `() {

        val result = getHand.invoke()

        Assert.assertTrue(result.size <= MAX_HAND_SIZE)
    }
}