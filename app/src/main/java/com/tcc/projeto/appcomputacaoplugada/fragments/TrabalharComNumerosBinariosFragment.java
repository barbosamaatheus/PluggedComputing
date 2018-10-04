package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.activitys.MainActivity;


public class TrabalharComNumerosBinariosFragment extends MyFragments {
    public TrabalharComNumerosBinariosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trabalhar_com_numeros_binarios, container, false);
        initViews(view);
        initVerify();
        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respostasIsEmpty()) {
                    vibrar();
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta), R.drawable.ic_error_outline_black_24dp);
                } else {
                    validarCampos();
                    gerenciarResultados(3, getActivity());
                }
            }
        });
        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog();
            }
        });
        return view;
    }


    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!num1.equalsIgnoreCase("9")) {
            mNum1.setError(getString(R.string.resposta_incorreta));
            focus = mNum1;
            exibir = true;
        }
        if (!num2.equalsIgnoreCase("10")) {
            mNum2.setError(getString(R.string.resposta_incorreta));
            focus = mNum2;
            exibir = true;
        }
        if (!num3.equalsIgnoreCase("5")) {
            mNum3.setError(getString(R.string.resposta_incorreta));
            focus = mNum3;
            exibir = true;
        }
        if (!num4.equalsIgnoreCase("11")) {
            mNum4.setError(getString(R.string.resposta_incorreta));
            focus = mNum4;
            exibir = true;
        }
        if (!num5.equalsIgnoreCase("0")) {
            mNum5.setError(getString(R.string.resposta_incorreta));
            focus = mNum5;
            exibir = true;
        }

        if (!num6.equalsIgnoreCase("17")) {
            mNum6.setError(getString(R.string.resposta_incorreta));
            focus = mNum6;
            exibir = true;
        }
        if (!num7.equalsIgnoreCase("2")) {
            mNum7.setError(getString(R.string.resposta_incorreta));
            focus = mNum7;
            exibir = true;
        }
        if (!num8.equalsIgnoreCase("20")) {
            mNum8.setError(getString(R.string.resposta_incorreta));
            focus = mNum8;
            exibir = true;
        }
        if (!num9.equalsIgnoreCase("0")) {
            mNum9.setError(getString(R.string.resposta_incorreta));
            focus = mNum9;
            exibir = true;
        }
        if (!num10.equalsIgnoreCase("31")) {
            mNum10.setError(getString(R.string.resposta_incorreta));
            focus = mNum10;
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

    private void validarClicked() {
        if (mNum1.getText().toString().isEmpty() || mNum2.getText().toString().isEmpty() || mNum3.getText().toString().isEmpty() ||
                mNum4.getText().toString().isEmpty() || mNum5.getText().toString().isEmpty() || mNum6.getText().toString().isEmpty() ||
                mNum7.getText().toString().isEmpty() || mNum8.getText().toString().isEmpty() || mNum9.getText().toString().isEmpty() ||
                mNum10.getText().toString().isEmpty()) {
            checked1 = false;
        } else {
            getTextDoEditText();
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
    }


    @Override
    protected void initViews(View view) {
        initEditText(view);
        mFinalizar = (Button) view.findViewById(R.id.btn_finalizar_tnb);
        mDicas = (ImageButton) view.findViewById(R.id.dicasTNB);

    }

    private void initEditText(View view) {
        mNum1 = (EditText) view.findViewById(R.id.num1TNB);
        mNum2 = (EditText) view.findViewById(R.id.num2TNB);
        mNum3 = (EditText) view.findViewById(R.id.num3TNB);
        mNum4 = (EditText) view.findViewById(R.id.num4TNB);
        mNum5 = (EditText) view.findViewById(R.id.num5TNB);

        mNum6 = (EditText) view.findViewById(R.id.num6TNB);
        mNum7 = (EditText) view.findViewById(R.id.num7TNB);
        mNum8 = (EditText) view.findViewById(R.id.num8TNB);
        mNum9 = (EditText) view.findViewById(R.id.num9TNB);
        mNum10 = (EditText) view.findViewById(R.id.num10TNB);
    }

    @SuppressLint("NewApi")
    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(R.layout.alert_cartas);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
