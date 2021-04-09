package com.delarosa.pokerapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.delarosa.pokerapp.databinding.ActivityMainBinding
import com.delarosa.pokerapp.domain.NOT_VALID_NUMBER
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by currentScope.viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initViews()
    }

    private fun initViews() {
        binding.dealingCardsButton.setOnClickListener {
            mainViewModel.dealingCards()
        }
        mainViewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: MainViewModel.UiModel) {
        when (model) {
            is MainViewModel.UiModel.ShowHand -> showListInView(model.list)
            is MainViewModel.UiModel.IsPokerHand -> showPokerHand(model.isPokerHand)
        }
    }

    private fun showPokerHand(isPokerHand: Boolean) {
        if (isPokerHand) {
            binding.consecutive.visibility = View.VISIBLE
            binding.noConsecutive.visibility = View.INVISIBLE
        } else {
            binding.noConsecutive.visibility = View.VISIBLE
            binding.consecutive.visibility = View.INVISIBLE
        }
    }

    private fun showListInView(list: List<Int>) {
        binding.c1.text = if (validateText(0, list)) list[0].toString() else EMPTY
        binding.c2.text = if (validateText(1, list)) list[1].toString() else EMPTY
        binding.c3.text = if (validateText(2, list)) list[2].toString() else EMPTY
        binding.c4.text = if (validateText(3, list)) list[3].toString() else EMPTY
        binding.c5.text = if (validateText(4, list)) list[4].toString() else EMPTY
        binding.c6.text = if (validateText(5, list)) list[5].toString() else EMPTY
        binding.c7.text = if (validateText(6, list)) list[6].toString() else EMPTY
    }

    private fun validateText(position: Int, list: List<Int>): Boolean =
        list[position] != NOT_VALID_NUMBER

}

const val EMPTY = ""