package com.delarosa.pokerapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.delarosa.pokerapp.domain.GetHand
import com.delarosa.pokerapp.domain.Poker
import com.delarosa.pokerapp.view.MainViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val observer = mockk<Observer<MainViewModel.UiModel>>()
    private val poker = mockk<Poker>()
    private val getHand = mockk<GetHand>()

    private lateinit var mainViewModel: MainViewModel

    private val hand = listOf(2, 3, 4, 5, 6)
    private val completeHand = listOf(14, 2, 3, 4, 5, 6, 7)

    @Ignore
    @Test()
    fun `when dealingCards is called then should call poker and getHand`() {
        every { poker.isStraight(completeHand) } answers { true }
        every { poker.completeList(hand) } answers { completeHand }

        every { getHand.invoke() } answers { hand }

        mainViewModel = MainViewModel(poker, getHand)

        mainViewModel.model.observeForever(observer)

        mainViewModel.dealingCards()

        verify {
            observer.onChanged(MainViewModel.UiModel.ShowHand(poker.completeList(hand)))
            observer.onChanged(MainViewModel.UiModel.IsPokerHand(poker.isStraight(completeHand)))
        }
    }
}