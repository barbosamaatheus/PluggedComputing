package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.objetos.Carta;

public class IntroducaoFragment extends MyFragments {

    public IntroducaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introducao, container, false);

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
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onRadioButtonClicked1(checkedId);
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
                    gerenciarResultados(1, getActivity());
                }
            }
        });
        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog("Dicas", getString(R.string.dicas_intro), R.drawable.ic_help_outline_black_24dp);
            }
        });
        return view;
    }


    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!passou1) {
            perg1.setError(getString(R.string.resposta_incorreta));
            focus = perg1;
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
    protected boolean respostasIsEmpty() {
        boolean isEmpty;
        if (!checked1 || !checked2 || !checked3) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;

    }

    @Override
    protected void createCartas() {
        carta01 = new Carta(R.id.carta1, R.mipmap.carta1, 1, true);
        carta02 = new Carta(R.id.carta2, R.mipmap.carta2, 2, false);
        carta04 = new Carta(R.id.carta4, R.mipmap.carta4, 4, false);
        carta08 = new Carta(R.id.carta8, R.mipmap.carta8, 8, true);
        carta16 = new Carta(R.id.carta16, R.mipmap.carta16, 16, false);
    }

    @Override
    protected void initViews(View view) {
        mFinalizar = (Button) view.findViewById(R.id.btn_finalizar);
        mDicas = (ImageButton) view.findViewById(R.id.dicasINTRO);
        initCartas(view);
        initNum(view);
        createCartas();
        initRadioGroups(view);
        initPerguntas(view);
    }

    private void initPerguntas(View view) {
        perg1 = (TextView) view.findViewById(R.id.perg1_intro);
        perg2 = (TextView) view.findViewById(R.id.perg2_intro);
        perg3 = (TextView) view.findViewById(R.id.perg3_intro);
    }

    private void initRadioGroups(View view) {
        radioGroup1 = (RadioGroup) view.findViewById(R.id.myRadioGroup1);
        certo1 = (RadioButton) view.findViewById(R.id.certo1);
        errado11 = (RadioButton) view.findViewById(R.id.errado11);
        errado12 = (RadioButton) view.findViewById(R.id.errado12);

        radioGroup2 = (RadioGroup) view.findViewById(R.id.myRadioGroup2);
        certo2 = (RadioButton) view.findViewById(R.id.certo2);
        errado21 = (RadioButton) view.findViewById(R.id.errado21);
        errado22 = (RadioButton) view.findViewById(R.id.errado22);

        radioGroup3 = (RadioGroup) view.findViewById(R.id.myRadioGroup3);
        certo3 = (RadioButton) view.findViewById(R.id.certo3);
        errado31 = (RadioButton) view.findViewById(R.id.errado31);
        errado32 = (RadioButton) view.findViewById(R.id.errado32);
    }

    private void initNum(View view) {
        numTxt1 = (TextView) view.findViewById(R.id.num1);
        numTxt2 = (TextView) view.findViewById(R.id.num2);
        numTxt4 = (TextView) view.findViewById(R.id.num4);
        numTxt8 = (TextView) view.findViewById(R.id.num8);
        numTxt16 = (TextView) view.findViewById(R.id.num16);
    }

    private void initCartas(View view) {
        mCarta1 = (ImageButton) view.findViewById(R.id.carta1);
        mCarta2 = (ImageButton) view.findViewById(R.id.carta2);
        mCarta4 = (ImageButton) view.findViewById(R.id.carta4);
        mCarta8 = (ImageButton) view.findViewById(R.id.carta8);
        mCarta16 = (ImageButton) view.findViewById(R.id.carta16);
    }


}