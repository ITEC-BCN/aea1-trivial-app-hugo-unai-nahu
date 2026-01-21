package com.example.trivialapp_base.model

import android.R

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
            Question("¿Capital de Francia?", "Geografía", listOf("Madrid", "París", "Berlín", "Roma"), "París"),
            Question("¿Cuántos días tiene una semana?", "General", listOf("5", "6", "7", "8"), "7"),
            Question("¿Color del cielo en un día despejado?", "Ciencia", listOf("Verde", "Azul", "Rojo", "Negro"), "Azul"),
            Question("¿Animal que ladra?", "General", listOf("Gato", "Perro", "Vaca", "Caballo"), "Perro"),
            Question("¿Resultado de 2 + 2?", "Matemáticas", listOf("3", "4", "5", "6"), "4"),
            Question("¿Planeta en el que vivimos?", "Ciencia", listOf("Marte", "Venus", "Tierra", "Júpiter"), "Tierra"),
            Question("¿Capital de España?", "Geografía", listOf("Barcelona", "Madrid", "Sevilla", "Valencia"), "Madrid"),
            Question("¿Color de una fresa?", "General", listOf("Azul", "Rojo", "Amarillo", "Verde"), "Rojo"),
            Question("¿Cuántas patas tiene un perro?", "General", listOf("2", "3", "4", "6"), "4"),
            Question("¿Mes después de enero?", "General", listOf("Marzo", "Febrero", "Abril", "Mayo"), "Febrero"),
            Question("¿Instrumento para escribir?", "General", listOf("Cuchillo", "Lápiz", "Plato", "Zapato"), "Lápiz"),
            Question("¿Capital de Italia?", "Geografía", listOf("Milán", "Venecia", "Roma", "Nápoles"), "Roma"),
            Question("¿Animal que maúlla?", "General", listOf("Perro", "Gato", "Pájaro", "Vaca"), "Gato"),
            Question("¿Día después del lunes?", "General", listOf("Domingo", "Martes", "Viernes", "Jueves"), "Martes"),
            Question("¿Resultado de 5 - 3?", "Matemáticas", listOf("1", "2", "3", "4"), "2"),
            Question("¿Color del sol?", "Ciencia", listOf("Azul", "Blanco", "Amarillo", "Verde"), "Amarillo"),
            Question("¿Cuántos meses tiene un año?", "General", listOf("10", "11", "12", "13"), "12"),
            Question("¿Animal que vuela?", "General", listOf("Perro", "Pez", "Pájaro", "Vaca"), "Pájaro"),
            Question("¿Capital de Portugal?", "Geografía", listOf("Oporto", "Lisboa", "Madrid", "Faro"), "Lisboa"),
            Question("¿Forma de una pelota?", "General", listOf("Cuadrada", "Triangular", "Redonda", "Rectangular"), "Redonda")
            )
    }

    fun midlQuestions(): MutableList<Question> {
        return mutableListOf(
            Question("¿Capital de Alemania?", "Geografía", listOf("Viena", "Berlín", "Hamburgo", "Múnich"), "Berlín"),
            Question("¿Resultado de 12 x 4?", "Matemáticas", listOf("36", "44", "48", "52"), "48"),
            Question("¿Océano más grande?", "Geografía", listOf("Atlántico", "Índico", "Pacífico", "Ártico"), "Pacífico"),
            Question("¿Autor de Don Quijote?", "Literatura", listOf("Lope de Vega", "Cervantes", "García Lorca", "Quevedo"), "Cervantes"),
            Question("¿Hueso más largo del cuerpo humano?", "Ciencia", listOf("Tibia", "Fémur", "Húmero", "Radio"), "Fémur"),
            Question("¿País donde se encuentra Machu Picchu?", "Geografía", listOf("Chile", "Bolivia", "Perú", "Ecuador"), "Perú"),
            Question("¿Número de continentes?", "Geografía", listOf("5", "6", "7", "8"), "7"),
            Question("¿Idioma más hablado del mundo?", "General", listOf("Inglés", "Español", "Chino mandarín", "Francés"), "Chino mandarín"),
            Question("¿Resultado de 100 / 4?", "Matemáticas", listOf("20", "25", "30", "40"), "25"),
            Question("¿Capital de Argentina?", "Geografía", listOf("Rosario", "Córdoba", "Buenos Aires", "La Plata"), "Buenos Aires"),
            Question("¿Gas que respiramos principalmente?", "Ciencia", listOf("Oxígeno", "Nitrógeno", "Dióxido de carbono", "Hidrógeno"), "Nitrógeno"),
            Question("¿Planeta más grande del sistema solar?", "Ciencia", listOf("Saturno", "Júpiter", "Neptuno", "Marte"), "Júpiter"),
            Question("¿Animal más rápido en tierra?", "Ciencia", listOf("León", "Caballo", "Guepardo", "Tigre"), "Guepardo"),
            Question("¿Capital de Canadá?", "Geografía", listOf("Toronto", "Vancouver", "Ottawa", "Montreal"), "Ottawa"),
            Question("¿Resultado de 15 + 27?", "Matemáticas", listOf("40", "41", "42", "43"), "42"),
            Question("¿Inventor de la bombilla?", "Historia", listOf("Tesla", "Edison", "Newton", "Einstein"), "Edison"),
            Question("¿Río más largo del mundo?", "Geografía", listOf("Nilo", "Amazonas", "Yangtsé", "Misisipi"), "Amazonas"),
            Question("¿Capital de Japón?", "Geografía", listOf("Osaka", "Kioto", "Tokio", "Hiroshima"), "Tokio"),
            Question("¿Número de lados de un hexágono?", "Matemáticas", listOf("5", "6", "7", "8"), "6"),
            Question("¿Metal líquido a temperatura ambiente?", "Ciencia", listOf("Plomo", "Mercurio", "Aluminio", "Cobre"), "Mercurio")
            )
    }

    fun hardQuestions(): MutableList<Question> {
        return mutableListOf(
            Question("¿Año de inicio de la Segunda Guerra Mundial?", "Historia", listOf("1937", "1938", "1939", "1941"), "1939"),
            Question("¿Capital de Australia?", "Geografía", listOf("Sídney", "Melbourne", "Canberra", "Perth"), "Canberra"),
            Question("¿Elemento químico con símbolo Au?", "Ciencia", listOf("Plata", "Cobre", "Oro", "Hierro"), "Oro"),
            Question("¿Autor de La Odisea?", "Literatura", listOf("Sófocles", "Homero", "Platón", "Aristóteles"), "Homero"),
            Question("¿Número atómico del carbono?", "Ciencia", listOf("4", "6", "8", "12"), "6"),
            Question("¿País con más población del mundo (2024)?", "Geografía", listOf("China", "India", "Estados Unidos", "Rusia"), "India"),
            Question("¿Fórmula química del agua?", "Ciencia", listOf("CO2", "H2O", "O2", "NaCl"), "H2O"),
            Question("¿Capital de Turquía?", "Geografía", listOf("Estambul", "Ankara", "Izmir", "Bursa"), "Ankara"),
            Question("¿Cuántos huesos tiene el cuerpo humano adulto?", "Ciencia", listOf("196", "206", "216", "226"), "206"),
            Question("¿Pintor de Guernica?", "Arte", listOf("Dalí", "Picasso", "Goya", "Velázquez"), "Picasso"),
            Question("¿Lenguaje usado para Android nativo?", "Tecnología", listOf("Swift", "Kotlin", "JavaScript", "Ruby"), "Kotlin"),
            Question("¿Capital de Noruega?", "Geografía", listOf("Oslo", "Estocolmo", "Helsinki", "Copenhague"), "Oslo"),
            Question("¿Constante matemática aproximada 3.1416?", "Matemáticas", listOf("e", "φ", "π", "√2"), "π"),
            Question("¿Científico que formuló la relatividad?", "Ciencia", listOf("Newton", "Einstein", "Galileo", "Bohr"), "Einstein"),
            Question("¿Capital de Marruecos?", "Geografía", listOf("Casablanca", "Rabat", "Marrakech", "Tánger"), "Rabat"),
            Question("¿Órgano que produce insulina?", "Ciencia", listOf("Hígado", "Páncreas", "Riñón", "Bazo"), "Páncreas"),
            Question("¿Año de la caída del Muro de Berlín?", "Historia", listOf("1987", "1989", "1991", "1993"), "1989"),
            Question("¿Lengua oficial de Brasil?", "Geografía", listOf("Español", "Portugués", "Inglés", "Francés"), "Portugués"),
            Question("¿Unidad básica de información?", "Tecnología", listOf("Byte", "Bit", "KB", "MB"), "Bit"),
            Question("¿Capital de Corea del Sur?", "Geografía", listOf("Busan", "Incheon", "Seúl", "Daegu"), "Seúl")
            )
    }
}