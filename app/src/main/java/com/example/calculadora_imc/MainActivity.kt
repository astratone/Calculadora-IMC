package com.example.calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        et_altura.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        et_peso.doOnTextChanged { text, _, _, _->
            //tv_titulo.text = text
        }
        bt_calculo.setOnClickListener {
            calcularIMC(et_peso.text.toString(), et_altura.text.toString())
        }

    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            tv_titulo.text = "Seu IMC é:\n%.2f".format(imc)
        }
    }
}