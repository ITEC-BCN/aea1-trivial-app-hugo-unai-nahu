package com.example.trivialapp_base.model

data class Difficult (
    var difficulty: String,
    var timePerQuestion: Float,
    var questionsAmount: Int,
    var questions: MutableList<Answer>
)

object DifficultyProvider {
    fun easy(): Difficult{
        return Difficult(
            "Facil",
            100f,
            5,
            QuestionProvider.easyQuestions()
        )
    }

    fun midl(): Difficult{
        return Difficult(
            "Mitja",
            75f,
            10,
            QuestionProvider.midlQuestions()
        )
    }

    fun hard(): Difficult{
        return Difficult(
            "Dificil",
            50f,
            15,
            QuestionProvider.hardQuestions()
        )
    }
}