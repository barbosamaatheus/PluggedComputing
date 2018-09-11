package com.tcc.projeto.appcomputacaoplugada.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.RecyclerViewOnClickListener;
import com.tcc.projeto.appcomputacaoplugada.activitys.ExerciciosActivity;
import com.tcc.projeto.appcomputacaoplugada.objetos.Atividade;
import com.tcc.projeto.appcomputacaoplugada.objetos.Exercicio;

import java.util.List;

public class ExercicioAdapter extends RecyclerView.Adapter<ExercicioAdapter.MyViewHolder> {
    private List<Exercicio> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListener mRecyclerViewOnClickListener;

    public ExercicioAdapter(ExerciciosActivity aexerciciosActivity, List<Exercicio> exercicios) {
        this.mList = exercicios;
        mLayoutInflater = (LayoutInflater) aexerciciosActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener r) {
        this.mRecyclerViewOnClickListener = r;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_list, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTitulo.setText(mList.get(position).getTitulo());
        Log.d("onBindViewHolder", "position " + position);
        Log.d("onBindViewHolder", "getTituloEX " + mList.get(position).getTitulo());
    }

    @Override
    public int getItemCount() {
        Log.d("onBindViewHolder", "Tamanho [] " + mList.size());
        return mList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTitulo;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitulo = (TextView) itemView.findViewById(R.id.tituloEX);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mRecyclerViewOnClickListener != null) {
                mRecyclerViewOnClickListener.onClickListener(view, getPosition());
            }

        }
    }
}