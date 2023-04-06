package com.example.jogorandon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText entrada; //inicializando
    TextView resultado; //inicializando
    int numeroGerado = 0; //inicializando
    int tentativas = 0; //inicializando
    Random gerador = new Random(); //gerar numero aleatorio

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = findViewById(R.id.entrada); //vinculando xml com Java
        resultado = findViewById(R.id.resultado); //vinculando xml com Java
    }

    public void gerarNumero(View v) {
        tentativas = 0; //inicializando
        numeroGerado = gerador.nextInt(100) + 1; //gerar numero de (0 á 99) + 1
    }

    public void confirmar(View v) {
        String mensagem = ""; //inicializando
        if (entrada.getText().toString().isEmpty()) { //isEmpty = vazio (se não for digitado)
            mensagem = "Digite um número";
        } else {
            tentativas++;

            int numero = Integer.parseInt(entrada.getText().toString()); //transformando string em int

            if (tentativas < 5) {
                if (numero > numeroGerado) { //se o numero for maior que o gerado
                    mensagem = "O número é menor!\nVocê tem mais " + (5 - tentativas) + " tentativas";
                } else if (numero < numeroGerado) { //se for menor que o gerado
                    mensagem = "O número é maior!\nVocê tem mais" + (5 - tentativas) + " tentativas";
                } else {
                    mensagem = "Parabéns! Você acertou!";
                }
            } else {
                mensagem = "Suas tentativas acabaram!";
            }
        }
        resultado.setText(mensagem); //mudar resultado para mensagem
    }
}