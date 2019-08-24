package br.uninove.aula.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    //Declaração de variaveis
    int peso;
    float altura;
    float imc;
    boolean masc;

    EditText edtAltura,edtPeso;
    Button btnCalcular;
    RadioButton optMasc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reconhecimento de variaveis
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        optMasc = (RadioButton) findViewById(R.id.radioMasc);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                peso = Integer.parseInt(edtPeso.getText().toString());
                altura = Float.parseFloat(edtAltura.getText().toString());
                imc = peso / (altura * altura);

                //Cria o transporte
                Intent tela2 = new Intent(MainActivity.this, SaidaActivity.class);

                Bundle dados = new Bundle();

                if (optMasc.isChecked()) {

                    if (imc <= 29.1){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Baixo peso !!!");
                    } else if ((imc > 29.1) && (imc<= 27)){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Peso normal !!!");
                    } else if ((imc > 27) && (imc<= 30)){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Sobrepeso !!!");
                    } else if ((imc > 30) && (imc<= 35)){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Obesidade grau I !!!");
                    } else if ((imc > 35) && (imc<= 39.9)){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Obesidade grau II !!!");
                    } else if (imc > 39.9){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Obesidade grau III !!!");
                    }

                } else {

                    if (imc <= 29.1){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Baixo peso !!!");
                    } else if ((imc > 29.1) && (imc<= 27)){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Peso normal !!!");
                    } else if ((imc > 27) && (imc<= 32)){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Sobrepeso !!!");
                    } else if ((imc > 32) && (imc<= 37)){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Obesidade grau I !!!");
                    } else if ((imc > 37) && (imc<= 41.9)){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Obesidade grau II !!!");
                    } else if (imc > 42){
                        dados.putString("pImc", String.valueOf(imc));
                        dados.putString("pMsg","Obesidade grau III !!!");
                    }

                };

                tela2.putExtras(dados);
                startActivity(tela2);
            }
        });

    }
}
