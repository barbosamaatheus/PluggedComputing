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

import com.daimajia.androidanimations.library.Techniques;
import com.tcc.projeto.appcomputacaoplugada.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaisSobreNumerosBinariosFragment extends MyFragments {
    public MaisSobreNumerosBinariosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mais_sobre_numeros_binarios, container, false);
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
        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog("Dicas", getString(R.string.dicas_mnb),
                        7, getActivity());
            }
        });

        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respostasIsEmpty()) {
                    vibrar();
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta),
                            7, getActivity());
                } else {
                    validarCampos();
                    gerenciarResultados(7, getActivity());
                }
            }
        });

        return view;
    }

    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!passou1) {
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
        initButtons(view);
        initRadioGroups(view);
        initPerguntas(view);

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

}
