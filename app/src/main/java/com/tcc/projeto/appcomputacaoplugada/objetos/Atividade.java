package com.tcc.projeto.appcomputacaoplugada.objetos;

public class Atividade {

    private java.lang.String titulo, subTitulo ,descricao, materias, habilidades, idade;

    public Atividade() {
        this.titulo = "-";
        this.subTitulo = "-";
        this.descricao = "-";
        this.materias = "-";
        this.habilidades = "-";
        this.idade = "-";
    }

    public Atividade(java.lang.String titulo, java.lang.String subTitulo, java.lang.String descricao, java.lang.String materias, java.lang.String habilidades, java.lang.String idade) {
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.descricao = descricao;
        this.materias = materias;
        this.habilidades = habilidades;
        this.idade = idade;
    }

    public java.lang.String getTitulo() {
        return titulo;
    }

    public void setTitulo(java.lang.String titulo) {
        this.titulo = titulo;
    }

    public java.lang.String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(java.lang.String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public java.lang.String getDescricao() {
        return descricao;
    }

    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }

    public java.lang.String getMaterias() {
        return materias;
    }

    public void setMaterias(java.lang.String materias) {
        this.materias = materias;
    }

    public java.lang.String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(java.lang.String habilidades) {
        this.habilidades = habilidades;
    }

    public java.lang.String getIdade() {
        return idade;
    }

    public void setIdade(java.lang.String idade) {
        this.idade = idade;
    }
}
