package com.tcc.projeto.appcomputacaoplugada.objetos;

public class Tabela {
    private String letra;
    private String numero;
    private String binario;

    public Tabela() {
    }


    public Tabela(String letra, String numero, String binario) {
        this.letra = letra;
        this.numero = numero;
        this.binario = binario;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBinario() {
        return binario;
    }

    public void setBinario(String binario) {
        this.binario = binario;
    }
}
