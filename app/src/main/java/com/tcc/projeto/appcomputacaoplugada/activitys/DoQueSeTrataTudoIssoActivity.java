package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tcc.projeto.appcomputacaoplugada.R;

public class DoQueSeTrataTudoIssoActivity extends TarefasManager {
    private Button mFormulario;
    private String textoTraduzido = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_que_se_trata_tudo_isso);
        initViews();
        initVerify();

        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog("Dicas", getString(R.string.dicas_tti), R.drawable.ic_help_outline_black_24dp);
            }
        });

        mFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "https://goo.gl/forms/J1mmJ4A0MRFQihvC3";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respostasIsEmpty()) {
                    vibrar();
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta), R.drawable.ic_error_outline_black_24dp);
                } else {
                    validarCampos();
                    gerenciarResultados(8, getApplicationContext());
                }
            }
        });
    }

    @Override
    protected void initViews() {
        textInputLayout1 = (TextInputLayout) findViewById(R.id.textInputLayoutTTI);
        mTextoTraduzido = (TextInputEditText) findViewById(R.id.textoTraduzidoTTI);
        mFormulario = (Button) findViewById(R.id.formulario);
        initButtons();
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

    private void validarClicked1() {
        if (mTextoTraduzido.getText().toString().isEmpty()) {
            checked1 = false;
        } else {
            textoTraduzido = mTextoTraduzido.getText().toString();
            checked1 = true;
        }
        if (textoTraduzido.isEmpty()) {
            checked1 = false;
        } else {
            checked1 = true;
        }
    }

    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!validarTexto(textoTraduzido)) {
            focus = showError(mTextoTraduzido);
        }
        if (exibir) {
            vibrar();
            focus.requestFocus();
        }
        return exibir;
    }

    private boolean validarTexto(String textoTraduzido) {
        if (textoTraduzido.equalsIgnoreCase("77096")) {
            return true;
        }
        return false;
    }
}
