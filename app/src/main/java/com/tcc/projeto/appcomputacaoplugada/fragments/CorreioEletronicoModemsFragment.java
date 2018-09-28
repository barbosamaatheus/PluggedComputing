package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcc.projeto.appcomputacaoplugada.R;

public class CorreioEletronicoModemsFragment extends MyFragments {


    public CorreioEletronicoModemsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_correio_eletronico_modems, container, false);

        return view;
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
