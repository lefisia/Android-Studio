package com.example.aula_semana_4_mobile_interfaces

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    // Criação das variáveis que estarão presentes na interface
    // Semana 2 - Criação de variáveis não nulas no Kotlin:
    // Uso se variáveis privadas para n comprometer a intregidade dos dados
    private var pontosDisponiveis = 20
    private var valorForca = 50
    private var valorDestreza = 25
    private var valorInteligencia = 30

    // Semana 4- Uso do metodo onCreate():
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        // Definir todos os dados gráficos presentes no layout
        // Semana 4 - Uso do findView ByID:
        val txtPontosLabel = findViewById<TextView>(R.id.textView2)
        val txtForcaValor = findViewById<TextView>(R.id.numberForca)
        val txtDestrezaValor = findViewById<TextView>(R.id.numberDestreza)
        val txtInteligenciaValor = findViewById<TextView>(R.id.numberInteligencia)

        // Declarar os botões aumentar e diminuir de cada atributo
        // Semana 4 - Botões no AndroidStudio:
        // Botões de Força:
        val btnAumentarForca = findViewById<Button>(R.id.btnAumentarForca)
        val btnDiminuirForca = findViewById<Button>(R.id.btnDiminuirForca)

        // Botões de Destreza:
        val btnAumentarDestreza = findViewById<Button>(R.id.btnAumentarDestreza)
        val btnDiminuirDestreza = findViewById<Button>(R.id.btnDiminuirDestreza)

        // Botões de Inteligência:
        val btnAumentarInteligencia = findViewById<Button>(R.id.btnAumentarInteligencia)
        val btnDiminuirInteligencia = findViewById<Button>(R.id.btnDiminuirInteligencia)

        // Botão para confirmar
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)
        // Semana 4 - Log.i:
        // Toda vez que o usuário clicar, printar no Logcat:
        val mensagemLogCat = "CLick no Botão Confirmar"
        Log.i("Teste", mensagemLogCat)

        //Atributo 1: Força
        //Criar uma condição cuja a "listiner" consiga identificar o comando do botão aumentar e
        //alterar o number dos pts disponíveis na tela:

        btnAumentarForca.setOnClickListener {
            if (pontosDisponiveis > 0) {
                pontosDisponiveis--
                valorForca++
                //Como fazer com que o texto seja atualizado a medida que o botão é acionado
                txtForcaValor.setText(valorForca.toString())
                txtPontosLabel.setText(pontosDisponiveis.toString())
            } else {
                Toast.makeText(this, "Acabaram os pontos! :(", Toast.LENGTH_SHORT).show()
            }
        }

        btnDiminuirForca.setOnClickListener {
            if (valorForca > 1) {
                valorForca--
                pontosDisponiveis++
                // Atualiza a tela
                txtForcaValor.setText(valorForca.toString())
                txtPontosLabel.setText(pontosDisponiveis.toString())
            }
        }
        // Atributo 2: Destreza
        btnAumentarDestreza.setOnClickListener {
            if (pontosDisponiveis > 0) {
                pontosDisponiveis--
                valorDestreza++
                txtDestrezaValor.setText(valorDestreza.toString())
                txtPontosLabel.setText(pontosDisponiveis.toString())
            } else {
                Toast.makeText(this, "Acabaram os pontos! :(", Toast.LENGTH_SHORT).show()
            }
        }

        btnDiminuirDestreza.setOnClickListener {
            if (valorDestreza > 1) {
                valorDestreza--
                pontosDisponiveis++
                txtDestrezaValor.setText(valorDestreza.toString())
                txtPontosLabel.setText(pontosDisponiveis.toString())
            }
        }

        // Atributo 3: Inteligencia
        btnAumentarInteligencia.setOnClickListener {
            if (pontosDisponiveis > 0) {
                pontosDisponiveis--
                valorInteligencia++
                txtInteligenciaValor.setText(valorInteligencia.toString())
                txtPontosLabel.setText(pontosDisponiveis.toString())
            } else {
                Toast.makeText(this, "Acabaram os pontos! :(", Toast.LENGTH_SHORT).show()
            }
        }

        btnDiminuirInteligencia.setOnClickListener {
            if (valorInteligencia > 1) {
                valorInteligencia--
                pontosDisponiveis++
                txtInteligenciaValor.setText(valorInteligencia.toString())
                txtPontosLabel.setText(pontosDisponiveis.toString())
            }
        }

        //Botão para "salvar" e exibir a pontuação do personagem alterado:

        btnConfirmar.setOnClickListener {
            //Semana 4 - Uso do Toast para feedback ao usuário:
            val feedback = "For: $valorForca, Des: $valorDestreza, Int: $valorInteligencia"
            Toast.makeText(this, feedback, Toast.LENGTH_LONG).show()
        }
    }
}