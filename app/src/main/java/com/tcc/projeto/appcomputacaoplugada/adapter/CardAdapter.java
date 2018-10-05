package com.tcc.projeto.appcomputacaoplugada.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.RecyclerViewOnClickListener;
import com.tcc.projeto.appcomputacaoplugada.activitys.AtividadesActivity;
import com.tcc.projeto.appcomputacaoplugada.objetos.Atividade;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {
    private List<Atividade> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListener mRecyclerViewOnClickListener;

    public CardAdapter(AtividadesActivity atividadesActivity, List<Atividade> tarefas) {
        this.mList = tarefas;
        mLayoutInflater = (LayoutInflater) atividadesActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener r) {
        this.mRecyclerViewOnClickListener = r;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_card, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTitulo.setText(mList.get(position).getTitulo());
        holder.mSubTitulo.setText(mList.get(position).getSubTitulo());
        holder.mDescricao.setText(mList.get(position).getDescricao());
        holder.mMateria.setText(mList.get(position).getMaterias());
        holder.mHabilidades.setText(mList.get(position).getHabilidades());
        holder.mIdade.setText(mList.get(position).getIdade());
        showAnimation(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTitulo, mSubTitulo, mDescricao, mMateria, mHabilidades, mIdade;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitulo = (TextView) itemView.findViewById(R.id.tituloCW);
            mSubTitulo = (TextView) itemView.findViewById(R.id.subTituloCW);
            mDescricao = (TextView) itemView.findViewById(R.id.descCW);
            mMateria = (TextView) itemView.findViewById(R.id.materiasCW);
            mHabilidades = (TextView) itemView.findViewById(R.id.habilidadesCW);
            mIdade = (TextView) itemView.findViewById(R.id.idadeCW);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mRecyclerViewOnClickListener != null) {
                mRecyclerViewOnClickListener.onClickListener(view, getPosition());
            }

        }
    }
    private void showAnimation(View view) {
        YoYo.with(Techniques.Pulse)
                .duration(2000)
                .repeat(0)
                .playOn(view);
    }
}