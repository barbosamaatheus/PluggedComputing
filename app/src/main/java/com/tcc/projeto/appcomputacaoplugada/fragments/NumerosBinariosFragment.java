package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.tcc.projeto.appcomputacaoplugada.R;

public class NumerosBinariosFragment extends MyFragments {

    private EditText mMaiorValor, mMenorValor;
    private String maiorValor = "";
    private String menorValor = "";


    public NumerosBinariosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros_binarios, container, false);

        initViews(view);
        initVerify();

        mCarta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta01, numTxt1, mCarta1);
            }
        });
        mCarta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta02, numTxt2, mCarta2);

            }
        });
        mCarta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta04, numTxt4, mCarta4);
            }
        });
        mCarta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta08, numTxt8, mCarta8);
            }
        });
        mCarta16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta16, numTxt16, mCarta16);
            }
        });
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onRadioButtonClicked2(checkedId);
            }
        });
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onRadioButtonClicked3(checkedId);
            }
        });
        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respostasIsEmpty()) {
                    vibrar();
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta),
                            2, getActivity());
                } else {
                    validarCampos();
                    gerenciarResultados(2, getActivity());
                }
            }
        });

        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog("Dicas", getString(R.string.dicas_nb),
                        2, getActivity());
            }
        });

        return view;
    }


    @Override
    protected boolean respostasIsEmpty() {
        validarClicked1();
        boolean isEmpty;
        if (!checked1 || !checked2 || !checked3) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!maiorValor.equals("31")) {
            focus = showError(perg1);
        }
        if (!menorValor.equals("0")) {
            focus = showError(perg1);
        }
        if (!passou2) {
            focus = showError(perg2);
        }
        if (!passou3) {
            focus = showError(perg3);
        }
        if (exibir) {
            vibrar();
            focus.requestFocus();
        }
        return exibir;
    }


    @Override
    protected void initViews(View view) {
        mMaiorValor = (EditText) view.findViewById(R.id.valorMaiorNB);
        mMenorValor = (EditText) view.findViewById(R.id.valorMenorNB);
        initButtons(view);
        initCartas(view);
        initNum(view);
        createCartas();
        initRadioGroups(view);
        initPerguntas(view);

    }


    public void validarClicked1() {
        if (mMenorValor.getText().toString().isEmpty() || mMaiorValor.getText().toString().isEmpty()) {
            checked1 = false;
        } else {
            this.maiorValor = mMaiorValor.getText().toString();
            this.menorValor = mMenorValor.getText().toString();
            checked1 = true;
        }
        if (maiorValor.isEmpty() || menorValor.isEmpty()) {
            checked1 = false;
        } else {
            checked1 = true;
        }
    }

    public void onRadioButtonClicked2(int checked) {
        checked2 = true;
        passou2 = false;
        switch (checked) {
            case R.id.certo2:
                passou2 = true;
                break;
            case R.id.errado21:
                passou2 = false;
                break;

            case R.id.errado22:
                passou2 = false;
                break;
        }
    }

    public void onRadioButtonClicked3(int checked) {
        checked3 = true;
        passou3 = false;
        switch (checked) {
            case R.id.certo3:
                passou3 = true;
                break;
            case R.id.errado31:
                passou3 = false;
                break;
            case R.id.errado32:
                passou3 = false;
                break;
        }
    }

}
