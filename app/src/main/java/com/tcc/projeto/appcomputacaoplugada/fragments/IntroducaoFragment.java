package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.activitys.ExerciciosActivity;
import com.tcc.projeto.appcomputacaoplugada.activitys.MainActivity;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;
import com.tcc.projeto.appcomputacaoplugada.objetos.Carta;

import java.util.ArrayList;
import java.util.List;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class IntroducaoFragment extends Fragment {

    private ImageButton mCarta1, mCarta2, mCarta4, mCarta8, mCarta16;
    private TextView num1, num2, num4, num8, num16;
    private RadioGroup radioGroup1, radioGroup2, radioGroup3;
    private RadioButton certo1, certo2, certo3, errado11, errado12, errado21, errado22, errado31, errado32;
    private Carta carta01, carta02, carta04, carta08, carta16;
    private TextView perg1, perg2, perg3;
    private Button finalizar;
    private boolean passou1 = true;
    private boolean passou2 = true;
    private boolean passou3 = true;
    private boolean checked1 = false;
    private boolean checked3 = false;
    private boolean checked2 = false;
    private boolean exibir;
    private MyApplication myApplication;


    public IntroducaoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introducao, container, false);

        initViews(view);
        validarCampos();

        mCarta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta01, num1, mCarta1);
            }
        });
        mCarta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta02, num2, mCarta2);

            }
        });
        mCarta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta04, num4, mCarta4);
            }
        });
        mCarta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta08, num8, mCarta8);
            }
        });
        mCarta16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta16, num16, mCarta16);
            }
        });
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
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respostasIsEmpty()){
                    onCreateDialog();
                }else {
                    validarCampos();
                    validarPerguntas();
                }
            }
        });
        return view;
    }

    private void validarPerguntas() {

        if (!exibir) {
            myApplication.setPositionExercicio(1);
            Intent intent = new Intent(getActivity().getApplicationContext(), ExerciciosActivity.class);
            startActivity(intent);
            //Toast.makeText(getContext().getApplicationContext(), "Sucesso", Toast.LENGTH_LONG).show();
        } else {
            restartFragment();
        }

    }

    private boolean respostasIsEmpty(){
        boolean isEmpty;
        if(!checked1 || !checked2 || !checked3){
            isEmpty = true;
        }else{
            isEmpty = false;
        }
        return isEmpty;
    }

    private boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!passou1) {
            perg1.setError("Resposta incorreta");
            focus = perg1;
            exibir = true;
        }
        if (!passou2) {
            perg2.setError("Resposta incorreta");
            focus = perg2;
            exibir = true;
        }
        if (!passou3) {
            perg3.setError("Resposta incorreta");
            focus = perg3;
            exibir = true;
        }
        if (exibir) {
            focus.requestFocus();
        }
        return exibir;
    }

    private void virarCarta(Carta carta, TextView num, ImageButton mCarta) {
        alterarEstadoCarta(carta);
        mCarta.setBackgroundResource(carta.getImagem());
        if (carta.isFrente()) {
            num.setText("1");
        } else {
            num.setText("0");
        }

    }

    private void alterarEstadoCarta(Carta carta) {
        if (carta.isFrente()) {
            carta.setFrente(false);
            carta.setImagem(R.mipmap.fundocarta);
        } else {
            carta.setFrente(true);
            mudarImagem(carta);
        }
    }

    private void mudarImagem(Carta carta) {
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

    private void initViews(View view) {
        myApplication = (MyApplication) getActivity().getApplicationContext();
        finalizar = (Button) view.findViewById(R.id.btn_finalizar);
        initCartas(view);
        initNum(view);
        createCartas();
        initRadioGroups(view);
        initPerguntas(view);

    }

    private void initPerguntas(View view) {
        perg1 = (TextView) view.findViewById(R.id.perg1_intro);
        perg2 = (TextView) view.findViewById(R.id.perg2_intro);
        perg3 = (TextView) view.findViewById(R.id.perg3_intro);
    }

    private void initRadioGroups(View view) {
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

    private void initNum(View view) {
        num1 = (TextView) view.findViewById(R.id.num1);
        num2 = (TextView) view.findViewById(R.id.num2);
        num4 = (TextView) view.findViewById(R.id.num4);
        num8 = (TextView) view.findViewById(R.id.num8);
        num16 = (TextView) view.findViewById(R.id.num16);
    }

    private void initCartas(View view) {
        mCarta1 = (ImageButton) view.findViewById(R.id.carta1);
        mCarta2 = (ImageButton) view.findViewById(R.id.carta2);
        mCarta4 = (ImageButton) view.findViewById(R.id.carta4);
        mCarta8 = (ImageButton) view.findViewById(R.id.carta8);
        mCarta16 = (ImageButton) view.findViewById(R.id.carta16);
    }

    private void createCartas() {
        carta01 = new Carta(R.id.carta1, R.mipmap.carta1, 1, true);
        carta02 = new Carta(R.id.carta2, R.mipmap.carta2, 2, false);
        carta04 = new Carta(R.id.carta4, R.mipmap.carta4, 4, false);
        carta08 = new Carta(R.id.carta8, R.mipmap.carta8, 8, true);
        carta16 = new Carta(R.id.carta16, R.mipmap.carta16, 16, false);


    }

    public void onRadioButtonClicked1(int checked) {
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

    public void onRadioButtonClicked2(int checked) {
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

    public void onRadioButtonClicked3(int checked) {
        checked3 = true;
        passou3 = false;
        switch (checked) {
            case R.id.certo3:
                passou3 = true;
                Log.d("onRadioButtonClicked3", "certo3");
                break;
            case R.id.errado31:
                Log.d("onRadioButtonClicked3", "errado31");
                passou3 = false;
                break;
            case R.id.errado32:
                Log.d("onRadioButtonClicked3", "errado32");
                passou3 = false;
                break;
        }
    }

    private void restartFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogStyle);
        builder.setMessage(R.string.texto_alert_sem_resposta).setTitle("Algo deu errado :(");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}