package br.com.dlweb.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import expr.Expr;
import expr.Parser;
import expr.SyntaxException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvOperacao = findViewById(R.id.textViewOperacao);
        TextView tvResultado = findViewById(R.id.textViewResultado);
        Button btnZero = findViewById(R.id.button0);
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("0"));
            }
        });

        Button btnUm = findViewById(R.id.button1);
        btnUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("1"));
            }
        });

        Button btnDois = findViewById(R.id.button2);
        btnDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("2"));
            }
        });

        Button btnTres = findViewById(R.id.button3);
        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("3"));
            }
        });

        Button btnQuatro = findViewById(R.id.button4);
        btnQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("4"));
            }
        });

        Button btnCinco = findViewById(R.id.button5);
        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("5"));
            }
        });

        Button btnSeis = findViewById(R.id.button6);
        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("6"));
            }
        });

        Button btnSete = findViewById(R.id.button7);
        btnSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("7"));
            }
        });

        Button btnOito = findViewById(R.id.button8);
        btnOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("8"));
            }
        });

        Button btnNove = findViewById(R.id.button9);
        btnNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("9"));
            }
        });

        Button btnAdicao = findViewById(R.id.buttonAdicao);
        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(" + "));
            }
        });

        Button btnSubtracao = findViewById(R.id.buttonSubtracao);
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(" - "));
            }
        });

        Button btnMultiplicacao = findViewById(R.id.buttonMultiplicacao);
        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(" * "));
            }
        });

        Button btnDivisao = findViewById(R.id.buttonDivisao);
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(" / "));
            }
        });

        Button btnAbrirParenteses = findViewById(R.id.buttonAbrirParenteses);
        btnAbrirParenteses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("("));
            }
        });

        Button btnFecharParenteses = findViewById(R.id.buttonFecharParenteses);
        btnFecharParenteses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(")"));
            }
        });

        Button btnElevado = findViewById(R.id.buttonElevado);
        btnElevado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(" ^ "));
            }
        });

        Button btnVirgula = findViewById(R.id.buttonVirgula);
        btnVirgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(","));
            }
        });

        Button btnLimpar = findViewById(R.id.buttonLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText("");
                tvOperacao.setText("");
            }
        });

        Button btnIgual = findViewById(R.id.buttonIgual);
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText("");
                try {
                    String operacao = tvOperacao.getText().toString();
                    operacao = operacao.replace(",", ".");
                    Expr expr = Parser.parse(operacao);
                    double resultado = expr.value();
                    tvResultado.setText(tvOperacao.getText().toString()
                            .concat(" = ").concat(String.valueOf(resultado)
                                    .replace(".", ",")));
                    tvOperacao.setText("");
                } catch (SyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}