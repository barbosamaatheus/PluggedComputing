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
import com.tcc.projeto.appcomputacaoplugada.objetos.Tabela;

import java.util.List;

public class CorreioEletronicoModemsFragment extends MyFragments {
    private TextView envinado, recebendo, nomeBinario, mensagemRecebida;
    private Button mEnviar;


    public CorreioEletronicoModemsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_correio_eletronico_modems, container, false);
        initViews(view);

        mTextoNome.addTextChangedListener (new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != -1){
                    nomeBinario.setText(converterBinario(mTextoNome));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        mEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    private String converterBinario(EditText mTextoNome) {
        String textoDigitado = mTextoNome.getText().toString();
        String nomeBinarios = "";
        List<Tabela> tabela = new TabelaAdapter().getTabela();
        for(int i = 0; i <textoDigitado.length(); i++){
            char letra = textoDigitado.charAt(i);
            for(Tabela t: tabela){
                if (t.getNumero() == (letra)){
                    nomeBinarios += t.getBinario();
                }
            }
        }
        return nomeBinarios;
    }

    @Override
    protected void initViews(View view){
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
        mensagemRecebida= (TextView) view.findViewById(R.id.mensagemRecebida);

    }

    @Override
    protected boolean respostasIsEmpty() {
        return false;
    }

    @Override
    protected boolean validarCampos() {
        return false;
    }
}
