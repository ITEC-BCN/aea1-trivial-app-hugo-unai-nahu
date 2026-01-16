package com.example.trivialapp_base.model

// Definición de la clase de datos Pregunta según requisitos
data class Answer(
    val question: String,
    val category: String,
    val answers: List<String>,
    val correctAnswer: String // Debe coincidir con una de las anteriores
)

// Objeto para simular la base de datos local (Hardcoded)
object QuestionProvider {
    fun easyQuestions(): MutableList<Answer> {
        return mutableListOf(
            Answer("¿Capital de Francia?", "Geografía", listOf("Madrid", "París", "Berlin", "Roma"), "París"),
            Answer("¿Fórmula del agua?", "Ciencia", listOf("H2O", "CO2", "O2", "H2O2"), "H2O"),
            Answer("¿Quién pintó la Mona Lisa?", "Arte",  listOf("Picasso", "Van Gogh", "Da Vinci", "Dalí"), "Da Vinci"),
            Answer("¿Planeta más grande?", "Ciencia", listOf("Tierra", "Marte", "Júpiter", "Saturno"), "Júpiter"),
            Answer("¿Año descubrimiento América?", "Historia", listOf("1492", "1500", "1485", "1992"), "1492"),
            Answer("¿Elemento químico Au?", "Química", listOf("Plata", "Oro", "Cobre", "Aluminio"), "Oro"),
            Answer("¿Autor del Quijote?", "Literatura", listOf("Cervantes", "Quevedo", "Lope", "Góngora"), "Cervantes"),
            Answer("¿Velocidad de la luz?", "Física", listOf("300.000 km/s", "150.000 km/s", "1000 km/s", "Mach 1"), "300.000 km/s"),
            Answer("¿Moneda de Japón?", "Economía", listOf("Yuan", "Won", "Yen", "Dólar"), "Yen"),
            Answer("¿Campeón mundial fútbol 2010?", "Deportes", listOf("Brasil", "Alemania", "España", "Italia"), "España"),
            Answer("¿Rey de los dioses griegos?", "Mitología", listOf("Zeus", "Hades", "Poseidón", "Ares"), "Zeus"),
            Answer("¿Hueso más largo del cuerpo?", "Anatomía", listOf("Fémur", "Tibia", "Húmero", "Radio"), "Fémur")
        )
    }

    fun midlQuestions(): MutableList<Answer> {
        return mutableListOf()
    }

    fun hardQuestions(): MutableList<Answer> {
        return mutableListOf()
    }
}