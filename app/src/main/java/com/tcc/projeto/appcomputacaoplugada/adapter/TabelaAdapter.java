package com.tcc.projeto.appcomputacaoplugada.adapter;

import com.tcc.projeto.appcomputacaoplugada.objetos.Tabela;

import java.util.ArrayList;
import java.util.List;

public class TabelaAdapter {
    private List<Tabela> tabela = new ArrayList<Tabela>();

    public TabelaAdapter() {
        gerarTabela();
    }

    public List<Tabela> getTabela() {
        return this.tabela;
    }

    private void gerarTabela() {
        tabela.add(new Tabela("0", "0", "00000"));
        tabela.add(new Tabela("a", "1", "00001"));
        tabela.add(new Tabela("b", "2", "00010"));
        tabela.add(new Tabela("c", "3", "00011"));
        tabela.add(new Tabela("d", "4", "00100"));
        tabela.add(new Tabela("e", "5", "00101"));
        tabela.add(new Tabela("f", "6", "00110"));
        tabela.add(new Tabela("g", "7", "00111"));
        tabela.add(new Tabela("h", "8", "01000"));
        tabela.add(new Tabela("i", "9", "01001"));
        tabela.add(new Tabela("j", "10", "01010"));
        tabela.add(new Tabela("k", "11", "01011"));
        tabela.add(new Tabela("l", "12", "01100"));
        tabela.add(new Tabela("m", "13", "01101"));
        tabela.add(new Tabela("n", "14", "01110"));
        tabela.add(new Tabela("o", "15", "01111"));
        tabela.add(new Tabela("p", "16", "10000"));
        tabela.add(new Tabela("q", "17", "10001"));
        tabela.add(new Tabela("r", "18", "10010"));
        tabela.add(new Tabela("s", "19", "10011"));
        tabela.add(new Tabela("t", "20", "10100"));
        tabela.add(new Tabela("u", "21", "10101"));
        tabela.add(new Tabela("v", "22", "10110"));
        tabela.add(new Tabela("w", "23", "10111"));
        tabela.add(new Tabela("x", "24", "11000"));
        tabela.add(new Tabela("y", "25", "11001"));
        tabela.add(new Tabela("z", "26", "11010"));
        tabela.add(new Tabela("27", "27", "11011"));
        tabela.add(new Tabela("28", "28", "11100"));
        tabela.add(new Tabela("29", "29", "11101"));
        tabela.add(new Tabela("30", "30", "11110"));
        tabela.add(new Tabela("31", "31", "11111"));
    }

    public String obterBinarioDaLetra(String letra) {
        for (Tabela tabela : tabela) {
            if (tabela.getLetra().equalsIgnoreCase(letra)) {
                return tabela.getBinario();
            }
        }
        return null;
    }

    public String obterNumeroDoBinario(String binario) {
        for (Tabela tabela : tabela) {
            if (tabela.getBinario().equalsIgnoreCase(binario)) {
                return tabela.getNumero();
            }
        }
        return null;
    }

    public String obterLetraDoNumero(String numero) {
        for (Tabela tabela : tabela) {
            if (tabela.getNumero().equalsIgnoreCase(numero)) {
                return tabela.getLetra();
            }
        }
        return null;
    }
}
