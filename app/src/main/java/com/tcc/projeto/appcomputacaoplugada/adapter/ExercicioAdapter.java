package com.tcc.projeto.appcomputacaoplugada.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.RecyclerViewOnClickListener;
import com.tcc.projeto.appcomputacaoplugada.activitys.ExerciciosActivity;

public class ExercicioAdapter extends RecyclerView.Adapter<ExercicioAdapter.MyViewHolder> {
    private String[] mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListener mRecyclerViewOnClickListener;
    private int estado;

    public ExercicioAdapter(ExerciciosActivity aexerciciosActivity, String[] exercicios, int estado) {
        this.estado = estado;
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
        holder.mTitulo.setText(mList[position]);
        holder.mNivel.setText("Nivel "+position);
        if (position != 0) {
            holder.mCheck.setBackgroundResource(R.drawable.ic_lock_black_24dp);
        }
        if (position <= (estado - 1)) {
            holder.mCheck.setBackgroundResource(R.drawable.ic_check_black_24dp);
        }
        if (position == (estado)) {
            holder.mCheck.setVisibility(View.GONE);
            showAnimation(holder.itemView, Techniques.Pulse,2000, 2);
        }
        //showAnimation(holder.itemView, Techniques.ZoomIn);
    }

    @Override
    public int getItemCount() {
        return mList.length;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTitulo, mNivel;
        public ImageView mCheck;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitulo = (TextView) itemView.findViewById(R.id.tituloEX);
            mNivel = (TextView) itemView.findViewById(R.id.nivelEX);
            mCheck = (ImageView) itemView.findViewById(R.id.check);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mRecyclerViewOnClickListener != null) {
                mRecyclerViewOnClickListener.onClickListener(view, getPosition());
            }
        }
    }

    private void setVisibility(MyViewHolder holder) {
        holder.mCheck.setVisibility(View.VISIBLE);
    }
    private void showAnimation(View view, Techniques techniques, int duration, int repeat) {
        YoYo.with(techniques)
                .duration(duration)
                .repeat(repeat)
                .playOn(view);
    }
}