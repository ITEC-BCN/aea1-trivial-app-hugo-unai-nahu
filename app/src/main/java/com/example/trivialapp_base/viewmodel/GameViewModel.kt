package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Question

class GameViewModel : ViewModel() {
    private var preguntasPartida: List<Question> = emptyList()
    var indicePreguntaActual by mutableIntStateOf(0)
        private set

    var preguntaActual by mutableStateOf<Question?>(null)
        private set

    var respuestasMezcladas by mutableStateOf<List<String>>(emptyList())
        private set

    var puntuacion by mutableIntStateOf(0)
        private set

    var tiempoRestante by mutableFloatStateOf(100f)
        private set

    var juegoTerminado by mutableStateOf(false)
        private set
    var dificultadSeleccionada by mutableStateOf("Facil")
        private set

    private var timer: CountDownTimer? = null
    private val TIEMPO_POR_PREGUNTA = 10000L // 10 segons

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad // Sense .value!
    }
    fun iniciarJuego() {
    }

    private fun cargarSiguientePregunta() {
    }

    fun responderPregunta(respuestaUsuario: String) {
    }

    private fun avanzarRonda() {
    }

    private fun iniciarTimer() {
    }

    override fun onCleared() {
    }
}
