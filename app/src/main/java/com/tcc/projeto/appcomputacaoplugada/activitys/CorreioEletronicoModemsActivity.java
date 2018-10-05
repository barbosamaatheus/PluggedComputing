package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.adapter.TabelaAdapter;

import java.text.Normalizer;

public class CorreioEletronicoModemsActivity extends TarefasManager {
    private TextView envinado, nomeBinario;
    private Button mEnviar;
    private String textoNome = "";
    private String textoTraduzido = "";
    private String textoBinario = "Primeiro envie seu nome para obter uma resposta";
    private ProgressBar pb;
    private int progressStatus, end;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correio_eletronico_modems);
        initViews();
        initVerify();
        nomeBinario.setText(textoBinario);

        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog("Dicas", getString(R.string.dicas_cem), R.drawable.ic_help_outline_black_24dp);
            }
        });

        mEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTextoNome.getText().toString().isEmpty()) {
                    onCreateDialog("Algo deu errado", "Parece que você esqueceu de digitar o seu nome", R.drawable.ic_error_outline_black_24dp);
                } else {
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
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta), R.drawable.ic_error_outline_black_24dp);
                } else {
                    validarCampos();
                    gerenciarResultados(5, getApplicationContext());
                }
            }
        });
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
            focus = showError(mTextoTraduzido);
        }
        if (exibir) {
            vibrar();
            focus.requestFocus();
        }
        return exibir;
    }

    private void validarClicked1() {
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
        if (removeAccents(s).equalsIgnoreCase("ola, " + textoNome)) {
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
    protected void initViews() {
        initEditText();
        initTextView();
        initButtons();
        pb = (ProgressBar) findViewById(R.id.pb);
        mEnviar = (Button) findViewById(R.id.enviar);
    }


    private void initTextView() {
        envinado = (TextView) findViewById(R.id.enviando);
        nomeBinario = (TextView) findViewById(R.id.nomeBinario);
    }
}
