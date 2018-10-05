package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;

public class EnviarMensagensSecretasActivity extends TarefasManager {
    private String textoTraduzido = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mensagens_secretas);
        initViews();
        initVerify();
        mNumerosSelecionados.setText(montarNumerosET());

        mNum1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        mNum2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum4.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum5.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum6.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum7.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum8.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum9.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum10.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum11.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum12.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum13.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum14.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mNum15.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1)
                    mNumerosSelecionados.setText(montarNumerosET());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (respostasIsEmpty()) {
                    vibrar();
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta), R.drawable.ic_error_outline_black_24dp);
                } else {
                    validarCampos();
                    gerenciarResultados(4, getApplicationContext());
                }
            }
        });
        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog("Dicas", getString(R.string.dicas_ems), R.drawable.ic_help_outline_black_24dp);
            }
        });

    }

    private void validarClicked() {
        if (mNum1.getText().toString().isEmpty() || mNum2.getText().toString().isEmpty() || mNum3.getText().toString().isEmpty() ||
                mNum4.getText().toString().isEmpty() || mNum5.getText().toString().isEmpty() || mNum6.getText().toString().isEmpty() ||
                mNum7.getText().toString().isEmpty() || mNum8.getText().toString().isEmpty() || mNum9.getText().toString().isEmpty() ||
                mNum10.getText().toString().isEmpty() || mNum11.getText().toString().isEmpty() || mNum12.getText().toString().isEmpty() ||
                mNum13.getText().toString().isEmpty() || mNum14.getText().toString().isEmpty() || mNum15.getText().toString().isEmpty()) {
            checked1 = false;
        } else {
            getTextDoEditText(4);
            textoTraduzido = mTextoTraduzido.getText().toString();
            checked1 = true;
        }

        if (num1.isEmpty() || num2.isEmpty() || num3.isEmpty() ||
                num4.isEmpty() || num5.isEmpty() || num6.isEmpty() ||
                num7.isEmpty() || num8.isEmpty() || num9.isEmpty() ||
                num10.isEmpty() || num11.isEmpty() || num12.isEmpty() ||
                num13.isEmpty() || num14.isEmpty() || num15.isEmpty() || textoTraduzido.isEmpty()) {
            checked1 = false;
        } else {
            checked1 = true;
        }
        if (textoTraduzido.isEmpty()) {
            checked1 = false;
        } else {
            checked1 = true;
        }
    }


    private boolean validarTexto() {
        boolean certo;
        String respostaCorreta = "ajude estou preso";
        if (textoTraduzido.equalsIgnoreCase(respostaCorreta)) {
            certo = true;
        } else {
            certo = false;
        }
        return certo;
    }

    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!num1.equalsIgnoreCase("1")) {
            focus = showError(mNum1);
        }
        if (!num2.equalsIgnoreCase("10")) {
            focus = showError(mNum2);
        }
        if (!num3.equalsIgnoreCase("21")) {
            focus = showError(mNum3);
        }
        if (!num4.equalsIgnoreCase("4")) {
            focus = showError(mNum4);
        }
        if (!num5.equalsIgnoreCase("5")) {
            focus = showError(mNum5);
        }

        if (!num6.equalsIgnoreCase("5")) {
            focus = showError(mNum6);
        }
        if (!num7.equalsIgnoreCase("19")) {
            focus = showError(mNum7);
        }
        if (!num8.equalsIgnoreCase("20")) {
            focus = showError(mNum8);
        }
        if (!num9.equalsIgnoreCase("15")) {
            focus = showError(mNum9);
        }
        if (!num10.equalsIgnoreCase("21")) {
            focus = showError(mNum10);
        }
        if (!num11.equalsIgnoreCase("16")) {
            focus = showError(mNum11);
        }
        if (!num12.equalsIgnoreCase("18")) {
            focus = showError(mNum12);
        }
        if (!num13.equalsIgnoreCase("5")) {
            focus = showError(mNum13);
        }
        if (!num14.equalsIgnoreCase("19")) {
            focus = showError(mNum14);
        }
        if (!num15.equalsIgnoreCase("15")) {
            focus = showError(mNum15);
        }
        if (!validarTexto()) {
            focus = showError(mTextoTraduzido);
        }

        if (exibir) {
            vibrar();
            focus.requestFocus();
        }
        return exibir;
    }

    @Override
    protected boolean respostasIsEmpty() {
        validarClicked();
        boolean isEmpty;
        if (!checked1) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Override
    protected void initViews() {
        mNumerosSelecionados = (TextView) findViewById(R.id.numerosSelecionados);
        initEditText();
        initButtons();
    }
}
