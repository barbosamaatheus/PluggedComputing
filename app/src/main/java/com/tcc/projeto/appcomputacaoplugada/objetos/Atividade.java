package com.tcc.projeto.appcomputacaoplugada.objetos;

public class Atividade {

    private String titulo, subTitulo ,descricao, materias, habilidades, idade;

    public Atividade() {
        this.titulo = "-";
        this.subTitulo = "-";
        this.descricao = "-";
        this.materias = "-";
        this.habilidades = "-";
        this.idade = "-";
    }

    public Atividade(String titulo, String subTitulo, String descricao, String materias, String habilidades, String idade) {
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.descricao = descricao;
        this.materias = materias;
        this.habilidades = habilidades;
        this.idade = idade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }

    public String getMaterias() {
        return materias;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
