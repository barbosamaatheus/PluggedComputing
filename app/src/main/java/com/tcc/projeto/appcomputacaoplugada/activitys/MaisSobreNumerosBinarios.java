package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.tcc.projeto.appcomputacaoplugada.R;

public class MaisSobreNumerosBinarios extends TarefasManager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mais_sobre_numeros_binarios);
        initViews();
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
                    gerenciarResultados(7, getApplicationContext());
                }
            }
        });

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
    protected void initViews() {
        initButtons();
        initRadioGroups();
        initPerguntas();

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
