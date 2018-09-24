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
           // validarCampos();
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
                validarResposta();
            }
        });

        return view;
    }

    private void validarResposta() {

        validarTexto();
    }

    private void validarTexto() {
        String textoTraduzido = mTextoTraduzido.getText().toString();
        String respostaCorreta = "ajuda estou preso";
        if(textoTraduzido.equalsIgnoreCase(respostaCorreta)){
            myApplication.setPositionExercicio(1);
            callNextFragment();
        }else {
            restartFragment();

        }
    }

    private String montarNumeros() {
        return mNum1.getText().toString()+" "+mNum2.getText().toString()+" "+mNum3.getText().toString()+" "+mNum4.getText().toString()+" "+mNum5.getText().toString()+" "+"-"+
                mNum6.getText().toString()+" "+mNum7.getText().toString()+" "+mNum8.getText().toString()+" "+mNum9.getText().toString()+" "+mNum10.getText().toString()+" "+"-"+
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
