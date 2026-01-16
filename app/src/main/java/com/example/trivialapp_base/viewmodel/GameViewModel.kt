package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Difficult
import com.example.trivialapp_base.model.DifficultyProvider
import com.example.trivialapp_base.model.Question
import kotlin.random.Random

class GameViewModel : ViewModel() {
    private var gameQuestions: MutableList<Question> = mutableListOf()
    var questionIndex by mutableIntStateOf(0)
        private set

    var currentQuestion by mutableStateOf<Question>(Question("Pregunta de ejemplo", "Nada", listOf("Si", "No", "Talvez", "Solo el Martes"), "París"))
        private set

    var mixedAnswers by mutableStateOf<List<String>>(emptyList())
        private set

    var points by mutableIntStateOf(0)
        private set

    var remindingTime by mutableFloatStateOf(100f)
        private set

    var gameFinalized by mutableStateOf(false)
        private set
    var difficultySelected by mutableStateOf(DifficultyProvider.easy())
        private set

    private var timer: CountDownTimer? = null
    private val TIME_PER_QUESTION = 10000L // 10 segons

    fun setDifficulty(difficulty: Difficult) {
        difficultySelected = difficulty // Sense .value!
        gameQuestions = difficulty.questions
    }
    fun startGame() {
        gameFinalized = false
    }

    private fun reloadQuestion() {
        if (difficultySelected.questionsAmount < 0) {
            gameQuestions.removeAt(questionIndex)
            questionIndex = Random.nextInt(0,gameQuestions.lastIndex)
            currentQuestion = gameQuestions[questionIndex]
            difficultySelected.questionsAmount =- 1
        } else {
            gameFinalized = true
        }
    }

    fun answerQuestion(userAnswer: String) {
        if (userAnswer == currentQuestion.correctAnswer){
            points ++
        }
    }

    private fun continueRound() {
    }

    private fun startTimer() {
    }

    override fun onCleared() {
    }
}
