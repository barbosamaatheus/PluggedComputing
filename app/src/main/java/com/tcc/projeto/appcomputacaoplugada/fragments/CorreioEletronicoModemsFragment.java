package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.adapter.TabelaAdapter;

public class CorreioEletronicoModemsFragment extends MyFragments {
    private TextInputLayout textInputLayout1, textInputLayout2;
    private TextInputEditText mTextoTraduzido;
    private TextView envinado, nomeBinario;
    private Button mEnviar;
    private String textoNome = "";
    private String textoTraduzido = "";
    private String textoRecebido = "";
    private ProgressBar pb;
    private int progressStatus = 0;
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
        nomeBinario.setText(textoRecebido);
        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog("Dicas", getString(R.string.dicas_cem), R.drawable.ic_help_outline_black_24dp);
            }
        });

        mEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoNome = mTextoNome.getText().toString();
                envinado.setVisibility(View.VISIBLE);
                showProgressBar();
            }
        });

        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoRecebido = nomeBinario.getText().toString();
                if (respostasIsEmpty()) {
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta), R.drawable.ic_error_outline_black_24dp);
                } else {
                    validarCampos();
                    gerenciarResultados(5, getActivity());
                }
            }
        });
        return view;
    }

    @Override
    protected void initViews(View view) {
        initEditTexts(view);
        initTextView(view);
        pb = (ProgressBar) view.findViewById(R.id.pb);
        mDicas = (ImageButton) view.findViewById(R.id.dicasCEM);
        mEnviar = (Button) view.findViewById(R.id.enviar);
        mFinalizar = (Button) view.findViewById(R.id.btn_finalizar_cem);
    }

    private void initEditTexts(View view) {
        textInputLayout1 = (TextInputLayout) view.findViewById(R.id.textInputLayout1);
        textInputLayout2 = (TextInputLayout) view.findViewById(R.id.textInputLayout2);
        mTextoTraduzido = (TextInputEditText) view.findViewById(R.id.textoTraduzidoCem);
        mTextoNome = (TextInputEditText) view.findViewById(R.id.textoNome);
    }

    private void initTextView(View view) {
        envinado = (TextView) view.findViewById(R.id.enviando);
        nomeBinario = (TextView) view.findViewById(R.id.nomeBinario);
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
        if(!validarTexto(textoTraduzido)){
            mTextoTraduzido.setError(getString(R.string.resposta_incorreta));
            focus = mTextoTraduzido;
            exibir = true;
        }
        if (exibir) {
            focus.requestFocus();
        }
        return exibir;
    }

    public void validarClicked1() {
        if (mTextoNome.getText().toString().isEmpty() || mTextoTraduzido.getText().toString().isEmpty()) {
            checked1 = false;
        } else {
            textoNome = mTextoNome.getText().toString();
            textoTraduzido = mTextoTraduzido.getText().toString();
            checked1 = true;
        }
        if (textoNome.isEmpty() || textoTraduzido.isEmpty()) {
            checked1 = false;
        } else {
            checked1 = true;
        }
    }

    private boolean validarTexto(String s) {
        if (s.equalsIgnoreCase("ola, " + textoNome)) {
            return true;
        }
        return false;
    }

    private String converterBinario(String mTextoNome) {
        TabelaAdapter tabela = new TabelaAdapter();
        String nomeBinarios = "01111 01100 00001, ";
        for (int i = 0; i < mTextoNome.length(); i++) {
            nomeBinarios += tabela.obterBinarioDaLetra(mTextoNome.charAt(i)+"")+" ";
        }
        return nomeBinarios;
    }

    private void showProgressBar() {
        progressStatus = 0;
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
                }
                nomeBinario.setText(converterBinario(textoNome.toString()));

            }
        }).start();// Start the operation

    }
}
