package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {
    static ArrayList<usuario> listinha; //permição pra receber a ista
    EditText buscaLogin; // inicializando
    TextView resultado; // inicializando variável
    usuario encontrado = new usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) { // primeiro método a ser executado quando uma activity é executado
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().hide(); //tira a barra de cima
        buscaLogin = findViewById(R.id.busca); //findViewbyid busca pelo id / o comando está ligando do buscaLogin(java) com o busca(xml)
        resultado = findViewById(R.id.resultado);
    }
    public void buscar(View view){
        String login = buscaLogin.getText().toString();
        String mensagem = "Login " +login+" não encontrado";
        for(usuario u : listinha){
            if(u.login.equals(login)){
                mensagem = "Login "+login+" encontrado";
                encontrado = u;
                break; // para
            }
        }
        resultado.setText(mensagem);
    }
}