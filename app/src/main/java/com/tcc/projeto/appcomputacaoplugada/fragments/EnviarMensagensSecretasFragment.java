package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.activitys.ExerciciosActivity;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;

public class EnviarMensagensSecretasFragment extends Fragment {
    private EditText mNum1, mNum2, mNum3, mNum4, mNum5, mNum6, mNum7, mNum8, mNum9, mNum10, mNum11, mNum12, mNum13, mNum14, mNum15, mTextoTraduzido;
    private TextView mNumerosSelecionados;
    private Button mFinalizar, mGetNumeros;
    private boolean checked1 = false;
    private MyApplication myApplication;
    private boolean exibir;

    public EnviarMensagensSecretasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_enviar_mensagens_secretas, container, false);
        initViews(view);
        if (!respostasIsEmpty()) {
            validarCampos();
        }

        mGetNumeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNumerosSelecionados.setText(montarNumeros());
            }
        });
        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (respostasIsEmpty()) {
                    onCreateDialog();
                } else {
                    validarCampos();
                    gerenciarResultados();
                }
            }
        });

        return view;
    }
    private void gerenciarResultados() {
        if (!exibir) {
            myApplication.setPositionExercicio(4);
            callNextFragment();
        } else {
            restartFragment();
        }

    }

    private boolean validarCampos() {

        View focus = null;
        exibir = false;
        /*if (mNum1.getText().toString().equalsIgnoreCase("1")) {
            mNum1.setError("Resposta incorreta");
            focus = mNum1;
            exibir = true;
        }
        if (mNum2.getText().toString().equalsIgnoreCase("10")) {
            mNum2.setError("Resposta incorreta");
            focus = mNum2;
            exibir = true;
        }
        if (mNum3.getText().toString().equalsIgnoreCase("21")) {
            mNum3.setError("Resposta incorreta");
            focus = mNum3;
            exibir = true;
        }
        if (mNum4.getText().toString().equalsIgnoreCase("4")) {
            mNum4.setError("Resposta incorreta");
            focus = mNum4;
            exibir = true;
        }
        if (mNum5.getText().toString().equalsIgnoreCase("5")) {
            mNum5.setError("Resposta incorreta");
            focus = mNum5;
            exibir = true;
        }

        if (mNum6.getText().toString().equalsIgnoreCase("5")) {
            mNum6.setError("Resposta incorreta");
            focus = mNum6;
            exibir = true;
        }
        if (mNum7.getText().toString().equalsIgnoreCase("19")) {
            mNum7.setError("Resposta incorreta");
            focus = mNum7;
            exibir = true;
        }
        if (mNum8.getText().toString().equalsIgnoreCase("20")) {
            mNum8.setError("Resposta incorreta");
            focus = mNum8;
            exibir = true;
        }
        if (mNum9.getText().toString().equalsIgnoreCase("15")) {
            mNum9.setError("Resposta incorreta");
            focus = mNum9;
            exibir = true;
        }
        if (mNum10.getText().toString().equalsIgnoreCase("21")) {
            mNum10.setError("Resposta incorreta");
            focus = mNum10;
            exibir = true;
        }
        if (mNum11.getText().toString().equalsIgnoreCase("16")) {
            mNum11.setError("Resposta incorreta");
            focus = mNum11;
            exibir = true;
        }
        if (mNum12.getText().toString().equalsIgnoreCase("18")) {
            mNum12.setError("Resposta incorreta");
            focus = mNum12;
            exibir = true;
        }
        if (mNum13.getText().toString().equalsIgnoreCase("5")) {
            mNum13.setError("Resposta incorreta");
            focus = mNum13;
            exibir = true;
        }
        if (mNum14.getText().toString().equalsIgnoreCase("19")) {
            mNum14.setError("Resposta incorreta");
            focus = mNum14;
            exibir = true;
        }
        if (mNum15.getText().toString().equalsIgnoreCase("15")) {
            mNum15.setError("Resposta incorreta");
            focus = mNum15;
            exibir = true;
        }*/
        if (montarNumeros().equalsIgnoreCase("1 10 21 4 5 - 5 19 20 15 21 - 16 18 5 19 15")) {
            mNumerosSelecionados.setError("Resposta incorreta");
            focus = mNumerosSelecionados;
            exibir = true;
        }
        if (!validarTexto()) {
            mTextoTraduzido.setError("Resposta incorreta");
            focus = mTextoTraduzido;
            exibir = true;
        }

        if (exibir) {
            focus.requestFocus();
        }
        return exibir;
    }

    private boolean validarTexto() {
        boolean certo = false;
        String textoTraduzido = mTextoTraduzido.getText().toString();
        String respostaCorreta = "ajude estou preso";
        if (!textoTraduzido.isEmpty()){
            checked1 = true;
        }
        if(textoTraduzido.equalsIgnoreCase(respostaCorreta)){
            certo = true;
        }else {
            certo = false;
        }
        return certo;
    }

    private String montarNumeros() {
        return mNum1.getText().toString()+" "+mNum2.getText().toString()+" "+mNum3.getText().toString()+" "+mNum4.getText().toString()+" "+mNum5.getText().toString()+" - "+
                mNum6.getText().toString()+" "+mNum7.getText().toString()+" "+mNum8.getText().toString()+" "+mNum9.getText().toString()+" "+mNum10.getText().toString()+" - "+
                mNum11.getText().toString()+" "+mNum12.getText().toString()+" "+mNum13.getText().toString()+" "+mNum14.getText().toString()+" "+mNum15.getText().toString();
    }

    private boolean respostasIsEmpty() {
        boolean isEmpty;
        if (!checked1) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }


    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogStyle);
        builder.setMessage(R.string.texto_alert_sem_resposta).setTitle("Algo deu errado :(");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void callNextFragment() {
        Intent intent = new Intent(getActivity().getApplicationContext(), ExerciciosActivity.class);
        startActivity(intent);
    }

    private void restartFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    private void initViews(View view) {
        myApplication = (MyApplication) getActivity().getApplicationContext();

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

        mNumerosSelecionados = (TextView) view.findViewById(R.id.numerosSelecionados);

        mFinalizar = (Button) view.findViewById(R.id.btn_finalizar_ems);
        mGetNumeros = (Button) view.findViewById(R.id.getNumeros);
    }

}
