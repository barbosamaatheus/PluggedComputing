package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.adapter.TabelaAdapter;

import java.text.Normalizer;

public class CorreioEletronicoModemsFragment extends MyFragments {

    private TextView envinado, nomeBinario;
    private Button mEnviar;
    private String textoNome = "";
    private String textoTraduzido = "";
    private String textoBinario = "Primeiro envie seu nome para obter uma resposta";
    private ProgressBar pb;
    private int progressStatus, end;

    private Handler handler = new Handler();


    public CorreioEletronicoModemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_correio_eletronico_modems, container, false);
        initViews(view);
        initVerify();
        nomeBinario.setText(textoBinario);

        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog("Dicas", getString(R.string.dicas_cem),
                        5, getActivity());
            }
        });

        mEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTextoNome.getText().toString().isEmpty()){
                    onCreateDialog("Algo deu errado", "Parece que você esqueceu de digitar o seu nome",
                            5, getActivity());
                }else {
                    textoNome = mTextoNome.getText().toString();
                    nomeBinario.setVisibility(View.GONE);
                    envinado.setVisibility(View.VISIBLE);
                    showProgressBar();
                }

            }
        });

        mFinalizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                textoBinario = nomeBinario.getText().toString();
                if (respostasIsEmpty()) {
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta),
                            5, getActivity());
                } else {
                    validarCampos();
                    gerenciarResultados(5, getActivity());
                }
            }
        });
        return view;
    }


    @Override
    protected boolean respostasIsEmpty() {
        validarClicked1();
        boolean isEmpty;
        if (!checked1) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!validarTexto(textoTraduzido)) {
            focus = showError(mTextoTraduzidoCEM);
        }
        if (exibir) {
            vibrar();
            focus.requestFocus();
        }
        return exibir;
    }

    private void validarClicked1() {
        if (mTextoNome.getText().toString().isEmpty() || mTextoTraduzidoCEM.getText().toString().isEmpty()) {
            checked1 = false;
        } else {
            textoNome = mTextoNome.getText().toString();
            textoTraduzido = mTextoTraduzidoCEM.getText().toString();
            checked1 = true;
        }
        if (textoNome.isEmpty() || textoTraduzido.isEmpty()) {
            checked1 = false;
        } else {
            checked1 = true;
        }
    }

    private boolean validarTexto(String s) {
        if (removeAccents(s).equalsIgnoreCase("ola, " + removeAccents(textoNome))) {
            return true;
        }
        if (removeAccents(s).equalsIgnoreCase("olá, " + removeAccents(textoNome))) {
            return true;
        }
        return false;
    }

    private String converterBinario(String mTextoNome) {
        TabelaAdapter tabela = new TabelaAdapter();
        String nomeBinarios = "01111 01100 00001, ";
        for (int i = 0; i < mTextoNome.length(); i++) {
            nomeBinarios += tabela.obterBinarioDaLetra(mTextoNome.charAt(i) + "") + " ";
        }
        return nomeBinarios;
    }

    private void showProgressBar() {
        String textoConvertido = converterBinario(removeAccents(textoNome.replace(" ", "")));
        progressStatus = 0;
        end = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    // Update the progress status

                    progressStatus += 1;
                    // Try to sleep the thread for 20 milliseconds
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Update the progress bar
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb.setProgress(progressStatus);
                            // Show the progress on TextView
                            envinado.setText(progressStatus + "%");
                        }
                    });
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            nomeBinario.setText(textoConvertido);
                            nomeBinario.setVisibility(View.VISIBLE);
                        }
                    }, 1900);// Start the operation
                }
            }
        }).start();

    }

    private static String removeAccents(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("[^\\p{ASCII}]", "");
        return str;
    }

    @Override
    protected void initViews(View view) {
        initEditText(view);
        initTextView(view);
        initButtons(view);
        pb = (ProgressBar) view.findViewById(R.id.pb);
        mEnviar = (Button) view.findViewById(R.id.enviar);
    }



    private void initTextView(View view) {
        envinado = (TextView) view.findViewById(R.id.enviando);
        nomeBinario = (TextView) view.findViewById(R.id.nomeBinario);
    }
}
