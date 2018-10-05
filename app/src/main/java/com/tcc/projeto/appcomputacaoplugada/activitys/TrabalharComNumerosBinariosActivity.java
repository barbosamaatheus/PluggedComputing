package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tcc.projeto.appcomputacaoplugada.R;

public class TrabalharComNumerosBinariosActivity extends TarefasManager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabalhar_com_numeros_binarios);
        initViews();
        initVerify();
        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respostasIsEmpty()) {
                    vibrar();
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta), R.drawable.ic_error_outline_black_24dp);
                } else {
                    validarCampos();
                    gerenciarResultados(3, getApplicationContext());
                }
            }
        });
        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog();
            }
        });
    }

    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!num1.equalsIgnoreCase("9")) {
            focus = showError(mNum1);
        }
        if (!num2.equalsIgnoreCase("10")) {
            focus = showError(mNum2);
        }
        if (!num3.equalsIgnoreCase("5")) {
            focus = showError(mNum3);
        }
        if (!num4.equalsIgnoreCase("11")) {
            focus = showError(mNum4);
        }
        if (!num5.equalsIgnoreCase("0")) {
            focus = showError(mNum5);
        }
        if (!num6.equalsIgnoreCase("17")) {
            focus = showError(mNum6);
        }
        if (!num7.equalsIgnoreCase("2")) {
            focus = showError(mNum7);
        }
        if (!num8.equalsIgnoreCase("20")) {
            focus = showError(mNum8);
        }
        if (!num9.equalsIgnoreCase("0")) {
            focus = showError(mNum9);
        }
        if (!num10.equalsIgnoreCase("31")) {
            focus = showError(mNum10);
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

    private void validarClicked() {
        if (mNum1.getText().toString().isEmpty() || mNum2.getText().toString().isEmpty() || mNum3.getText().toString().isEmpty() ||
                mNum4.getText().toString().isEmpty() || mNum5.getText().toString().isEmpty() || mNum6.getText().toString().isEmpty() ||
                mNum7.getText().toString().isEmpty() || mNum8.getText().toString().isEmpty() || mNum9.getText().toString().isEmpty() ||
                mNum10.getText().toString().isEmpty()) {
            checked1 = false;
        } else {
            getTextDoEditText(3);
            checked1 = true;
        }
        if (num1.isEmpty() || num2.isEmpty() || num3.isEmpty() ||
                num4.isEmpty() || num5.isEmpty() || num6.isEmpty() ||
                num7.isEmpty() || num8.isEmpty() || num9.isEmpty() ||
                num10.isEmpty()) {
            checked1 = false;
        } else {
            checked1 = true;
        }
    }

    @Override
    protected void initViews() {
        initEditText();
        initButtons();

    }

    @SuppressLint("NewApi")
    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setView(R.layout.alert_cartas);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
