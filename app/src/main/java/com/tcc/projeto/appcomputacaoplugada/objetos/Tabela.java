package com.tcc.projeto.appcomputacaoplugada.objetos;

public class Tabela {
    private char letra;
    private int numero;
    private double binario;

    public Tabela() {
    }


    public Tabela(char letra, int numero, double binario) {
        this.letra = letra;
        this.numero = numero;
        this.binario = binario;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getBinario() {
        return binario;
    }

    public void setBinario(double binario) {
        this.binario = binario;
    }
}
