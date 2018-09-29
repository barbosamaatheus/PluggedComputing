package com.tcc.projeto.appcomputacaoplugada.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class ContarAcima31Fragment extends MyFragments {


    public ContarAcima31Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contar_acima31, container, false);
        initViews(view);
        initVerify();

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
                    gerenciarResultados(6, getActivity());
                }
            }
        });
        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog("Dicas", getString(R.string.dicas_ca31), R.drawable.ic_help_outline_black_24dp);
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
    protected void initViews(View view) {
        mFinalizar = (Button) view.findViewById(R.id.btn_finalizar_CA);
        mDicas = (ImageButton) view.findViewById(R.id.dicasCA);
        initRadioGroups(view);
        initPerguntas(view);
    }

    private void initPerguntas(View view) {
        perg1 = (TextView) view.findViewById(R.id.perg1_CA);
        perg2 = (TextView) view.findViewById(R.id.perg2_CA);
        perg3 = (TextView) view.findViewById(R.id.perg3_CA);
    }

    private void initRadioGroups(View view) {
        radioGroup1 = (RadioGroup) view.findViewById(R.id.myRadioGroup1CA);
        certo1 = (RadioButton) view.findViewById(R.id.certo1);
        errado11 = (RadioButton) view.findViewById(R.id.errado11);
        errado12 = (RadioButton) view.findViewById(R.id.errado12);

        radioGroup2 = (RadioGroup) view.findViewById(R.id.myRadioGroup2CA);
        certo2 = (RadioButton) view.findViewById(R.id.certo2);
        errado21 = (RadioButton) view.findViewById(R.id.errado21);
        errado22 = (RadioButton) view.findViewById(R.id.errado22);

        radioGroup3 = (RadioGroup) view.findViewById(R.id.myRadioGroup3CA);
        certo3 = (RadioButton) view.findViewById(R.id.certo3);
        errado31 = (RadioButton) view.findViewById(R.id.errado31);
        errado32 = (RadioButton) view.findViewById(R.id.errado32);
    }





}
