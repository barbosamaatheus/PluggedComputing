package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.activitys.ExerciciosActivity;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;
import com.tcc.projeto.appcomputacaoplugada.objetos.Carta;


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
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta), R.drawable.ic_error_outline_black_24dp);
                } else {
                    validarCampos();
                    gerenciarResultados(2, getActivity());
                }
            }
        });

        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog("Dicas", getString(R.string.dicas_nb),R.drawable.ic_help_outline_black_24dp );
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
            mMaiorValor.setError(getString(R.string.resposta_incorreta));
            focus = mMaiorValor;
            exibir = true;
        }
        if (!menorValor.equals("0")) {
            mMenorValor.setError(getString(R.string.resposta_incorreta));
            focus = mMenorValor;
            exibir = true;
        }
        if (!passou2) {
            perg2.setError(getString(R.string.resposta_incorreta));
            focus = perg2;
            exibir = true;
        }
        if (!passou3) {
            perg3.setError(getString(R.string.resposta_incorreta));
            focus = perg3;
            exibir = true;
        }
        if (exibir) {
            focus.requestFocus();
        }
        return exibir;
    }


    @Override
    protected void initViews(View view) {
        mFinalizar = (Button) view.findViewById(R.id.btn_finalizar_nb);
        mDicas = (ImageButton) view.findViewById(R.id.dicasNB);
        mMaiorValor = (EditText) view.findViewById(R.id.valorMaiorNB);
        mMenorValor = (EditText) view.findViewById(R.id.valorMenorNB);
        initCartas(view);
        initNum(view);
        createCartas();
        initRadioGroups(view);
        initPerguntas(view);

    }

    private void initPerguntas(View view) {
        perg1 = (TextView) view.findViewById(R.id.perg1_nb);
        perg2 = (TextView) view.findViewById(R.id.perg2_nb);
        perg3 = (TextView) view.findViewById(R.id.perg3_nb);
    }

    private void initRadioGroups(View view) {
        radioGroup2 = (RadioGroup) view.findViewById(R.id.myRadioGroup2NB);
        certo2 = (RadioButton) view.findViewById(R.id.certo2);
        errado21 = (RadioButton) view.findViewById(R.id.errado21);
        errado22 = (RadioButton) view.findViewById(R.id.errado22);

        radioGroup3 = (RadioGroup) view.findViewById(R.id.myRadioGroup3NB);
        certo3 = (RadioButton) view.findViewById(R.id.certo3);
        errado31 = (RadioButton) view.findViewById(R.id.errado31);
        errado32 = (RadioButton) view.findViewById(R.id.errado32);
    }

    private void initNum(View view) {
        numTxt1 = (TextView) view.findViewById(R.id.num1NB);
        numTxt2 = (TextView) view.findViewById(R.id.num2NB);
        numTxt4 = (TextView) view.findViewById(R.id.num4NB);
        numTxt8 = (TextView) view.findViewById(R.id.num8NB);
        numTxt16 = (TextView) view.findViewById(R.id.num16NB);
    }

    private void initCartas(View view) {
        mCarta1 = (ImageButton) view.findViewById(R.id.carta1NB);
        mCarta2 = (ImageButton) view.findViewById(R.id.carta2NB);
        mCarta4 = (ImageButton) view.findViewById(R.id.carta4NB);
        mCarta8 = (ImageButton) view.findViewById(R.id.carta8NB);
        mCarta16 = (ImageButton) view.findViewById(R.id.carta16NB);
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
