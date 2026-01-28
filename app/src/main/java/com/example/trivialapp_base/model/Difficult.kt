package com.example.trivialapp_base.model

data class Difficult (
    var difficulty: String,
    var timePerQuestion: Long,
    var questionsAmount: Int,
    var questions: MutableList<Question>
)

object DifficultyProvider {
    fun easy(): Difficult{
        return Difficult(
            "Facil",
            10000L,
            5,
            QuestionProvider.easyQuestions()
        )
    }

    fun midl(): Difficult{
        return Difficult(
            "Mitja",
            7500L,
            10,
            QuestionProvider.midlQuestions()
        )
    }

    fun hard(): Difficult{
        return Difficult(
            "Dificil",
            5000L,
            15,
            QuestionProvider.hardQuestions()
        )
    }
}