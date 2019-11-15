package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada(0);
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada(1);
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada(2);
    }

    public void opcaoSelecionada(int escolhaUsuario){

        int escolhaApp = new Random().nextInt(3);
        ImageView imagemResultado = findViewById(R.id.imageResultado);

        TextView textoResultado = findViewById(R.id.textResultado);

        switch (escolhaApp){
            case 0:
                imagemResultado.setImageResource(R.drawable.pedra);
                break;

            case 1:
                imagemResultado.setImageResource(R.drawable.papel);
                break;

            case 2:
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;

        }

        //Usuario ganhador
        if(
            ( escolhaUsuario == 0 && escolhaApp == 2 ) ||
            ( escolhaUsuario == 1 && escolhaApp == 0 ) ||
            ( escolhaUsuario == 2 && escolhaApp == 1 )
        ){
            textoResultado.setText("Você ganhou!");
        } else if ( // App ganhador
                ( escolhaApp == 0 && escolhaUsuario == 2 ) ||
                ( escolhaApp == 1 && escolhaUsuario == 0 ) ||
                ( escolhaApp == 2 && escolhaUsuario == 1 )
        ){
            textoResultado.setText("Você perdeu!");
        } else {
            textoResultado.setText("Empate!");
        }

    }

}
