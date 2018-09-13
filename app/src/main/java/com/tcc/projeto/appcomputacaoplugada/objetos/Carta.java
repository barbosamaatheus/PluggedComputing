package com.tcc.projeto.appcomputacaoplugada.objetos;

public class Carta {
    private int id;
    private int imagem;
    private int numero;
    private boolean frente;


    public Carta() {
        frente = true;
    }

    public Carta(int id, int imagem, int numero, boolean frente) {
        this.id = id;
        this.imagem = imagem;
        this.frente = frente;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public boolean isFrente() {
        return frente;
    }

    public void setFrente(boolean frente) {
        this.frente = frente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
