package io.github.canivetequixadaense

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculadora : AppCompatActivity() {
    lateinit var btn_somar: Button
    lateinit var btn_subtrair: Button
    lateinit var btn_multiplicar: Button
    lateinit var btn_dividir: Button

    lateinit var edit_numero1: EditText
    lateinit var edit_numero2: EditText
    lateinit var tv_resultado: TextView

    private fun performOperation(operation: (Double,Double) -> Double){
        if(validateInput()) {
            val numero1 = edit_numero1.text.toString().toDouble()
            val numero2 = edit_numero2.text.toString().toDouble()
            val resultado = operation(numero1, numero2)

            tv_resultado.text = resultado.toString()
        }
        else {
            Toast.makeText(this, "Preencha os dois números", Toast.LENGTH_SHORT).show()
        }
    }
    private fun validateInput(): Boolean {
        return !(edit_numero1.text.isEmpty() || edit_numero2.text.isEmpty())
    }
    private fun checkZeroDivision(): Boolean {
        return edit_numero2.text.isEmpty() || edit_numero2.text.toString().toDouble() == 0.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn_somar = findViewById(R.id.btn_somar)
        btn_subtrair = findViewById(R.id.btn_subtrair)
        btn_multiplicar = findViewById(R.id.btn_multiplicar)
        btn_dividir = findViewById(R.id.btn_dividir)

        edit_numero1 = findViewById(R.id.edit_numero1)
        edit_numero2 = findViewById(R.id.edit_numero2)
        tv_resultado = findViewById(R.id.tv_resultado)

        btn_somar.setOnClickListener {
            performOperation { a, b -> a + b }
        }
        btn_subtrair.setOnClickListener {
            performOperation { a, b -> a - b }
        }

        btn_multiplicar.setOnClickListener {
            performOperation { a, b -> a * b }
        }

        btn_dividir.setOnClickListener {
            if (checkZeroDivision()){
                Toast.makeText(this, "Divisão por zero não é permitida", Toast.LENGTH_SHORT).show()
            }
            else {
                performOperation { a, b -> a / b }
            }
        }
    }
}