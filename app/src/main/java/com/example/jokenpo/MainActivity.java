package com.example.jokenpo;

import static android.view.View.*;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView placaMaquina;
    private TextView placaVoce;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placaMaquina = findViewById(R.id.placarMaquina);
        placaVoce = findViewById(R.id.placarVoce);






    }

    int placarV = 0;
    int placarM = 0;
    public void zerarPlacar(View view){

        placarM = 0;
        placarV = 0 ;
        placaVoce.setText("");
        placaMaquina.setText("");

    }

    public void selecionadoPedra(View view){this.opcaoSelecionada("Pedra");}
    public void selecionadoPapel(View view) {this.opcaoSelecionada("Papel");}
    public void selecionadoTesoura(View view){this.opcaoSelecionada("Tesoura");}
    public void selecionadoLagarto(View view) { this.opcaoSelecionada("Lagarto");}
    public void selecionadoSpok(View view){ this.opcaoSelecionada("Spok");}





    public  void opcaoSelecionada(String escolhaUsuario) {
        ImageView imageResultado = findViewById(R.id.imageResultado);

        TextView textResultado = findViewById(R.id.textResultado);


        int numero = new Random().nextInt(5);
        String[] opcoes = {"Pedra", "Papel", "Tesoura", "Lagarto", "Spok"};
        String opcaoAPP = opcoes[numero];

        switch (opcaoAPP) {
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
            case "Lagarto":
                imageResultado.setImageResource(R.drawable.lagarto);
                break;
            case "Spok":
                imageResultado.setImageResource(R.drawable.spok);
                break;
        }
        if (
                (opcaoAPP == "Tesoura" && escolhaUsuario == "Papel") ||
                        (opcaoAPP == "Papel" && escolhaUsuario == "Pedra") ||
                        (opcaoAPP == "Pedra" && escolhaUsuario == "Lagarto") ||
                        (opcaoAPP == "Lagarto" && escolhaUsuario == "Spok") ||
                        (opcaoAPP == "Spok" && escolhaUsuario == "Tesoura") ||
                        (opcaoAPP == "Tesoura" && escolhaUsuario == "Lagarto") ||
                        (opcaoAPP == "Lagarto" && escolhaUsuario == "Papel") ||
                        (opcaoAPP == "Papel" && escolhaUsuario == "Spok") ||
                        (opcaoAPP == "Spok" && escolhaUsuario == "Pedra") ||
                        (opcaoAPP == "Pedra" && escolhaUsuario == "Tesoura")
        ) {
            textResultado.setText("Você Perdeu");
            placarM = placarM + 1;
            placaMaquina.setVisibility(VISIBLE);
            placaMaquina.setText("" + placarM);
        } else if (
                (escolhaUsuario == "Tesoura" && opcaoAPP == "Papel") ||
                        (escolhaUsuario == "Papel" && opcaoAPP == "Pedra") ||
                        (escolhaUsuario == "Pedra" && opcaoAPP == "Lagarto") ||
                        (escolhaUsuario == "Lagarto" && opcaoAPP == "Spok") ||
                        (escolhaUsuario == "Spok" && opcaoAPP == "Tesoura") ||
                        (escolhaUsuario == "Tesoura" && opcaoAPP == "Lagarto") ||
                        (escolhaUsuario == "Lagarto" && opcaoAPP == "Papel") ||
                        (escolhaUsuario == "Papel" && opcaoAPP == "Spok") ||
                        (escolhaUsuario == "Spok" && opcaoAPP == "Pedra") ||
                        (escolhaUsuario == "Pedra" && opcaoAPP == "Tesoura")
        ){
            textResultado.setText("Você Ganhou");
            placarV = placarV + 1;
            placaVoce.setVisibility(VISIBLE);
            placaVoce.setText("" + placarV);


        } else {
            textResultado.setText("Empate");
        }


    }
    }
