package com.example.app_camera;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity { //main é uma extenção de appcompact
    ImageView foto; // declarando

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); //tirar banner
        foto = findViewById(R.id.iv); // relacionando componente xml com atributo java
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {//se quando checar permissão for diferente de PERMISSÃO GARANTIDA, pedir permissão de camera ou do armazenamento externo
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, 0); //solicite permissão
        }
        // || = ou

    }

    public void tirarFoto(View v) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //ir pra tela da camera
        abrirCamera.launch(i);
        //startActivityForResult(i, 1); //quando tiver o resultado de tirar foto volte pra tela
    }

    public void pegarFoto(View v) {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//Action pick = escolher imagem e pegando imagem (intenção)
        abrirGaleria.launch(i);
    }

    ActivityResultLauncher<Intent> abrirCamera = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {//lançar resultado da intent (abrir camera) no result
        if (result.getResultCode() == Activity.RESULT_OK) { //se o result for ok
            Intent data = result.getData(); //pegar dado com a foto
            Bundle dado = data.getExtras(); //converter pra bitmap (tipo de imagem)
            Bitmap imagem = (Bitmap) dado.get("data"); //formato de imagem
            foto.setImageBitmap(imagem); //mudar imagem pra bitmap e colocar no imageView
        }
    });

    ActivityResultLauncher<Intent> abrirGaleria = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {//lançar resultado da intent (abrir camera) no result
        if (result.getResultCode() == Activity.RESULT_OK) { //se o result for ok
            Intent data = result.getData(); //pegar dado com a foto
            Uri imagemSelecionada = data.getData(); //fazendo um link pra imagem, o que é
            //uri é um endereço digital (www)
            String[] caminho = {MediaStore.Images.Media.DATA}; //caminho da imagem, onde está
            Cursor c = getContentResolver().query(imagemSelecionada, caminho, null, null, null); //ir até a imagem
            c.moveToFirst(); //mover pra primeira coluna do banco de dados
            int coluna = c.getColumnIndex(caminho[0]); //sabe o valor da coluna
            String caminhoFisico = c.getString(coluna); //transformando pra string
            c.close();
            Bitmap imagem = (BitmapFactory.decodeFile(caminhoFisico)); //transformar caminho e imagem real
            // passos : endereço da memória, apontar pro endereço e transformar em imagem real
            foto.setImageBitmap(imagem); //mudar imagem pra bitmap e colocar no imageView
        }
    });
}

