package com.delarosa.pokerapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.delarosa.pokerapp.domain.GetHand
import com.delarosa.pokerapp.domain.Poker

class MainViewModel(
    private val poker: Poker,
    private val getHand: GetHand
) : ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel> = _model

    fun dealingCards() {
        val list = getHand()
        with(list) {
            _model.value = UiModel.ShowHand(poker.completeList(this))
            _model.value = UiModel.IsPokerHand(poker.isStraight(this))
        }
    }

    sealed class UiModel {
        data class ShowHand(val list: List<Int>) : UiModel()
        data class IsPokerHand(val isPokerHand: Boolean) : UiModel()
    }
}