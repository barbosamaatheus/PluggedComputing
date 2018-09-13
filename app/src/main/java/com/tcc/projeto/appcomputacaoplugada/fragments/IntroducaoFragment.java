package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.objetos.Carta;

import java.util.ArrayList;
import java.util.List;

public class IntroducaoFragment extends Fragment {

    private ImageButton mCarta1, mCarta2, mCarta4, mCarta8, mCarta16;
    private TextView num1, num2, num4, num8, num16;
    private Carta carta01, carta02, carta04, carta08, carta16;
    private boolean passou1, passou2, passou3;

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

        return view;
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
        mCarta1 = (ImageButton) view.findViewById(R.id.carta1);
        mCarta2 = (ImageButton) view.findViewById(R.id.carta2);
        mCarta4 = (ImageButton) view.findViewById(R.id.carta4);
        mCarta8 = (ImageButton) view.findViewById(R.id.carta8);
        mCarta16 = (ImageButton) view.findViewById(R.id.carta16);
        num1 = (TextView) view.findViewById(R.id.num1);
        num2 = (TextView) view.findViewById(R.id.num2);
        num4 = (TextView) view.findViewById(R.id.num4);
        num8 = (TextView) view.findViewById(R.id.num8);
        num16 = (TextView) view.findViewById(R.id.num16);
        createCartas();
    }

    private void createCartas() {
        carta01 = new Carta(R.id.carta1, R.mipmap.carta1, 1, true);
        carta02 = new Carta(R.id.carta2, R.mipmap.carta2, 2, false);
        carta04 = new Carta(R.id.carta4, R.mipmap.carta4, 4, false);
        carta08 = new Carta(R.id.carta8, R.mipmap.carta8, 8, true);
        carta16 = new Carta(R.id.carta16, R.mipmap.carta16, 16, false);


    }

    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.certo1:
                if (checked)
                    passou1 = true;
                    break;
            case R.id.errado11:
                if (checked)
                    passou1 = false;
                    break;

            case R.id.errado12:
                if (checked)
                    passou1 = false;
                    break;
        }
    }

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.certo2:
                if (checked)
                    passou2 = true;
                    break;
            case R.id.errado21:
                if (checked)
                    passou2 = false;
                    break;

            case R.id.errado22:
                if (checked)
                    passou2 = false;
                    break;
        }
    }

    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.certo3:
                if (checked)
                    passou3 = true;
                    break;
            case R.id.errado31:
                if (checked)
                    passou3 = false;
                    break;

            case R.id.errado32:
                if (checked)
                    passou3 = false;
                    break;
        }
    }
}




