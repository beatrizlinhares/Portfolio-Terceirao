package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText campo, login, senha;
    ArrayList<usuario> listinha = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){ //Primeiro método a ser executado
        super.onCreate(savedInstanceState); //tornar visível a tela
        setContentView(R.layout.activity_main); //tornar visível a tela
        getSupportActionBar().hide(); // obter o banner com o título do app e esconder
        campo = findViewById(R.id.nome); // vincular variavel do java com xml
        login = findViewById(R.id.login);
        senha = findViewById(R.id.senha);
        criaUsuarios();
    }

    public void clicar(View v){ // p parâmetro view torna o método visível ao arquivo xml
        String mensagem = "Olá, "+campo.getText()+", bora programar Android?";
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();

    }

    public void logar(View v){
        String user = login.getText().toString();
        String pass = senha.getText().toString();
        String mensagem = "Bem vindo!";
        for(usuario u:listinha){ //analisar cada usuario da lista
            if(user.equals(u.getLogin()) && pass.equals(u.getSenha())){ //se tiver login e senha
                if(u.isAdmin()){ //se for admin
                    Intent i = new Intent(this, Admin.class);
                    startActivity(i); //abrir tela admin
                    Admin.listinha = listinha; //Admin a sua listinha esta recebendo a minha listinha
                }
                else{ //se não for admin
                    Intent i = new Intent(this, Comum.class);
                    startActivity(i); //abrir tela comum
                }
                mensagem = "Bem vindo!";
                break;
            }
            else{ //se não tiver login e senha
                mensagem = "Login ou Senha incorreta!"; //mensagem
            }
        }
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    private void criaUsuarios() {
        usuario u1 = new usuario("admin", "admin", true );
        usuario u2 = new usuario("jack", "java", true );
        usuario u3 = new usuario("pikachu", "123", false );
        usuario u4 = new usuario("batata", "abc", true );
        usuario u5 = new usuario("batatinha", "quandonasce", true );
        listinha.add(u1);
        listinha.add(u2);
        listinha.add(u3);
        listinha.add(u4);
        listinha.add(u5);
    }

    public void cadastro(View v){
        Intent i = new Intent( this, Cadastro.class);
        startActivity(i);
        Cadastro.listinha = listinha; //1 (=) recebe / cadastro a sua listinha esta recebendo a minha listinha
    }

}