package com.example.trivialapp_base.model

// Definición de la clase de datos Pregunta según requisitos
data class Question(
    val question: String,
    val category: String,
    val answers: List<String>,
    val correctAnswer: String // Debe coincidir con una de las anteriores
)

// Objeto para simular la base de datos local (Hardcoded)
object QuestionProvider {
    fun easyQuestions(): MutableList<Question> {
        return mutableListOf(
            Question("¿Capital de Francia?", "Geografía", listOf("Madrid", "París", "Berlin", "Roma"), "París"),
            Question("¿Fórmula del agua?", "Ciencia", listOf("H2O", "CO2", "O2", "H2O2"), "H2O"),
            Question("¿Quién pintó la Mona Lisa?", "Arte",  listOf("Picasso", "Van Gogh", "Da Vinci", "Dalí"), "Da Vinci"),
            Question("¿Planeta más grande?", "Ciencia", listOf("Tierra", "Marte", "Júpiter", "Saturno"), "Júpiter"),
            Question("¿Año descubrimiento América?", "Historia", listOf("1492", "1500", "1485", "1992"), "1492"),
            Question("¿Elemento químico Au?", "Química", listOf("Plata", "Oro", "Cobre", "Aluminio"), "Oro"),
            Question("¿Autor del Quijote?", "Literatura", listOf("Cervantes", "Quevedo", "Lope", "Góngora"), "Cervantes"),
            Question("¿Velocidad de la luz?", "Física", listOf("300.000 km/s", "150.000 km/s", "1000 km/s", "Mach 1"), "300.000 km/s"),
            Question("¿Moneda de Japón?", "Economía", listOf("Yuan", "Won", "Yen", "Dólar"), "Yen"),
            Question("¿Campeón mundial fútbol 2010?", "Deportes", listOf("Brasil", "Alemania", "España", "Italia"), "España"),
            Question("¿Rey de los dioses griegos?", "Mitología", listOf("Zeus", "Hades", "Poseidón", "Ares"), "Zeus"),
            Question("¿Hueso más largo del cuerpo?", "Anatomía", listOf("Fémur", "Tibia", "Húmero", "Radio"), "Fémur")
        )
    }

    fun midlQuestions(): MutableList<Question> {
        return mutableListOf()
    }

    fun hardQuestions(): MutableList<Question> {
        return mutableListOf()
    }
}