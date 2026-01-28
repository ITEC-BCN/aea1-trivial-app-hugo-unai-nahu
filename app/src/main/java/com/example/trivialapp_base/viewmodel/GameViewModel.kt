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

class GameViewModel : ViewModel() {
    private var gameQuestions: MutableList<Question> = mutableListOf()
    var questionIndex by mutableIntStateOf(0)
        private set
    var questionAnswered by mutableStateOf(false)
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
    private var questionAmount = 0
    private var timer: CountDownTimer? = null
    private var TIME_PER_QUESTION = 10000L // 10 segons

    fun setDifficulty(difficulty: Difficult) {
        difficultySelected = difficulty // Sense .value!
        TIME_PER_QUESTION = difficulty.timePerQuestion
    }
    fun startGame() {
        gameFinalized = false
        gameQuestions = difficultySelected.questions
        questionAmount = difficultySelected.questionsAmount
        reloadQuestion()
    }

    private fun reloadQuestion() {
        if (questionAmount > 0) {
            questionIndex = (0 until gameQuestions.size).random()
            currentQuestion = gameQuestions[questionIndex]
            mixAnswers()
            gameQuestions.removeAt(questionIndex)
            questionAmount --
            startTimer()
        } else {
            gameFinalized = true
        }
    }
    private fun mixAnswers(){
        mixedAnswers = currentQuestion.answers.shuffled()
    }

    fun answerQuestion(answer: String) {
        questionAnswered = true
        if (answer == currentQuestion.correctAnswer){
            points ++
        }
        timer?.cancel()
    }

    fun continueRound() {
        questionAnswered = false
        reloadQuestion()
    }

    private fun startTimer() {
        timer?.cancel()
        timer = object : CountDownTimer(TIME_PER_QUESTION, 100) {
            override fun onTick(millisUntilFinished: Long) {
                // Actualitzem l'estat directament
                remindingTime = millisUntilFinished.toFloat() / TIME_PER_QUESTION
            }

            override fun onFinish() {
                remindingTime = 0f
                answerQuestion(" ")
            }
        }.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}
