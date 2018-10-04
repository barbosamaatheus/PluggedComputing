package com.tcc.projeto.appcomputacaoplugada.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcc.projeto.appcomputacaoplugada.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaisSobreNumerosBinariosFragment extends MyFragments {


    public MaisSobreNumerosBinariosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mais_sobre_numeros_binarios, container, false);


        return view;
    }

    @Override
    protected void initViews(View view) {

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
