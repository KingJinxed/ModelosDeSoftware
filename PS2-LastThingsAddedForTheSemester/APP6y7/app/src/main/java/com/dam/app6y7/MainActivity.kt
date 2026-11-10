package com.dam.app6y7


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var resultado: TextView

    private lateinit var suma: Button
    private lateinit var resta: Button
    private lateinit var producto: Button
    private lateinit var division: Button
    private lateinit var cuadrado: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enlazar vistas
        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        resultado = findViewById(R.id.resultado)

        suma = findViewById(R.id.suma)
        resta = findViewById(R.id.resta)
        producto = findViewById(R.id.producto)
        division = findViewById(R.id.division)
        cuadrado = findViewById(R.id.cuadrado)

        // Asignar listeners a cada botón
        suma.setOnClickListener { realizarOperacion("suma") }
        resta.setOnClickListener { realizarOperacion("resta") }
        producto.setOnClickListener { realizarOperacion("producto") }
        division.setOnClickListener { realizarOperacion("division") }
        cuadrado.setOnClickListener { realizarOperacion("cuadrado") }
    }

    private fun realizarOperacion(operacion: String) {
        val n1Text = num1.text.toString()
        val n2Text = num2.text.toString()

        if (n1Text.isEmpty() || n2Text.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        val n1 = n1Text.toDouble()
        val n2 = n2Text.toDouble()
        var res = 0.0

        when (operacion) {
            "suma" -> res = n1 + n2
            "resta" -> res = n1 - n2
            "producto" -> res = n1 * n2
            "division" -> {
                if (n2 == 0.0) {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                    return
                }
                res = n1 / n2
            }
            "cuadrado" -> res = n1.pow(n2)
        }

        resultado.text = "Resultado: $res"
    }
}