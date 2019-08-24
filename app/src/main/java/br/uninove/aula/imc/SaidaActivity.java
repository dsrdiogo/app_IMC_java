package br.uninove.aula.imc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SaidaActivity extends Activity{

    TextView imc, msg;

    protected void onCreate(Bundle SaveInstanceState) {

        super.onCreate(SaveInstanceState);
        setContentView(R.layout.saida_main);

        imc= findViewById(R.id.txtImc);
        msg= findViewById(R.id.txtMsg);

        //Cria o transporte
        Intent tela1 = getIntent();

        Bundle dados = tela1.getExtras();

        imc.setText("IMC: " + dados.getString("pImc").toString());
        msg.setText(dados.getString("pMsg").toString());

    }

};
