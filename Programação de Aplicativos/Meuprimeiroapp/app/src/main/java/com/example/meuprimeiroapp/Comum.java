package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Comum<RM, RH> extends AppCompatActivity {

    EditText HI; //declara
    EditText MI;
    EditText HF;
    EditText MF;
    TextView ResultadoH; //declara
    TextView ResultadoM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comum);
        ResultadoH = findViewById(R.id.RH);
        ResultadoM = findViewById(R.id.RM);
        HI = findViewById(R.id.HI);
        MI = findViewById(R.id.MI);
        HF = findViewById(R.id.HF);
        MF = findViewById(R.id.MF);

    }

    public void Soma(View v) {
        int HoraI = Integer.parseInt(HI.getText().toString()); // transforma string em int
        int MinutoI = Integer.parseInt(MI.getText().toString());// transforma string em int
        int HoraF = Integer.parseInt(HF.getText().toString());// transforma string em int
        int MinutoF = Integer.parseInt(MF.getText().toString());// transforma string em int

        int RH = HoraI + HoraF; // somando
        int RM = MinutoI + MinutoF; // somando

        while (RM > 59) { //enquanto o resultado do minuto for maior que 60
            RM -= 60; //diminuir 60
            RH++; //+hora
        }
        ResultadoH.setText(RH+"");//aparecer resultado no campo
        ResultadoM.setText(RM+"");//aparecer resultado no campo
    }

    public void Subtração(View v) {
        int HoraI = Integer.parseInt(HI.getText().toString()); // transforma string em int
        int MinutoI = Integer.parseInt(MI.getText().toString());// transforma string em int
        int HoraF = Integer.parseInt(HF.getText().toString());// transforma string em int
        int MinutoF = Integer.parseInt(MF.getText().toString());// transforma string em int

        int RH = HoraI - HoraF; //subtraindo
        int RM = MinutoI - MinutoF;//subtraindo

        if (HoraI > HoraF) { //se a hora inicial foi maior que a final
            RH = HoraI - HoraF; //o resultado final vai ser a inicial menos a final
        } else { // se não
            RH = HoraF - HoraI; //o resultado será final menos inicial
        }

        if (MinutoI > MinutoF) { //se o minuto inicial for maior que o final
            RM = MinutoI - MinutoF; //o resultado do minuto será o inicial menos o final
        } else { //se não
            RM = MinutoF - MinutoI; //o resultado do minuto será o final menos o inicial
        }

        while (RM < 0) { //enquanto o resultado do minuto for menor que 0
            RM += 60; //aumentar 60
            RH--; //diminuir hora
        }
        while (RM > 59) { //enquanto o resultado do minuto for maior que 60
            RM -= 60; //diminuir 60
            RH++; //+hora
        }
        ResultadoH.setText(RH+"");//aparecer resultado no campo
        ResultadoM.setText(RM+"");//aparecer resultado no campo
    }
}

