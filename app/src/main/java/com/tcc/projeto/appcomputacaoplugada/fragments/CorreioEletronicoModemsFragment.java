package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.adapter.TabelaAdapter;

public class CorreioEletronicoModemsFragment extends MyFragments {
    private TextView envinado, recebendo, nomeBinario, mensagemRecebida;
    private Button mEnviar;
    private String textoNome = "";
    private String textoTraduzido = "";
    private String textoRecebido = "";


    public CorreioEletronicoModemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_correio_eletronico_modems, container, false);
        initViews(view);
        initVerify();
        mensagemRecebida.setText(textoRecebido);
        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog("Dicas", getString(R.string.dicas_cem), R.drawable.ic_help_outline_black_24dp);
            }
        });

        mTextoNome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1) {
                    nomeBinario.setText(converterBinario(charSequence));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        mEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envinado.setVisibility(View.VISIBLE);
                recebendo.setVisibility(View.VISIBLE);
                mensagemRecebida.setText(converterNumero(nomeBinario.getText().toString()));
            }
        });

        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoRecebido = mensagemRecebida.getText().toString();
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
        mDicas = (ImageButton) view.findViewById(R.id.dicasEMS);
        mTextoNome = (EditText) view.findViewById(R.id.textoNome);
        mTextoTraduzido = (EditText) view.findViewById(R.id.textoTraduzidoCem);
        mEnviar = (Button) view.findViewById(R.id.enviar);
        mFinalizar = (Button) view.findViewById(R.id.btn_finalizar_cem);
        initTextView(view);

    }

    private void initTextView(View view) {
        envinado = (TextView) view.findViewById(R.id.enviando);
        recebendo = (TextView) view.findViewById(R.id.recebendo);
        nomeBinario = (TextView) view.findViewById(R.id.nomeBinario);
        mensagemRecebida = (TextView) view.findViewById(R.id.mensagemRecebida);

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
        if (!validarTexto(mensagemRecebida.toString())) {
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
        if (textoTraduzido.equalsIgnoreCase("ola, " + textoNome)) {
            return true;
        }
        return false;
    }


    private String converterNumero(String s) {
        TabelaAdapter tabela = new TabelaAdapter();
        String nomeNumero = "15 12 1, ";
        int init = 0;
        int end = 5;
        for (int i = 0; i < mTextoNome.length(); i++) {
            nomeNumero += tabela.obterNumeroDoBinario(s.substring(init, end)) + " ";
            init = end;
            end += 5;
        }
        return nomeNumero;
    }

    private String converterBinario(CharSequence mTextoNome) {
        TabelaAdapter tabela = new TabelaAdapter();
        String nomeBinarios = "";
        for (int i = 0; i < mTextoNome.length(); i++) {
            nomeBinarios += tabela.obterBinarioDaLetra(mTextoNome.charAt(i) + "");
        }
        return nomeBinarios;
    }
}
