package io.github.canivetequixadaense

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btn_goto_contador: Button
    private lateinit var edit_editValorInicialContador: EditText
    private lateinit var btn_goto_calculadora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn_goto_contador = findViewById(R.id.btn_goto_contador);
        edit_editValorInicialContador = findViewById(R.id.tf_editValorInicialContador)
        btn_goto_calculadora = findViewById(R.id.btn_goto_calculadora)

        btn_goto_contador.setOnClickListener {
            goToContador()
        }
        btn_goto_calculadora.setOnClickListener {
            goToCalculadora()
        }
    }

    fun goToContador() {
        val intent = Intent(this, Contador::class.java)
        try {
            intent.putExtra("valorInicial", edit_editValorInicialContador.text.toString().toInt())
        }
        catch (exception: NumberFormatException) {
            intent.putExtra("valorInicial", 0)
        }
        startActivity(intent)
    }

    fun goToCalculadora() {
        val intent = Intent(this, Calculadora::class.java)
        startActivity(intent)
    }
}