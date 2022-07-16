package br.com.dlweb.calculadora;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.com.dlweb.calculadora.database.DatabaseHelper;
import expr.Expr;
import expr.Parser;
import expr.SyntaxException;

public class CalculadoraFragment extends Fragment {

    public CalculadoraFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calculadora, container, false);

        TextView tvOperacao = v.findViewById(R.id.textViewOperacao);
        TextView tvResultado = v.findViewById(R.id.textViewResultado);
        Button btnZero = v.findViewById(R.id.button0);
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("0"));
            }
        });

        Button btnUm = v.findViewById(R.id.button1);
        btnUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("1"));
            }
        });

        Button btnDois = v.findViewById(R.id.button2);
        btnDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("2"));
            }
        });

        Button btnTres = v.findViewById(R.id.button3);
        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("3"));
            }
        });

        Button btnQuatro = v.findViewById(R.id.button4);
        btnQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("4"));
            }
        });

        Button btnCinco = v.findViewById(R.id.button5);
        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("5"));
            }
        });

        Button btnSeis = v.findViewById(R.id.button6);
        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("6"));
            }
        });

        Button btnSete = v.findViewById(R.id.button7);
        btnSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("7"));
            }
        });

        Button btnOito = v.findViewById(R.id.button8);
        btnOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("8"));
            }
        });

        Button btnNove = v.findViewById(R.id.button9);
        btnNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("9"));
            }
        });

        Button btnAdicao = v.findViewById(R.id.buttonAdicao);
        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(" + "));
            }
        });

        Button btnSubtracao = v.findViewById(R.id.buttonSubtracao);
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(" - "));
            }
        });

        Button btnMultiplicacao = v.findViewById(R.id.buttonMultiplicacao);
        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(" * "));
            }
        });

        Button btnDivisao = v.findViewById(R.id.buttonDivisao);
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(" / "));
            }
        });

        Button btnAbrirParenteses = v.findViewById(R.id.buttonAbrirParenteses);
        btnAbrirParenteses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat("("));
            }
        });

        Button btnFecharParenteses = v.findViewById(R.id.buttonFecharParenteses);
        btnFecharParenteses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(")"));
            }
        });

        Button btnElevado = v.findViewById(R.id.buttonElevado);
        btnElevado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(" ^ "));
            }
        });

        Button btnVirgula = v.findViewById(R.id.buttonVirgula);
        btnVirgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperacao.setText(tvOperacao.getText().toString().concat(","));
            }
        });

        Button btnLimpar = v.findViewById(R.id.buttonLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText("");
                tvOperacao.setText("");
            }
        });

        Button btnIgual = v.findViewById(R.id.buttonIgual);
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText("");
                try {
                    String operacao = tvOperacao.getText().toString();
                    operacao = operacao.replace(",", ".");
                    Expr expr = Parser.parse(operacao);
                    String resultado = String.valueOf(expr.value()).replace(".", ",");
                    tvResultado.setText(resultado);

                    // Armazena resultado no histórico
                    DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
                    databaseHelper.createHistorico(operacao.concat(" = ").concat(resultado));

                } catch (SyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        return v;
    }
}