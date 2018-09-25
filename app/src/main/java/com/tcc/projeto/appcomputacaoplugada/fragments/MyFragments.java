package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.activitys.ExerciciosActivity;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;
import com.tcc.projeto.appcomputacaoplugada.objetos.Carta;

/**
 * Created by matheus.barbosa on 25/09/2018.
 */

public abstract class MyFragments extends Fragment {
    protected boolean checked1 = false;
    protected boolean checked3 = false;
    protected boolean checked2 = false;
    protected boolean passou1 = true;
    protected boolean passou2 = true;
    protected boolean passou3 = true;
    protected String num1 = "";
    protected String num2 = "";
    protected String num3 = "";
    protected String num4 = "";
    protected String num5 = "";
    protected String num6 = "";
    protected String num7 = "";
    protected String num8 = "";
    protected String num9 = "";
    protected String num10 = "";
    protected String num11 = "";
    protected String num12 = "";
    protected String num13 = "";
    protected String num14 = "";
    protected String num15 = "";
    protected boolean exibir;
    protected MyApplication myApplication;

    protected void restartFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    protected void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogStyle);
        builder.setMessage(R.string.texto_alert_sem_resposta).setTitle("Algo deu errado :(");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected void callNextFragment() {
        Intent intent = new Intent(getActivity().getApplicationContext(), ExerciciosActivity.class);
        startActivity(intent);
    }

    protected void virarCarta(Carta carta, TextView num, ImageButton mCarta) {
        if (carta.isFrente()) {
            carta.setFrente(false);
            carta.setImagem(R.mipmap.fundocarta);
            num.setText("0");
        } else {
            carta.setFrente(true);
            mudarImagem(carta);
            num.setText("1");
        }
        mCarta.setBackgroundResource(carta.getImagem());
    }

    protected void mudarImagem(Carta carta) {
        switch (carta.getNumero()) {
            case 1:
                carta.setImagem(R.mipmap.carta1);
                break;
            case 2:
                carta.setImagem(R.mipmap.carta2);
                break;
            case 4:
                carta.setImagem(R.mipmap.carta4);
                break;
            case 8:
                carta.setImagem(R.mipmap.carta8);
                break;
            case 16:
                carta.setImagem(R.mipmap.carta16);
                break;
        }
    }

    protected void onRadioButtonClicked1(int checked) {
        checked1 = true;
        passou1 = false;
        switch (checked) {
            case R.id.certo1:
                passou1 = true;
                break;
            case R.id.errado11:
                passou1 = false;
                break;
            case R.id.errado12:
                passou1 = false;
                break;
        }
    }

    protected void onRadioButtonClicked2(int checked) {
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

    protected void onRadioButtonClicked3(int checked) {
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

    protected String montarNumeros() {
        return num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " - " +
                num6 + " " + num7 + " " + num8 + " " + num9 + " " + num10 + " - " +
                num11 + " " + num12 + " " + num13 + " " + num14 + " " + num15;
    }

    protected void initViews(View view) {
        myApplication = (MyApplication) getActivity().getApplicationContext();
    }
    protected void createCartas(){

    }

    protected abstract boolean respostasIsEmpty();

    protected abstract void gerenciarResultados(int position);

    protected abstract boolean validarCampos();



}
