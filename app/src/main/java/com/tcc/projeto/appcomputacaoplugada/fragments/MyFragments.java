package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.activitys.ExerciciosActivity;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;
import com.tcc.projeto.appcomputacaoplugada.objetos.Carta;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * Created by matheus.barbosa on 25/09/2018.
 */

public abstract class MyFragments extends Fragment {
    protected TextInputLayout textInputLayout1, textInputLayout2;
    protected TextInputEditText mTextoTraduzidoEMS, mTextoTraduzidoDTI, mTextoTraduzidoCEM, mTextoNome;
    protected EditText mNum1, mNum2, mNum3, mNum4, mNum5, mNum6, mNum7, mNum8, mNum9, mNum10, mNum11,
            mNum12, mNum13, mNum14, mNum15;
    protected ImageButton mCarta1, mCarta2, mCarta4, mCarta8, mCarta16, mDicas;
    protected TextView numTxt1, numTxt2, numTxt4, numTxt8, numTxt16, perg1, perg2, perg3, mNumerosSelecionados;
    protected RadioGroup radioGroup1, radioGroup2, radioGroup3;
    protected RadioButton certo1, certo2, certo3, errado11, errado12, errado21, errado22, errado31, errado32;
    protected Carta carta01, carta02, carta04, carta08, carta16;
    protected Button mFinalizar;

    protected boolean checked1 = false;
    protected boolean checked3 = false;
    protected boolean checked2 = false;
    protected boolean passou1 = true;
    protected boolean passou2 = true;
    protected boolean passou3 = true;
    protected boolean exibir;

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
    protected String textoTraduzido = "";

    protected MyApplication myApplication;

    protected View showError(TextView view) {
        View focus;
        view.setError(getString(R.string.resposta_incorreta));
        focus = view;
        exibir = true;
        showAnimation(view, Techniques.Shake);
        return focus;
    }

    protected View showError(EditText view) {
        View focus;
        view.setError(getString(R.string.resposta_incorreta));
        focus = view;
        exibir = true;
        showAnimation(view, Techniques.Shake);
        return focus;
    }

    protected void initVerify() {
        if (!respostasIsEmpty()) {
            validarCampos();
        }
    }

    protected void gerenciarResultados(int position, Context context) {
        myApplication = (MyApplication) context.getApplicationContext();
        if (!exibir) {
            editarPositionExercicio(position, context);
            callNextFragment();
            myApplication.showNotification("Parabéns, você finalizou o nivel " + (position - 1));
        } else {
            restartFragment();
            vibrar();
        }

    }

    private void editarPositionExercicio(int position, Context context) {
        myApplication = (MyApplication) context.getApplicationContext();
        if (myApplication.getPositionExercicio() < position) {
            myApplication.setPositionExercicio(position);
        }

        myApplication.updateDataBase();;
    }

