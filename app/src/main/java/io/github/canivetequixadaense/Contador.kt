package io.github.canivetequixadaense

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Contador : AppCompatActivity() {
    lateinit var btn_contador: Button
    lateinit var tv_contagem : TextView
    var contagem : Int =  0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contador)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn_contador = findViewById(R.id.btn_contador)
        tv_contagem = findViewById(R.id.tv_contagem)
        contagem = intent.getIntExtra("valorInicial", 0)
        tv_contagem.text = (contagem).toString()

        btn_contador.setOnClickListener {
            contagem++
            tv_contagem.text = (contagem).toString()
        }
    }
}