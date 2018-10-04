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
                onCreateDialog("Dicas", getString(R.string.dicas_mnb), R.drawable.ic_help_outline_black_24dp);
            }
        });

        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respostasIsEmpty()) {
                    vibrar();
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta), R.drawable.ic_error_outline_black_24dp);
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
    protected void initViews(View view) {
        mDicas = (ImageButton) view.findViewById(R.id.dicasMNB);
        mFinalizar = (Button) view.findViewById(R.id.btn_finalizarMNB);
        initRadioGroups(view);
        initPerguntas(view);

    }

    private void initPerguntas(View view) {
        perg1 = (TextView) view.findViewById(R.id.perg1_mnb);
        perg2 = (TextView) view.findViewById(R.id.perg2_mnb);
        perg3 = (TextView) view.findViewById(R.id.perg3_mnb);
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
