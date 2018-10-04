package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;

public class EnviarMensagensSecretasFragment extends MyFragments {
    private String textoTraduzido = "";
    private TextInputLayout textInputLayout;
    private TextInputEditText mTextoTraduzido;

    public EnviarMensagensSecretasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_enviar_mensagens_secretas, container, false);
        initViews(view);
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
                    gerenciarResultados(4, getActivity());
                }
            }
        });
        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog("Dicas", getString(R.string.dicas_ems), R.drawable.ic_help_outline_black_24dp);
            }
        });

        return view;
    }

    private void validarClicked() {
        if (mNum1.getText().toString().isEmpty() || mNum2.getText().toString().isEmpty() || mNum3.getText().toString().isEmpty() ||
                mNum4.getText().toString().isEmpty() || mNum5.getText().toString().isEmpty() || mNum6.getText().toString().isEmpty() ||
                mNum7.getText().toString().isEmpty() || mNum8.getText().toString().isEmpty() || mNum9.getText().toString().isEmpty() ||
                mNum10.getText().toString().isEmpty() || mNum11.getText().toString().isEmpty() || mNum12.getText().toString().isEmpty() ||
                mNum13.getText().toString().isEmpty() || mNum14.getText().toString().isEmpty() || mNum15.getText().toString().isEmpty()) {
            checked1 = false;
        } else {
            getTextDoEditText();
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

    private void getTextDoEditText() {
        num1 = mNum1.getText().toString();
        num2 = mNum2.getText().toString();
        num3 = mNum3.getText().toString();
        num4 = mNum4.getText().toString();
        num5 = mNum5.getText().toString();
        num6 = mNum6.getText().toString();
        num7 = mNum7.getText().toString();
        num8 = mNum8.getText().toString();
        num9 = mNum9.getText().toString();
        num10 = mNum10.getText().toString();
        num11 = mNum11.getText().toString();
        num12 = mNum12.getText().toString();
        num13 = mNum13.getText().toString();
        num14 = mNum14.getText().toString();
        num15 = mNum15.getText().toString();
        textoTraduzido = mTextoTraduzido.getText().toString();
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
            mNum1.setError(getString(R.string.resposta_incorreta));
            focus = mNum1;
            exibir = true;
        }
        if (!num2.equalsIgnoreCase("10")) {
            mNum2.setError(getString(R.string.resposta_incorreta));
            focus = mNum2;
            exibir = true;
        }
        if (!num3.equalsIgnoreCase("21")) {
            mNum3.setError(getString(R.string.resposta_incorreta));
            focus = mNum3;
            exibir = true;
        }
        if (!num4.equalsIgnoreCase("4")) {
            mNum4.setError(getString(R.string.resposta_incorreta));
            focus = mNum4;
            exibir = true;
        }
        if (!num5.equalsIgnoreCase("5")) {
            mNum5.setError(getString(R.string.resposta_incorreta));
            focus = mNum5;
            exibir = true;
        }

        if (!num6.equalsIgnoreCase("5")) {
            mNum6.setError(getString(R.string.resposta_incorreta));
            focus = mNum6;
            exibir = true;
        }
        if (!num7.equalsIgnoreCase("19")) {
            mNum7.setError(getString(R.string.resposta_incorreta));
            focus = mNum7;
            exibir = true;
        }
        if (!num8.equalsIgnoreCase("20")) {
            mNum8.setError(getString(R.string.resposta_incorreta));
            focus = mNum8;
            exibir = true;
        }
        if (!num9.equalsIgnoreCase("15")) {
            mNum9.setError(getString(R.string.resposta_incorreta));
            focus = mNum9;
            exibir = true;
        }
        if (!num10.equalsIgnoreCase("21")) {
            mNum10.setError(getString(R.string.resposta_incorreta));
            focus = mNum10;
            exibir = true;
        }
        if (!num11.equalsIgnoreCase("16")) {
            mNum11.setError(getString(R.string.resposta_incorreta));
            focus = mNum11;
            exibir = true;
        }
        if (!num12.equalsIgnoreCase("18")) {
            mNum12.setError(getString(R.string.resposta_incorreta));
            focus = mNum12;
            exibir = true;
        }
        if (!num13.equalsIgnoreCase("5")) {
            mNum13.setError(getString(R.string.resposta_incorreta));
            focus = mNum13;
            exibir = true;
        }
        if (!num14.equalsIgnoreCase("19")) {
            mNum14.setError(getString(R.string.resposta_incorreta));
            focus = mNum14;
            exibir = true;
        }
        if (!num15.equalsIgnoreCase("15")) {
            mNum15.setError(getString(R.string.resposta_incorreta));
            focus = mNum15;
            exibir = true;
        }
        if (!validarTexto()) {
            mTextoTraduzido.setError(getString(R.string.resposta_incorreta));
            focus = mTextoTraduzido;
            exibir = true;
        }

        if (exibir) {
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
    protected void initViews(View view) {
        initEditText(view);

        mNumerosSelecionados = (TextView) view.findViewById(R.id.numerosSelecionados);

        mFinalizar = (Button) view.findViewById(R.id.btn_finalizar_ems);
    }

    private void initEditText(View view) {
        textInputLayout = (TextInputLayout) view.findViewById(R.id.textInputLayout);
        mTextoTraduzido = (TextInputEditText) view.findViewById(R.id.textoTraduzido);
       // mTextoTraduzido = (EditText) view.findViewById(R.id.textoTraduzido);
        mDicas = (ImageButton) view.findViewById(R.id.dicasEMS);

        mNum1 = (EditText) view.findViewById(R.id.num1EMS);
        mNum2 = (EditText) view.findViewById(R.id.num2EMS);
        mNum3 = (EditText) view.findViewById(R.id.num3EMS);
        mNum4 = (EditText) view.findViewById(R.id.num4EMS);
        mNum5 = (EditText) view.findViewById(R.id.num5EMS);

        mNum6 = (EditText) view.findViewById(R.id.num6EMS);
        mNum7 = (EditText) view.findViewById(R.id.num7EMS);
        mNum8 = (EditText) view.findViewById(R.id.num8EMS);
        mNum9 = (EditText) view.findViewById(R.id.num9EMS);
        mNum10 = (EditText) view.findViewById(R.id.num10EMS);

        mNum11 = (EditText) view.findViewById(R.id.num11EMS);
        mNum12 = (EditText) view.findViewById(R.id.num12EMS);
        mNum13 = (EditText) view.findViewById(R.id.num13EMS);
        mNum14 = (EditText) view.findViewById(R.id.num14EMS);
        mNum15 = (EditText) view.findViewById(R.id.num15EMS);
    }

}