    private void restartFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    protected void onCreateDialog(String title, String mensagem, int icon) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme);
        builder.setMessage(mensagem).setTitle(title).setIcon(icon);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected void vibrar() {
        Vibrator vibrator = (Vibrator) getActivity().getSystemService(VIBRATOR_SERVICE);
        long milliseconds = 700;
        vibrator.vibrate(milliseconds);
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

    protected void getTextDoEditText(int nivel) {
        switch (nivel) {
            case 3:
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
                break;
            case 4:
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
                num11 = mNum11.getText().toString();
                num12 = mNum12.getText().toString();
                num13 = mNum13.getText().toString();
                num14 = mNum14.getText().toString();
                num15 = mNum15.getText().toString();

                break;
        }


    }

    protected void createCartas() {
        carta01 = new Carta(R.id.carta1, R.mipmap.carta1, 1, true);
        carta02 = new Carta(R.id.carta2, R.mipmap.carta2, 2, true);
        carta04 = new Carta(R.id.carta4, R.mipmap.carta4, 4, true);
        carta08 = new Carta(R.id.carta8, R.mipmap.carta8, 8, true);
        carta16 = new Carta(R.id.carta16, R.mipmap.carta16, 16, true);

    }

    protected String montarNumerosET() {
        return mNum1.getText().toString() + " " + mNum2.getText().toString() + " " + mNum3.getText().toString() + " "
                + mNum4.getText().toString() + " " + mNum5.getText().toString() + " - " + mNum6.getText().toString() + " "
                + mNum7.getText().toString() + " " + mNum8.getText().toString() + " " + mNum9.getText().toString() + " "
                + mNum10.getText().toString() + " - " + mNum11.getText().toString() + " " + mNum12.getText().toString() + " "
                + mNum13.getText().toString() + " " + mNum14.getText().toString() + " " + mNum15.getText().toString();
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

    protected void initRadioGroups(View view) {

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

    protected void initPerguntas(View view) {
        perg1 = (TextView) view.findViewById(R.id.perg1);
        perg2 = (TextView) view.findViewById(R.id.perg2);
        perg3 = (TextView) view.findViewById(R.id.perg3);
    }


    protected void initNum(View view) {
        numTxt1 = (TextView) view.findViewById(R.id.num1);
        numTxt2 = (TextView) view.findViewById(R.id.num2);
        numTxt4 = (TextView) view.findViewById(R.id.num4);
        numTxt8 = (TextView) view.findViewById(R.id.num8);
        numTxt16 = (TextView) view.findViewById(R.id.num16);
    }

    protected void initCartas(View view) {
        mCarta1 = (ImageButton) view.findViewById(R.id.carta1);
        mCarta2 = (ImageButton) view.findViewById(R.id.carta2);
        mCarta4 = (ImageButton) view.findViewById(R.id.carta4);
        mCarta8 = (ImageButton) view.findViewById(R.id.carta8);
        mCarta16 = (ImageButton) view.findViewById(R.id.carta16);
    }

    protected void initButtons(View view) {
        mFinalizar = (Button) view.findViewById(R.id.finalizar);
        mDicas = (ImageButton) view.findViewById(R.id.dicas);
    }

    protected void initEditText(View view) {
        textInputLayout1 = (TextInputLayout) view.findViewById(R.id.textInputLayout);
        mTextoTraduzidoEMS = (TextInputEditText) view.findViewById(R.id.textoTraduzido);
        mTextoTraduzidoCEM = (TextInputEditText) view.findViewById(R.id.textoTraduzidoCem);
        mTextoNome = (TextInputEditText) view.findViewById(R.id.textoNome);


        mNum1 = (EditText) view.findViewById(R.id.num1);
        mNum2 = (EditText) view.findViewById(R.id.num2);
        mNum3 = (EditText) view.findViewById(R.id.num3);
        mNum4 = (EditText) view.findViewById(R.id.num4);
        mNum5 = (EditText) view.findViewById(R.id.num5);

        mNum6 = (EditText) view.findViewById(R.id.num6);
        mNum7 = (EditText) view.findViewById(R.id.num7);
        mNum8 = (EditText) view.findViewById(R.id.num8);
        mNum9 = (EditText) view.findViewById(R.id.num9);
        mNum10 = (EditText) view.findViewById(R.id.num10);

        mNum11 = (EditText) view.findViewById(R.id.num11);
        mNum12 = (EditText) view.findViewById(R.id.num12);
        mNum13 = (EditText) view.findViewById(R.id.num13);
        mNum14 = (EditText) view.findViewById(R.id.num14);
        mNum15 = (EditText) view.findViewById(R.id.num15);
    }


    protected void showAnimation(View view, Techniques techniques) {
        YoYo.with(techniques)
                .duration(3000)
                .repeat(0)
                .playOn(view);
    }

    protected abstract void initViews(View view);

    protected abstract boolean respostasIsEmpty();

    protected abstract boolean validarCampos();


}
