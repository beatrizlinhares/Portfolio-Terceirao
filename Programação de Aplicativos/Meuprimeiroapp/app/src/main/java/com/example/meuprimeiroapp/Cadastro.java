package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Cadastro extends AppCompatActivity {
    EditText novoLogin, novaSenha, confirmacao;
    static ArrayList<usuario> listinha; //duas telas, mesma lista

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();
        novoLogin = findViewById(R.id.nLogin);
        novaSenha = findViewById(R.id.nSenha);
        confirmacao = findViewById(R.id.cSenha);

    }

    public void cadastra(View v){
        String login = novoLogin.getText().toString();
        String senha = novaSenha.getText().toString();
        String conf = confirmacao.getText().toString();
        if(senha.equals(conf)){
            usuario u = new usuario(login,senha, false);
            listinha.add(u);
            super.onBackPressed(); // voltar
        }
        else{
            Toast.makeText(this, "As senhas não conferem!", Toast.LENGTH_SHORT).show();
        }
        //Feito por Beatriz :)
    }

}