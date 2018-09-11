package com.tcc.projeto.appcomputacaoplugada.objetos;

public class Exercicio {
    private String titulo;

    public Exercicio(String titulo) {
        this.titulo = titulo;
    }
    public Exercicio() {
        this.titulo = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
