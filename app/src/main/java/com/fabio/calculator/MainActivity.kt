package com.fabio.calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.annotation.SuppressLint

@SuppressLint("SetTextI18n") //Evitar traduções
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Funcionalidades:
         * Digitar números inteiros com os botões de 0 a 9
         * Escolher a Operação
         * Prioridade Aritmética da Primeira Operação Digitada
         * Resultado da Operação
         * Limpar
         * Tratativa de Divisão por 0 (busca de string de erro)
        */

        //Variáveis Pré-Auxiliares
        val white = getColor(R.color.white)
        val red = getColor(R.color.red)
        val txtErro = getString(R.string.msg_erro_divisao)
        val titulo = findViewById<TextView>(R.id.mainTitle)
        titulo.text = getString(R.string.app_name)

        //Variáveis Auxiliares
        var primeiroValor = 0.0
        var operador = ""
        var novoNumero = true
        var textoExibir: String
        val linha = findViewById<TextView>(R.id.linha)
        val anterior = findViewById<TextView>(R.id.anterior)

        //Botões de 0 a 9
        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)

        //Botões das 4 Operações Básicas
        val btnMais = findViewById<Button>(R.id.btnMais)
        val btnMenos = findViewById<Button>(R.id.btnMenos)
        val btnVezes = findViewById<Button>(R.id.btnVezes)
        val btnDivisao = findViewById<Button>(R.id.btnDividir)

        //Botão Igual
        val btnIgual  = findViewById<Button>(R.id.btnIgual)

        //Botão Limpar
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btn0.setOnClickListener {
            if (novoNumero) {
                linha.setTextColor(white)
                linha.text = "0"
                novoNumero = false
            } else {
                linha.append("0")
            }
        }
        btn1.setOnClickListener {
            if (novoNumero) {
                linha.setTextColor(white)
                linha.text = "1"
                novoNumero = false
            } else {
                linha.append("1")
            }
        }
        btn2.setOnClickListener {
            if (novoNumero) {
                linha.setTextColor(white)
                linha.text = "2"
                novoNumero = false
            } else {
                linha.append("2")
            }
        }
        btn3.setOnClickListener {
            if (novoNumero) {
                linha.setTextColor(white)
                linha.text = "3"
                novoNumero = false
            } else {
                linha.append("3")
            }
        }
        btn4.setOnClickListener {
            if (novoNumero) {
                linha.setTextColor(white)
                linha.text = "4"
                novoNumero = false
            } else {
                linha.append("4")
            }
        }
        btn5.setOnClickListener {
            if (novoNumero) {
                linha.setTextColor(white)
                linha.text = "5"
                novoNumero = false
            } else {
                linha.append("5")
            }
        }
        btn6.setOnClickListener {
            if (novoNumero) {
                linha.setTextColor(white)
                linha.text = "6"
                novoNumero = false
            } else {
                linha.append("6")
            }
        }
        btn7.setOnClickListener {
            if (novoNumero) {
                linha.setTextColor(white)
                linha.text = "7"
                novoNumero = false
            } else {
                linha.append("7")
            }
        }
        btn8.setOnClickListener {
            if (novoNumero) {
                linha.setTextColor(white)
                linha.text = "8"
                novoNumero = false
            } else {
                linha.append("8")
            }
        }
        btn9.setOnClickListener {
            if (novoNumero) {
                linha.setTextColor(white)
                linha.text = "9"
                novoNumero = false
            } else {
                linha.append("9")
            }
        }

        btnMais.setOnClickListener {
            if (linha.text == txtErro)
                return@setOnClickListener

            if (operador != "" && !novoNumero)
            {
                val segundoValor = linha.text.toString().toDouble()

                when (operador)
                {
                    "+" -> primeiroValor += segundoValor
                    "-" -> primeiroValor -= segundoValor
                    "*" -> primeiroValor *= segundoValor
                    "/" -> {
                        if (segundoValor != 0.0)
                            primeiroValor /= segundoValor
                        else
                        {
                            linha.text = txtErro
                            primeiroValor = 0.0
                        }
                    }
                }
                linha.text = primeiroValor.toString()
            }
            else
            {
                primeiroValor = linha.text.toString().toDouble()
            }
            operador = "+"
            textoExibir = "$primeiroValor + "
            anterior.text = textoExibir
            novoNumero = true
        }

        btnMenos.setOnClickListener {
            if (linha.text == txtErro)
                return@setOnClickListener

            if (operador != "" && !novoNumero)
            {
                val segundoValor = linha.text.toString().toDouble()

                when (operador)
                {
                    "+" -> primeiroValor += segundoValor
                    "-" -> primeiroValor -= segundoValor
                    "*" -> primeiroValor *= segundoValor
                    "/" -> {
                        if (segundoValor != 0.0)
                            primeiroValor /= segundoValor
                        else
                        {
                            linha.text = txtErro
                            primeiroValor = 0.0
                        }
                    }
                }
                linha.text = primeiroValor.toString()
            }
            else
            {
                primeiroValor = linha.text.toString().toDouble()
            }
            operador = "-"
            textoExibir = "$primeiroValor - "
            anterior.text = textoExibir
            novoNumero = true
        }

        btnVezes.setOnClickListener {
            if (linha.text == txtErro)
                return@setOnClickListener

            if (operador != "" && !novoNumero)
            {
                val segundoValor = linha.text.toString().toDouble()

                when (operador)
                {
                    "+" -> primeiroValor += segundoValor
                    "-" -> primeiroValor -= segundoValor
                    "*" -> primeiroValor *= segundoValor
                    "/" -> {
                        if (segundoValor != 0.0)
                            primeiroValor /= segundoValor
                        else
                        {
                            linha.text = txtErro
                            primeiroValor = 0.0
                        }
                    }
                }
                linha.text = primeiroValor.toString()
            }
            else
            {
                primeiroValor = linha.text.toString().toDouble()
            }
            operador = "*"
            textoExibir = "$primeiroValor * "
            anterior.text = textoExibir
            novoNumero = true
        }

        btnDivisao.setOnClickListener {
            if (linha.text == txtErro)
                return@setOnClickListener

            if (operador != "" && !novoNumero)
            {
                val segundoValor = linha.text.toString().toDouble()

                when (operador)
                {
                    "+" -> primeiroValor += segundoValor
                    "-" -> primeiroValor -= segundoValor
                    "*" -> primeiroValor *= segundoValor
                    "/" -> {
                        if (segundoValor != 0.0)
                            primeiroValor /= segundoValor
                        else
                        {
                            linha.text = txtErro
                            novoNumero = true
                            primeiroValor = 0.0
                            return@setOnClickListener
                        }
                    }
                }
                linha.text = primeiroValor.toString()
            }
            else
            {
                primeiroValor = linha.text.toString().toDouble()
            }
            operador = "/"
            textoExibir = "$primeiroValor / "
            anterior.text = textoExibir
            novoNumero = true
        }

        btnIgual.setOnClickListener {
            if (operador != "")
            {
                val segundoValor = linha.text.toString().toDouble()
                var resultado = 0.0
                if (operador == "+") {
                    resultado = primeiroValor + segundoValor
                } else if (operador == "-") {
                    resultado = primeiroValor - segundoValor
                } else if (operador == "*") {
                    resultado = primeiroValor * segundoValor
                } else if (operador == "/") {
                    if (segundoValor != 0.0) {
                        resultado = primeiroValor / segundoValor
                    } else {
                        linha.text = txtErro
                        linha.setTextColor(red)
                        primeiroValor = 0.0
                        operador = ""
                        novoNumero = true
                        return@setOnClickListener
                    }
                }

                linha.text = resultado.toString()
                anterior.text = ""
                operador = ""
                novoNumero = true
            }
        }

        btnLimpar.setOnClickListener {
            linha.setTextColor(white)
            linha.text = "0"
            anterior.text = ""
            primeiroValor = 0.0
            operador = ""
            novoNumero = true
        }
    }
}